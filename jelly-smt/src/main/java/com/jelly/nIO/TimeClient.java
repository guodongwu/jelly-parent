package com.jelly.nIO;

public class TimeClient {
    public static void main(String[] args) {
        int port=8083;
        if(args!=null && args.length>0){
            try{
                port= Integer.parseInt(args[0]);
            }catch (NumberFormatException ex){

            }
        }
        new Thread(new TimeClinetHandler("127.0.0.1",port),"T-001").start();
    }
}
