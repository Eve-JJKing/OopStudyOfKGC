package com.exercise.study;

import java.util.Arrays;

/**
 * 客户端（测试）
 * 
 * @author Administrator
 * 
 */
public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Server server = new Server();
		// 无参无返
		server.add();
		// 有参无返
		server.add(2, 6);
		// 无参有返
		System.out.println(server.sub());
		// 有参有返
		System.out.println(server.sub(15, 9));
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			server.sub(server.sub(server.sub(5,3),3),2);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("程序执行时间：" + (endTime - startTime) + "ms");
		Arrays.sort(new int[]{1,2,3,4});
	}
}
