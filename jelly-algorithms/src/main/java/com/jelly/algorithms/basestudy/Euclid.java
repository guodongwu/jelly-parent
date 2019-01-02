package com.jelly.algorithms.basestudy;

import java.io.InputStream;
import java.util.Scanner;

/**
 * 欧几里得算法  求取最大公约数
 * 欧几里德算法又称辗转相除法，
 * 用于计算两个整数a,b的最大公约数
 *
 */
public class Euclid {
    public static void main(String[] args) {
        InputStream inputStream=System.in;
        Scanner scanner=new Scanner(inputStream);
        System.out.println("请输入俩个整数,-1退出");
        while (true) {
            try {
            System.out.println("请输入第一个整数");
            int p = scanner.nextInt();
            if(p==-1) break;
            System.out.println("请输入第二个整数");
            int q = scanner.nextInt();
            System.out.println(gcd(p, q));
            }catch (Exception e){
                System.out.println("类型转换错误!");
                break;
            }

        }
    }
    public static  int gcd(int p,int q){
        if(q==0) return  p;
        int r=p%q;
        return gcd(q,r);
    }

}
