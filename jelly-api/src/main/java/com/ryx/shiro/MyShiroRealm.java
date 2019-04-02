package com.ryx.shiro;

import com.alibaba.fastjson.JSON;
import com.ryx.exception.MyException;
import com.ryx.ryxrzt.entity.RoleAndMenu;
import com.ryx.ryxrzt.entity.UserInfo;
import com.ryx.ryxrzt.entity.UserInfoExample;
import com.ryx.ryxrzt.mapper.RoleAndMenuMapper;
import com.ryx.ryxrzt.mapper.UserInfoMapper;
import com.ryx.shiro.jwt.JwtToken;
import com.ryx.utils.Base64ConvertUtil;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.JedisUtil;
import com.ryx.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义Realm
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static Logger log = LoggerFactory.getLogger(MyShiroRealm.class);



    @Autowired
    private RoleAndMenuMapper roleAndMenuMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Autowired
    private  JedisUtil jedisUtil;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取用户
        String account = JwtUtil.getClaim(principals.toString(), ConstantUtil.ACCOUNT);
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName(account);
        List<RoleAndMenu> menupermissions = roleAndMenuMapper.selectPermissionByLoginName(userInfo);

        Set<String> permissions = new HashSet<>();

        for (RoleAndMenu menu : menupermissions) {
            if (StringUtils.isNotBlank(menu.getPermission())) {
                permissions.add(menu.getPermission());
            }
        }
        Set<String> roles = new HashSet<>();
        if (menupermissions.size() > 0) {
            roles.add(menupermissions.get(0).getRoleId());
        }
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        log.debug("权限信息: \n{}", permissions.toString());
        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String account = JwtUtil.getClaim(token,ConstantUtil.ACCOUNT);
        // 帐号为空
        if (StringUtils.isBlank(account)) {
            throw new AuthenticationException("Token中帐号为空(The account in Token is empty.)");
        }

        Object user=jedisUtil.get(ConstantUtil.PREFIX_SHIRO_ACCOUNT+account);
        UserInfo userinfo;
        if(user==null){
            UserInfoExample example = new UserInfoExample();
            UserInfoExample.Criteria criteria = example.createCriteria();
            criteria.andLoginNameEqualTo(account);
            List<UserInfo> list = userInfoMapper.selectByExample(example);
            if (list == null || list.size() == 0) {
                //没找到帐号
                throw new UnknownAccountException();
            }
            userinfo = list.get(0);
            userinfo.setPassword("");
            String json= JSON.toJSONString(userinfo);
            json= Base64ConvertUtil.encode(json);
            jedisUtil.set(ConstantUtil.PREFIX_SHIRO_ACCOUNT+account,json,JwtUtil.REFRESHTOKENEXPIRETIME);
        }else{
            try {
                String toUser = Base64ConvertUtil.decode(user.toString());
                userinfo = JSON.parseObject(toUser, UserInfo.class);
            }catch (Exception e){
                throw new MyException("系统错误,请稍后再试");
            }
        }
        //账户不可用
        if (!"1".equals(userinfo.getStatus())) {
            throw new LockedAccountException();
        }
        log.info("MyShiroRealm:"+ConstantUtil.PREFIX_SHIRO_REFRESH_TOKEN + account);
        boolean hasJwt=JwtUtil.verify(token);
        boolean hasJedis=jedisUtil.exists(ConstantUtil.PREFIX_SHIRO_REFRESH_TOKEN + account);
        log.info("MyShiroRealm:"+hasJwt+";"+hasJedis);
        if (hasJwt && hasJedis) {
            // 获取RefreshToken的时间戳
            String currentTimeMillisRedis = jedisUtil.get(ConstantUtil.PREFIX_SHIRO_REFRESH_TOKEN + account).toString();
            // 获取AccessToken时间戳，与RefreshToken的时间戳对比
            if (JwtUtil.getClaim(token, ConstantUtil.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
                return new SimpleAuthenticationInfo(token, token, "myShiroRealm");
            }
        }
        throw new AuthenticationException("Token已过期(Token expired or incorrect.)");


    }


    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        log.debug("clearCachedAuthorizationInfo");
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        String credentials = "eabd8ce9404507aa8c22714d3f5eada9";
        int hashIterations = 1024;
        Object obj = new SimpleHash(hashAlgorithmName, credentials, ByteSource.Util.bytes("89"), hashIterations);
        System.out.println(obj);
    }
}
