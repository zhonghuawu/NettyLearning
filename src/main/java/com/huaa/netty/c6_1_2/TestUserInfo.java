package com.huaa.netty.c6_1_2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestUserInfo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UserInfo info = new UserInfo();
		info.buildUserID(100).buildUserName("Welcome to netty");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bos);
		os.writeObject(info);
		os.flush();
		os.close();
		byte[] b = bos.toByteArray();
		System.out.println("The jdk serializable length is : " + b.length);
		bos.close();
		System.out.println("-----------------------------");
		System.out.println("The byte array serializable length is : " + info.codeC().length);

	}

}
