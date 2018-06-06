package com.huaa.netty.c6_1_3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class PerformTestUserInfo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UserInfo info = new UserInfo();
		info.buildUserID(100).buildUserName("Welcome to netty");
		int loop = 1000000;
		ByteArrayOutputStream bos = null;// new ByteArrayOutputStream();
		ObjectOutputStream os = null;// new ObjectOutputStream(bos);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < loop; i++) {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			os.writeObject(info);
			os.flush();
			os.close();
			@SuppressWarnings("unused")
			byte[] b = bos.toByteArray();
			bos.close();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("The jdk serializable cost time is : " + (endTime-startTime)+" ms");
		System.out.println("-----------------------------------------------");
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		startTime = System.currentTimeMillis();
		for (int i=0; i<loop; i++) {
			@SuppressWarnings("unused")
			byte[] b = info.codeC(buffer);
		}
		endTime = System.currentTimeMillis();
		System.out.println("The byte array serializable cost time is : " + (endTime-startTime)+" ms");

	}

}
