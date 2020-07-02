package com.jelly.fakeAsynIO;

import com.jelly.blockIO.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port=8082;
        if(args!=null && args.length>0){
            try{
                port= Integer.parseInt(args[0]);
            }catch (NumberFormatException ex){

            }
        }
        ServerSocket server=null;
        try {
            server=new ServerSocket(port);
            System.out.println("Time server is start in port:"+port);
            Socket socket=null;
            TimeServerHandlerExcutePool singleExecutor=new TimeServerHandlerExcutePool(50,1000);
            while (true){
                socket=server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(server!=null){
                System.out.println("time server closed");
                server.close();
                server=null;
            }
        }

    }
}
