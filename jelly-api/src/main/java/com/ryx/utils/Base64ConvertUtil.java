package com.ryx.utils;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
/**
 * Base64工具
 * @author RYX
 * @date 2018/8/21 15:14
 */
public class Base64ConvertUtil {

    /**
     * 加密JDK1.7
     * @param str
     * @return java.lang.String
     * @author RYX
     * @date 2018/8/21 15:28
     */
    public static String encode(String str) {
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        str = new sun.misc.BASE64Encoder().encode(bytes);
        return str;
    }

    /**
     *
     * @param str
     * @return java.lang.String
     * @author RYX
     * @date 2018/8/21 15:28
     */
    public static String decode(String str) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(str);
            str = new String(b,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(encode("www.ruiyinxin.com"));

    }

}
