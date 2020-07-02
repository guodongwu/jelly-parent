package com.jelly.blockIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class TimeClient {
    public static void main(String[] args) {
        int port=8083;
        if(args!=null && args.length>0){
            try{
                port= Integer.parseInt(args[0]);
            }catch (NumberFormatException ex){

            }
        }
        Socket socket=null;
        BufferedReader in=null;
        PrintWriter out=null;
        try {
            socket=new Socket("127.0.0.1",port);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            out.println("QUERY TIME ORDER");
            System.out.println("Send 2 server succeed.");
            String resp=in.readLine();
            System.out.println("Now is "+resp);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try{
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(out!=null){
                out.close();
                out=null;
            }
            if(socket!=null) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                socket=null;
            }

        }
    }
}
