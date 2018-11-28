package com.jelly.ssm.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
@Controller
@RequestMapping("/captcha")
@Slf4j
public class CaptchaController {
    @Autowired
    private Producer producer;
    @GetMapping(value = "/getCaptcha")
    public  String getCaptcha(Model model){
        model.addAttribute("timestamp",System.currentTimeMillis());
        return  "captcha";
    }
    @GetMapping("/getCaptchaImage.jpg")
    public void getCaptchaImage(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "timestamp",required = false) String timestamp ) throws IOException {
        if(StringUtils.isBlank(timestamp)){
            model.addAttribute("timestamp",System.currentTimeMillis());

        }else{
            model.addAttribute("timestamp",timestamp);
        }
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = producer.createText();
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,capText);
        BufferedImage bi=producer.createImage(capText);
        ServletOutputStream out= null;
        try {
            out = response.getOutputStream();
            ImageIO.write(bi,"jpg",out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }

    }

    @PostMapping("/checkCaptcha")
    @ResponseBody
     public  String checkCaptcha(@RequestParam(value = "timestamp",required = false)String timestamp,@RequestParam(value = "code",required = false)String code,HttpServletRequest request,HttpServletResponse response){
        boolean returnStr=false;
        String original= (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        log.info("original:"+original);
        log.info("code:"+code);
        if(StringUtils.isNoneBlank(code)){
            if(code.equalsIgnoreCase(original)){
                returnStr=true;
            }
        }
        return String.valueOf(returnStr);
    }
}
