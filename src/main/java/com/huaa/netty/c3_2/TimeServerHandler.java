package com.huaa.netty.c3_2;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeServerHandler extends ChannelHandlerAdapter {
	
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf)msg;
		byte[] req =  new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println("The time server receive order: "+body);
		String currentTime;
		if ("QUERY TIME ORDER".equalsIgnoreCase(body))
			currentTime = new Date(System.currentTimeMillis()).toString();
		else
			currentTime = "BAD ORDER";
		ByteBuf response = Unpooled.copiedBuffer(currentTime.getBytes());
		ctx.write(response);
	}
	
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		ctx.close();
	}
	
}
