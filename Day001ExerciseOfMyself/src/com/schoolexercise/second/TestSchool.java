package com.schoolexercise.second;
/**
 * 测试类
 * @author Administrator
 *
 */
public class TestSchool {
	public static void main(String[] args) {
		//声明并创建School对象
		School school = new School();
		//调用school  的init()方法
		school.init();
		//调用school的showStudent()方法和showStudentOfForeach()方法显示学生信息
		school.showStudent();
		System.out.println("=============");
		school.showStudentOfForeach();
	}
}
