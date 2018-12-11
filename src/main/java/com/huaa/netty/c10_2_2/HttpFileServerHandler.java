package com.huaa.netty.c10_2_2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
	
	@SuppressWarnings("unused")
	private static final String BASE_DIR = System.getProperty("user.dir") + "/src/main/java/com/huaa/netty/c10_2_2";
	
	// @Override
	@Override
	protected void channelRead0(ChannelHandlerContext arg0, FullHttpRequest arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws Exception {

	}

}