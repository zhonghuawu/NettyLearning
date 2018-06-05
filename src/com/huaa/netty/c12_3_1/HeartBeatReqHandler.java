package com.huaa.netty.c12_3_1;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.socks.SocksMessageType;
import org.jibx.binding.Run;
import sun.plugin2.main.server.HeartbeatThread;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class HeartBeatReqHandler extends ChannelHandlerAdapter {
    private volatile ScheduledFuture<?> heartBeat;

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null && message.getHeader().getType()==NettyMessageType.LOGIN_RESP) {
            heartBeat = ctx.executor().scheduleAtFixedRate(this.new HeartBeatTask(ctx), 0, 5000, TimeUnit.MILLISECONDS);
        } else {

        }
    }

    private class HeartBeatTask implements Runnable {
        private final ChannelHandlerContext ctx;
        public HeartBeatTask(final ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void run() {
            NettyMessage heartBeat = buildHeartBeat();
            System.out.println("Client send heart beat message to server: ---> "+heartBeat);
            ctx.writeAndFlush(heartBeat);
        }

        private NettyMessage buildHeartBeat() {
            NettyMessage message = new NettyMessage();
            Header header = new Header();
            header.setType(NettyMessageType.HEARTBEAT_REQ);
            message.setHeader(header);
            return message;
        }
    }
}
