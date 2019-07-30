package com.schoolexercise.first;
/**
 * 学校类
 * @author Administrator
 *
 */
public class School {
	Student[]  stu = new Student[50];
	/**
	 * 初始化School类
	 */
	public void init(){
		Student stu1 =  new Student();
		stu1.stuNo = "a001";
		stu1.name = "xiaoli";
		stu1.age = 21;
		stu1.clazz = "中级班";
		Student stu2 =  new Student();
		stu2.stuNo = "a002";
		stu2.name = "xiaowang";
		stu2.age = 22;
		stu2.clazz = "中级班";
		Student stu3 =  new Student();
		stu3.stuNo = "a003";
		stu3.name = "xiaozhao";
		stu3.age = 23;
		stu3.clazz = "中级班";
		
		stu[0] = stu1;
		stu[1] = stu2;
		stu[2] = stu3;
	}
	/**
	 * 显示校园的学生
	 */
	public void schoolShow(){
		for (int i = 0; i < stu.length; i++) {
			Student newStu = stu[i];
			if (newStu!=null) {
				newStu.show();
			}
		}
	}
	
	/**
	 * foreach方法显示学生
	 */
	public void schoolShowOfForeach(){
		for (Student newStu : stu) {
			if( newStu != null){
				newStu.show();
			}
		}
	}
}
