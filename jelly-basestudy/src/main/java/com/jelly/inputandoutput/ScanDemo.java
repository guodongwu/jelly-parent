package com.jelly.inputandoutput;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 * Demo class
 * @author  wu
 * @date  2018.11.2
 */
public class ScanDemo {
    /**
     * 输入测试
     */
    public  static void InputTest(){
        Scanner scanner=new Scanner(System.in);
        do {
            String str=scanner.nextLine();
            System.out.println("Who is "+str+"? It`s not Tom!");
        }while (!scanner.hasNext("Tom"));
        //next nextLine
        String name=scanner.next();
        System.out.println("Yes there is  "+name);
        boolean hasNext=scanner.hasNext("nn");
        System.out.println(hasNext);

    }

    public  static  void FileTest(){
        InputStream inputStream = ScanDemo.class.getClassLoader().getResourceAsStream("scanner.txt");
        Scanner scanner=new Scanner(inputStream,"UTF-8");
        StringBuffer sb=new StringBuffer();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
        }
        System.out.println(sb.toString());
    }

    /**
     * char byte short int
     * jdk 1.7 : string
     */
    public  static  void SwitchTest(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("选择 1,2,3,4");
        int num=scanner.nextInt();
        switch (num){
            case 1:
                System.out.println("1");
                break;
            default:
                System.out.println(num);
                break;
        }
        System.out.println("输入 a,b,c,d");
        String str=scanner.next();
        switch (str){
            case "a":
            case "A":
                System.out.println(str);
                break;
            default:
                System.out.println("呵呵");
                break;
        }
    }
    public static void main(String[] args) {
        SwitchTest();
        FileTest();
        InputTest();

    }
}
