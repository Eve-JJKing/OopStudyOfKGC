package com.exercise.computer;
/**
 * 测试类
 * @author Administrator
 *
 */
public class TestComputer {
	public static void main(String[] args) {
		//声明对象
		Computer computer;
		//创建对象
		computer = new Computer();
		//属性赋值
		computer.brand = "Leoven";
		computer.price = 5553.7;
		computer.screenSize = 15.6;
		//使用
		System.out.println(computer.brand);
		System.out.println(computer.price);
		System.out.println(computer.screenSize);
		
		//方法的使用
		computer.run();
		
		//声明并创建对象
		Computer com  = new Computer();
		com.run();
		
	}
}
