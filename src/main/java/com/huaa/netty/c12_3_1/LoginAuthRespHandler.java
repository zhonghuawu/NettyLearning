package com.huaa.netty.c12_3_1;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class LoginAuthRespHandler extends ChannelHandlerAdapter {
//    private Map<String, Boolean> nodeCheck = new ConcurrentHashMap<>();
//    private String[] whitekList = {"127.0.0.1", "192.168.1.4"};

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;
        if (message != null && message.getHeader() != null && message.getHeader().getType() == NettyMessageType.LOGIN_REQ) {
            System.out.println("Login is OK");
            String body = (String) message.getBody();
            System.out.println("receive body from client: "+body);
            ctx.writeAndFlush(buildLoginResponse((byte) 0));
        }
    }

    private NettyMessage buildLoginResponse(byte result) {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType((byte) 2);
        message.setHeader(header);
        message.setBody(result);
        return message;
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
    public void exceptionCaught(ChannelHandlerContext ctx) throws Exception {
        ctx.close();
    }
}
