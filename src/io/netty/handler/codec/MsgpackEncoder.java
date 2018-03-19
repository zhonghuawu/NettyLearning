package io.netty.handler.codec;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class MsgpackEncoder extends MessageToByteEncoder<Object> {

	@Override
	protected void encode(ChannelHandlerContext arg0, Object arg1, ByteBuf arg2) throws Exception {
		// TODO Auto-generated method stub
		MessagePack msgpack = new MessagePack();
		// Serialize
		byte[] raw = msgpack.write(arg1);
		arg2.writeBytes(raw);
	}

}
