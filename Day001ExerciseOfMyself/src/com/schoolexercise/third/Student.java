package com.schoolexercise.third;
/**
 * 学生类
 * @author Administrator
 *
 */
public class Student {
	/**
	 * 编号
	 */
	String stuNo;
	/**
	 * 姓名
	 */
	String name;
	/**
	 * 年龄
	 */
	int age;
	/**
	 * 班级
	 */
	String clazz;
	
	/**
	 * 自我介绍
	 */
	public void show(){
		System.out.println("编号：" + stuNo);
		System.out.println("姓名：" + name);
		System.out.println("年龄：" + age);
		System.out.println("班级：" + clazz);
	}
	public int re(){
		int a =1;
		return a;
		System.out.println(); 	
		
	}
}
