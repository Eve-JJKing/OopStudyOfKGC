package com.exercise.third;
/**
 * 电脑类
 * @author Administrator
 *
 */
public class Computer {
	/**
	 * 品牌
	 */
	String brand;
	/**
	 * 价格
	 */
	double price;
	/**
	 * 展示 电脑
	 */
	public void show(){
		System.out.println("我用" + brand +"电脑，价值" + price + "元");
	}
}
