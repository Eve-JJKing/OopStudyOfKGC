package com.exercise.first;
/**
 * 电脑类
 * @author Administrator
 *
 */
public class Computer {
	//属性
	/**
	 * 电脑品牌
	 */
	String brand;
	/**
	 * 电脑价格
	 */
	double price;
	
	//方法
	/**
	 * 工作
	 */
	public void work(){
		System.out.println("我用的是" + price + "元的" + brand + "工作");
	}
}
