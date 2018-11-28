package com.jelly.qiniu.study.config;

import com.jelly.qiniu.study.utils.QiniuUtil;
import com.qiniu.common.Zone;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.jelly.qiniu.study")
public class AppConfig {



    @Bean
    public QiniuUtil  qiniuUtil(){
        return new QiniuUtil();
    }

}
