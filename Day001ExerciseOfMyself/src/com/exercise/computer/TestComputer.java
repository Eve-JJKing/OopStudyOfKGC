package com.exercise.computer;
/**
 * ������
 * @author Administrator
 *
 */
public class TestComputer {
	public static void main(String[] args) {
		//��������
		Computer computer;
		//��������
		computer = new Computer();
		//���Ը�ֵ
		computer.brand = "Leoven";
		computer.price = 5553.7;
		computer.screenSize = 15.6;
		//ʹ��
		System.out.println(computer.brand);
		System.out.println(computer.price);
		System.out.println(computer.screenSize);
		
		//������ʹ��
		computer.run();
		
		//��������������
		Computer com  = new Computer();
		com.run();
		
	}
}
