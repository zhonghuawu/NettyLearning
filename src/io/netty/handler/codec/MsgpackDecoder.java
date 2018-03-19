package io.netty.handler.codec;

import java.util.List;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {

	@Override
	protected void decode(ChannelHandlerContext arg0, ByteBuf arg1, List<Object> arg2) throws Exception {
		// TODO Auto-generated method stub
		final byte[] array;
		final int length = arg1.readableBytes();
		array = new byte[length];
		arg1.getBytes(arg1.readerIndex(), array, 0, length);
		MessagePack msgpack = new MessagePack();
		arg2.add(msgpack.read(array));
	}

}
