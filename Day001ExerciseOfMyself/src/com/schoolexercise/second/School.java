package com.schoolexercise.second;
/**
 * 学校类
 * @author Administrator
 *
 */
public class School {
	//声明创建学生对象数组
	Student[] stus = new Student[50];
	
	/**
	 * 初始化方法
	 */
	public void init(){
		//声明并创建学生对象stu1
		Student stu1 = new Student();
		//属性赋值
		stu1.stuNo = "kgc01";
		stu1.name = "AngelAA";
		stu1.age = 22;
		stu1.clazz = "中级班";
		//声明并创建学生对象stu2
		Student stu2 = new Student();
		//属性赋值
		stu2.stuNo = "kgc02";
		stu2.name = "AngelBB";
		stu2.age = 23;
		stu2.clazz = "中级班2";
		//声明并创建对象stu3
		Student stu3 = new Student();
		//属性赋值
		stu3.stuNo = "kgc03";
		stu3.name = "AngelCC";
		stu3.age = 24;
		stu3.clazz = "中级班3";
		//将对象存放到对象数组中
		stus[0] = stu1;
		stus[1] = stu2;
		stus[3] = stu3;
	}
	
	/**
	 * 展示学生的信息
	 */
	public void showStudent(){
		//循环遍历stus对象数组
		for (int i = 0; i < stus.length; i++) {
			//创建新的Student对象
			Student newStu = stus[i];
			if (newStu!=null) {	//判空
				newStu.show();
			}
		}
	}
	
	/**
	 * 展示学生信息（foreach方法）
	 */
	public void showStudentOfForeach(){
		//foreach方法便利对象数组
		for (Student newStu : stus) {
			if (newStu!=null) {	//判空
				newStu.show();
			}
		}
	}
}
