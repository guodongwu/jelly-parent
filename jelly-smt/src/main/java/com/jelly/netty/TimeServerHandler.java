package com.jelly.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class TimeServerHandler extends ChannelHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx,Object msg) throws UnsupportedEncodingException {
        ByteBuf buf= (ByteBuf) msg;
        byte[] req=new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body=new String(req,"UTF-8");
        System.out.println("receive order:"+body);
        String crt= "QUERY".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString() :"Bad Order";
        ByteBuf resp= Unpooled.copiedBuffer(crt.getBytes());
        ctx.write(resp);
    }
    
}
