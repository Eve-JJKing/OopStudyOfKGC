package com.exercise.first;
/**
 * 测试类
 * @author Administrator
 *
 */
public class TestComputer {
	public static void main(String[] args) {
		//声明对象
		Computer com1;
		//创建对象
		com1 = new Computer();
		//使用对象
		//属性赋值，com1的价格赋值7677.0 品牌赋值为AUSA
		com1.price = 7677.0;
		com1.brand = "AUSA";
		//调用work方法
		com1.work();
		
		//声明并创建对象
		Computer com2 = new Computer();
		com2.price = 12341.1;
		com2.brand = "Dell";
		com2.work();
		
		
	}
}
