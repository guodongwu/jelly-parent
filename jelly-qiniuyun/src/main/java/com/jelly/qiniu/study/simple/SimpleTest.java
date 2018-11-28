package com.jelly.qiniu.study.simple;

import com.jelly.qiniu.study.config.AppConfig;
import com.jelly.qiniu.study.utils.QiniuUtil;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleTest {
   @Test
    public void  SimpleTest2(){
       AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        QiniuUtil qiniuUtil=context.getBean(QiniuUtil.class);
       String filepath="/home/wu/Firefox_wallpaper.png";
       qiniuUtil.fileUpload(filepath);
   }


}
