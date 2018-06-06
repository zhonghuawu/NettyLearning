package com.huaa.netty.c3_3;

import java.util.logging.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeClientHandler extends ChannelHandlerAdapter {
	
	private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());
	
	private final ByteBuf firstMessage;
	
	public TimeClientHandler() {
		byte[] request = "QUERY TIME ORDER".getBytes();
		firstMessage = Unpooled.buffer(request.length);
		firstMessage.writeBytes(request);
	}
	
	public void channelActive(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(firstMessage);
	}
	
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf)msg;
		byte[] request = new byte[buf.readableBytes()];
		buf.readBytes(request);
		String body = new String(request, "UTF-8");
		System.out.println("Now is: "+body);
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		logger.warning("Unexpected exception from downstream: "+cause.getMessage());
		ctx.close();
	}

}
