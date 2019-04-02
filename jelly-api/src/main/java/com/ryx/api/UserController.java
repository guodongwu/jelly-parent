package com.ryx.api;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.ryx.common.BaseController;
import com.ryx.exception.MyException;
import com.ryx.ryxrzt.entity.UserInfo;
import com.ryx.ryxrzt.service.UserInfoService;
import com.ryx.ryxrzt.vo.UserLoginVo;
import com.ryx.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户登录
 */
@RestController
public class UserController extends BaseController {
    private final Pattern p = Pattern.compile("\\s*|\t|\r|\n");
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/unauth")
    public JsonResult unauth(){
        JsonResult result = new JsonResult();
        result.setCode(ConstantUtil.USER_CODE);
        result.setMsg("尚未登录");
        return result;
    }
    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private DefaultKaptcha producer;
    @Autowired
    private CaptchaUtil captchaUtil;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody UserLoginVo userLoginVo, HttpServletResponse response) {
        JsonResult result;
        //1.判断验证码
        if(StringUtils.isBlank(userLoginVo.getcToken())){
           result=JsonResult.FAIL();
           result.setMsg("请输入验证码！");
           return  result;
        }
        String cKey = String.format(ConstantUtil.CAPTCHA_TOKEN+userLoginVo.getcToken());
        if(jedisUtil.exists(cKey)){
            String code=jedisUtil.get(cKey).toString().toLowerCase();
            if(!code.equals(userLoginVo.getCaptcha().toLowerCase())){
                result=JsonResult.FAIL();
                result.setMsg("验证码输入错误！");
                return  result;
            }
        }else{
            result=JsonResult.FAIL();
            result.setMsg("请输入验证码！");
            return  result;
        }

        //2.获取用户信息
        try {
            result = new JsonResult();
            logger.info("login:"+userLoginVo.toString());
            UserInfo userInfo = userInfoService.findByLoginName(userLoginVo.getUsername());
            if (userInfo == null) {
                result.setCode(ConstantUtil.USER_CODE);
                result.setMsg("用户名或密码错误!");
                return result;
            }
            String pass = MD5Util.getPassWordSecret(userLoginVo.getPassword(), userInfo.getId());
            if (!userInfo.getPassword().equals(pass)) {
                result.setCode(ConstantUtil.USER_CODE);
                result.setMsg("用户名或密码错误!");
                return result;
            }
            if(!userInfo.getStatus().equals("1")){
                result.setCode(ConstantUtil.USER_CODE);
                result.setMsg("账户被锁定!");
                return result;
            }

            if (jedisUtil.exists(ConstantUtil.PREFIX_SHIRO_CACHE +userInfo.getLoginName())) {
                jedisUtil.delKey(ConstantUtil.PREFIX_SHIRO_CACHE + userInfo.getLoginName());
            }
            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
            jedisUtil.set(ConstantUtil.PREFIX_SHIRO_REFRESH_TOKEN + userInfo.getLoginName(), currentTimeMillis, JwtUtil.REFRESHTOKENEXPIRETIME);
            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
            String token = JwtUtil.sign(userInfo.getLoginName(), currentTimeMillis);
            response.setHeader("Authorization", token);
            response.setHeader("Access-Control-Expose-Headers", "Authorization");
            result.setCode(ConstantUtil.SUCCESS_CODE);
            result.setResult(token);
            result.setMsg("登录成功!");
        } catch (Exception e){
            throw  new MyException("登录失败");
        }
        return result;
    }
    @RequestMapping(value = "/captcha",method = RequestMethod.POST)
    public JsonResult captcha(HttpServletResponse response) throws IOException {
        // 生成文字验证码
        String text = producer.createText();
        logger.info("验证码："+text);
        // 生成图片验证码
        ByteArrayOutputStream outputStream = null;
        BufferedImage image = producer.createImage(text);
        outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        // 生成captcha的token
        Map<String, Object> map = captchaUtil.createToken(text);
        //返回token和图片
        String base64Str=encoder.encode(outputStream.toByteArray());
        Matcher m = p.matcher(base64Str);
        String dest = m.replaceAll("");
        map.put("img",dest);
      /*  //删除
        map.put("captcha",text);*/
        JsonResult jsonResult=JsonResult.SUCCESS();
        jsonResult.setResult(map);
        return jsonResult;
    }


    @RequiresPermissions("user-info:updatePwd")
    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
    public JsonResult updatePwd(@RequestBody UserInfo userInfo){
        return userInfoService.updatePwd(userInfo);
    }

    @PostMapping("/logout")
    public JsonResult logout(@RequestBody UserLoginVo userLoginVo){
        if (jedisUtil.exists(ConstantUtil.PREFIX_SHIRO_ACCOUNT +userLoginVo.getUsername())) {
            jedisUtil.delKey(ConstantUtil.PREFIX_SHIRO_ACCOUNT+userLoginVo.getUsername());
        }
        if(jedisUtil.exists(ConstantUtil.PREFIX_SHIRO_REFRESH_TOKEN+userLoginVo.getUsername())){
            jedisUtil.delKey(ConstantUtil.PREFIX_SHIRO_REFRESH_TOKEN+userLoginVo.getUsername());
        }
        JsonResult jsonResult=new JsonResult();
        jsonResult.setCode("0000");
        jsonResult.setMsg("您已经安全登出");
        return jsonResult;

    }

}
