package com.jelly.qiniu.study.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:qiniu.properties"},ignoreResourceNotFound = true)
public class QiniuUtil {

    @Value("${accessKey}")
    private String accessKey;

    @Value("${secretKey}")
    private String secretKey;

    @Value("${bucket}")
    private String bucket;

    public void  fileUpload(String filePath){
        Configuration configuration=new Configuration(Zone.autoZone());
        UploadManager uploadManager=new UploadManager(configuration);
        String key=null;
        System.out.println(secretKey);
        Auth auth=Auth.create(accessKey,secretKey);

        String upToken=auth.uploadToken(bucket);
        try {
            Response response=uploadManager.put(filePath,key,upToken);
            DefaultPutRet putRet=new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException e) {
           Response res=e.response;
            System.err.println(res.toString());
            try {
                System.out.println(res.bodyString());
            } catch (QiniuException e1) {
                e1.printStackTrace();
            }
        }


    }

    public  void arrUpload(String str){

    }
}
