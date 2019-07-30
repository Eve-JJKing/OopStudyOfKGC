package com.schoolexercise.second;
/**
 * 学生类
 * @author Administrator
 *
 */
public class Student {
	/**
	 * 学生编号
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
	//方法
	/**
	 * 自我展示
	 */
	public void show(){
		System.out.println("学生编号 " + stuNo);
		System.out.println("姓名 " + name);
		System.out.println("年龄 " + age);
		System.out.println("班级 " + clazz);
	}
}
