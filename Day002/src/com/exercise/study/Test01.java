package com.exercise.study;
/**
 * ��������
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Test01 test = new Test01();
		test.add();
	}
	/**
	 * �޲��޷�
	 */
	public void add(){
		int num1 = 1; 
		int num2 = 2;
		System.out.println(num1 + num2);
		
	}
	/**
	 * �в��з�
	 */
	public int add(int num1){
		int num = num1 * num1;
		return num;
	}
}
