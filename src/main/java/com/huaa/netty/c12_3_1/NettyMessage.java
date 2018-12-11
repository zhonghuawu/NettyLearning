package com.huaa.netty.c12_3_1;

public final class NettyMessage {
    private Header header;
    private Object body;

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Header getHeader() {

        return header;
    }

    public Object getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "NettyMessage{" +
                "header=" + header +
                '}';
    }
}
