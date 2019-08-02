package com.exercise.study;
/**
 * 方法测试
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Test01 test = new Test01();
		test.add();
	}
	/**
	 * 无参无返
	 */
	public void add(){
		int num1 = 1; 
		int num2 = 2;
		System.out.println(num1 + num2);
		
	}
	/**
	 * 有参有反
	 */
	public int add(int num1){
		int num = num1 * num1;
		return num;
	}
}
