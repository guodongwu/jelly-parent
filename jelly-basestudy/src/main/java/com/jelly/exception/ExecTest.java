package com.jelly.exception;

public class ExecTest {
    public static void main(String[] args) {
        try{
            for (int i=0;i<10;i++){
                if(i%2!=0){
                    throw  new Exception("abc");
                }else
                {
                    System.out.println(i);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("heh ");
        }
    }
}
