package com.jelly.utils;

import java.util.UUID;

/**
 * Created by wu on 2018/9/8.
 */
public class Constant {
    public  static  final String JWT_ID= UUID.randomUUID().toString();
    public  static  final  String JWT_SECRET="meiyoumimazuianquan";
    public  static  final  int JWT_TTL=60*60*1000;
    public static  final  String ISSUSER="sys";
    private static final String EXP = "exp";
    public static  final  String PAYLOAD="payload";
}
