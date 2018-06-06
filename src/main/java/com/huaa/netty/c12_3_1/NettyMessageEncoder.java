package com.huaa.netty.c12_3_1;

import java.util.List;
import java.util.Map;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public final class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {
    private NettyMarshallingEncoder marshallingEncoder;

    public NettyMessageEncoder() {
        marshallingEncoder = MarshallingCodecFactory.buildMarshallingEncoder();
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMessage message, List<Object> out) throws Exception {
        NettyMessage msg = null;
        if (message instanceof NettyMessage) {
            msg = (NettyMessage) message;
        } else {
            return;
        }
        if (msg == null || msg.getHeader() == null) {
            throw new Exception("The encode message is null");
        }
        ByteBuf sendBuf = Unpooled.buffer();
        Header header = msg.getHeader();
        sendBuf.writeInt(header.getCrcCode());
        sendBuf.writeInt(header.getLength());
        sendBuf.writeLong(header.getSessionID());
        sendBuf.writeByte(header.getType());
        sendBuf.writeByte(header.getPriority());
        sendBuf.writeInt(header.getAttachment().size());
        String key = null;
        byte[] keyArray = null;
        Object value = null;
        for (Map.Entry<String, Object> param:header.getAttachment().entrySet()) {
            key = param.getKey();
            keyArray = key.getBytes("UTF-8");
            sendBuf.writeInt(keyArray.length);
            sendBuf.writeBytes(keyArray);
            value = param.getValue();
            marshallingEncoder.encode(ctx, value, sendBuf);
        }
        key = null;
        keyArray = null;
        value = null;
        if (msg.getBody() != null) {
            marshallingEncoder.encode(ctx, msg.getBody(), sendBuf);
        }
        int readableBytes = sendBuf.readableBytes();
        sendBuf.setInt(4, readableBytes);
        out.add(sendBuf);
    }
}
