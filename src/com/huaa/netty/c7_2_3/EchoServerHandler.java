package com.huaa.netty.c7_2_3;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoServerHandler extends ChannelHandlerAdapter {
		
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("Receive client: ["+msg.toString()+"]");
//		ctx.write(msg);
	}
	
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

}
