package com.exercise.second;
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
	 * 工作
	 */
	public void work(){
		System.out.println("我用" + price + "元的" + brand + "牌子电脑");
	}
}
