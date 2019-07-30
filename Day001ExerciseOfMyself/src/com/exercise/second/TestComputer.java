package com.exercise.second;
/**
 * ≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class TestComputer {
	public static void main(String[] args) {
		Computer com1;
		com1 = new Computer();
		com1.brand = "AUSA";
		com1.price = 5562.1;
		com1.work();
		
		Computer com2  =  new Computer();
		com2.price = 7677.7;
		com2.brand = "Dell";
		com2.work();
	}
}
