package com.jelly.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wu on 2018/8/29.
 */
public class OKHttpUtil {
    public static String SendByGet(String url) throws IOException {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Response response=okHttpClient.newCall(request).execute();
        return  response.body().string();
    }
    public static String SendByGet(String url, Map map) throws IOException {
        String params="?";
        if(map!=null){
           Set<Map.Entry> entries= map.entrySet();
            for (Map.Entry entry:entries){
               params+=entry.getKey()+"="+ entry.getValue()+"&";
            }

        }
        params=params.substring(0,params.lastIndexOf("&"));
        url=url+params;
        System.out.println(url);
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Response response=okHttpClient.newCall(request).execute();
        return  response.body().string();
    }

    public static String SendByPost(String url,String json) throws IOException {
       OkHttpClient okHttpClient =new OkHttpClient();
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json;charset=utf-8"),json);
        Request request=new Request.Builder().url(url).post(requestBody).build();
        Response response=okHttpClient.newCall(request).execute();
        return  response.body().string();
    }
    public static void main(String[] args) throws IOException {
        String  URL="https://www.apiopen.top/satinGodApi";
        Map map=new HashMap();
        map.put("type",1);
        map.put("page",1);
       String str= OKHttpUtil.SendByGet(URL,map);

        System.out.println(str);
    }
}
