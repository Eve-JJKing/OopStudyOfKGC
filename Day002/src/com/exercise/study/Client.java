package com.exercise.study;

import java.util.Arrays;

/**
 * �ͻ��ˣ����ԣ�
 * 
 * @author Administrator
 * 
 */
public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Server server = new Server();
		// �޲��޷�
		server.add();
		// �в��޷�
		server.add(2, 6);
		// �޲��з�
		System.out.println(server.sub());
		// �в��з�
		System.out.println(server.sub(15, 9));
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			server.sub(server.sub(server.sub(5,3),3),2);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("����ִ��ʱ�䣺" + (endTime - startTime) + "ms");
		Arrays.sort(new int[]{1,2,3,4});
	}
}
