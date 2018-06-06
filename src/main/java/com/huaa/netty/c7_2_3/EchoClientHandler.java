package com.huaa.netty.c7_2_3;

import com.huaa.netty.c6_1_2.UserInfo;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoClientHandler extends ChannelHandlerAdapter {

	private final int sendNumber;
	
	public EchoClientHandler(int sendNumber) {
		// TODO Auto-generated constructor stub
		this.sendNumber = sendNumber;
	}

	public void channelActive(ChannelHandlerContext ctx) {
		UserInfo[] infos = UserInfo();
		for(UserInfo infoE : infos) {
			ctx.write(infoE);
		}
		ctx.flush();
	}

	private UserInfo[] UserInfo() {
		// TODO Auto-generated method stub
		UserInfo[] userInfos = new UserInfo[sendNumber];
		UserInfo userInfo = null;
		for(int i=0; i<sendNumber; i++) {
			userInfo = new UserInfo();
			userInfo.setUserID(i);
			userInfo.setUserName("ABCDEFG--->"+i);
			userInfos[i] = userInfo;
		}
		return userInfos;
	}
	
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("Client receive the msgpack message : "+msg);
		ctx.write(msg);
	}
	
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
}
