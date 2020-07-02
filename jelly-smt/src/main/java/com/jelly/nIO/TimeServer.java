package com.jelly.nIO;

public class TimeServer {
    public static void main(String[] args) {
        int port=8083;
        if(args!=null && args.length>0){
            try{
                port= Integer.parseInt(args[0]);
            }catch (NumberFormatException ex){

            }
        }
        MultiplexerTimeServer timeServer=new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-001").start();
    }
}
