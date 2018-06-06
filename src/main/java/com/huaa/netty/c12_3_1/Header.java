package com.huaa.netty.c12_3_1;

import java.util.HashMap;
import java.util.Map;

public final class Header {
    private int crcCode = 0xabef0101;
    private int length; // message length
    private long sessionID; // session id
    private byte type; // message type
    private byte priority; // message priority;
    private Map<String, Object> attachment = new HashMap<>();

    public void setCrcCode(int crcCode) {
        this.crcCode = crcCode;
    }

    public int getCrcCode() {
        return crcCode;
    }

    public int getLength() {
        return length;
    }

    public long getSessionID() {
        return sessionID;
    }

    public byte getType() {
        return type;
    }

    public byte getPriority() {
        return priority;
    }

    public Map<String, Object> getAttachment() {
        return attachment;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSessionID(long sessionID) {
        this.sessionID = sessionID;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    public void setAttachment(Map<String, Object> attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Header{" +
                "crcCode=" + crcCode +
                ", length=" + length +
                ", sessionID=" + sessionID +
                ", type=" + type +
                ", priority=" + priority +
                ", attachment=" + attachment +
                '}';
    }
}
