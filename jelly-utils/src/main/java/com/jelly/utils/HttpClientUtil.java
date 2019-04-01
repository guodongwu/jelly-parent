package com.jelly.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wu on 2018/8/29.
 */
public class HttpClientUtil {
    /**
     * @param url
     * @param map
     * @return
     * url:请求地址
     * map:请求参数
     * Get有参请求
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static String Get(String url, Map<String,String> map)
            throws ClientProtocolException, IOException{
        String resultStr = null;
        if(map==null){
            return resultStr;
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //给参数赋值
            //gson.toJson(entry.getValue())
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        String paramStr = EntityUtils.toString(new UrlEncodedFormEntity(formparams, Consts.UTF_8));
        HttpGet httpget = new HttpGet(url+"?"+paramStr);
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity responseEntity = response.getEntity();
        if(responseEntity != null){
            resultStr = EntityUtils.toString(responseEntity);
        }
        if(httpclient!=null){
            httpclient.close();
        }
        if(response!=null){
            response.close();
        }
        return resultStr;
    }
    /**
     * @param url
     * @param map
     * @return
     * url:请求地址
     * map:请求参数
     * Post有参请求
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static String Post(String url, Map<String,String> map)
            throws ClientProtocolException, IOException {
        if(map==null){
            return null;
        }
        String resultStr = null;
        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //给参数赋值
            //gson.toJson(entry.getValue())
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        //System.out.println(EntityUtils.toString(entity));
        //2.生成一个post请求
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(entity);
        //3.执行post请求并返回结果
        CloseableHttpResponse response = httpclient.execute(httppost);
        //4.处理结果，这里将结果返回为字符串
        HttpEntity responseEntity = response.getEntity();
        if(responseEntity != null){
            resultStr = EntityUtils.toString(responseEntity);
        }
        if(httpclient!=null){
            httpclient.close();
        }
        if(response!=null){
            response.close();
        }
        return resultStr;
    }
    /**
     * 发送HttpGet请求
     * @param url
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     * Get无参请求
     */
    public static String Get(String url) throws ClientProtocolException, IOException {
        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2.生成一个get请求
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        //3.执行get请求并返回结果
        response = httpclient.execute(httpget);
        String result = null;
        //4.处理结果，这里将结果返回为字符串
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            result = EntityUtils.toString(entity);
        }
        if(httpclient!=null){
            httpclient.close();
        }
        if(response!=null){
            response.close();
        }
        return result;
    }
    /**
     * @param url
     * @param json
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * 发送json 数据 http client
     */
    public static String Json2Post(String url, String json)
            throws ClientProtocolException, IOException{
        if(StringUtils.isEmpty(json)){
            return null;
        }
        String resultStr = null;
        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        StringEntity postingString = new StringEntity(json, Consts.UTF_8);// json传递
        postingString.setContentEncoding("UTF-8");
        postingString.setContentType("application/json");
        System.out.println(EntityUtils.toString(postingString));
        //2.生成一个post请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(postingString);
        //3.执行post请求并返回结果
        CloseableHttpResponse response = httpclient.execute(httpPost);
        //4.处理结果，这里将结果返回为字符串
        HttpEntity responseEntity = response.getEntity();
        if(responseEntity != null){
            resultStr = EntityUtils.toString(responseEntity);
        }
        if(httpclient!=null){
            httpclient.close();
        }
        if(response!=null){
            response.close();
        }
        return resultStr;
    }

}
