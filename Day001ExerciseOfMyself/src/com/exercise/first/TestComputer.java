package com.exercise.first;
/**
 * ������
 * @author Administrator
 *
 */
public class TestComputer {
	public static void main(String[] args) {
		//��������
		Computer com1;
		//��������
		com1 = new Computer();
		//ʹ�ö���
		//���Ը�ֵ��com1�ļ۸�ֵ7677.0 Ʒ�Ƹ�ֵΪAUSA
		com1.price = 7677.0;
		com1.brand = "AUSA";
		//����work����
		com1.work();
		
		//��������������
		Computer com2 = new Computer();
		com2.price = 12341.1;
		com2.brand = "Dell";
		com2.work();
		
		
	}
}
