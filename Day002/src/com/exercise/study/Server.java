package com.exercise.study;
/**
 * �ͻ���
 * @author Administrator
 *
 */
public class Server {
	/**
	 * �޲��޷�
	 */
	public void add(){
		int num1 = 1;
		int num2 = 2;
		int sum = num1 + num2;
		System.out.println(sum);
	}
	/**
	 * �в��޷�(��������)
	 */
	public void add(int num1, int num2){
		System.out.println(num1 + num2);
	}
	/**
	 * �޲��з�
	 */
	//return ���ؽ��/��������
	//ֻ�ܷ���һ��ֵ��return���治���д��룬����ᱨ���
	public int sub(){
		int res = 6 - 2;
		return res;
	}
	/**
	 * �в��з�
	 */
	public int sub(int minuend, int reduction){
		return minuend - reduction;
	}
}
