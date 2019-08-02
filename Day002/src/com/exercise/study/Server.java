package com.exercise.study;
/**
 * 客户端
 * @author Administrator
 *
 */
public class Server {
	/**
	 * 无参无返
	 */
	public void add(){
		int num1 = 1;
		int num2 = 2;
		int sum = num1 + num2;
		System.out.println(sum);
	}
	/**
	 * 有参无返(方法重载)
	 */
	public void add(int num1, int num2){
		System.out.println(num1 + num2);
	}
	/**
	 * 无参有返
	 */
	//return 返回结果/结束方法
	//只能返回一个值，return后面不能有代码，否则会报错的
	public int sub(){
		int res = 6 - 2;
		return res;
	}
	/**
	 * 有参有返
	 */
	public int sub(int minuend, int reduction){
		return minuend - reduction;
	}
}
