package com.schoolexercise.first;
/**
 * ѧУ��
 * @author Administrator
 *
 */
public class School {
	Student[]  stu = new Student[50];
	/**
	 * ��ʼ��School��
	 */
	public void init(){
		Student stu1 =  new Student();
		stu1.stuNo = "a001";
		stu1.name = "xiaoli";
		stu1.age = 21;
		stu1.clazz = "�м���";
		Student stu2 =  new Student();
		stu2.stuNo = "a002";
		stu2.name = "xiaowang";
		stu2.age = 22;
		stu2.clazz = "�м���";
		Student stu3 =  new Student();
		stu3.stuNo = "a003";
		stu3.name = "xiaozhao";
		stu3.age = 23;
		stu3.clazz = "�м���";
		
		stu[0] = stu1;
		stu[1] = stu2;
		stu[2] = stu3;
	}
	/**
	 * ��ʾУ԰��ѧ��
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
	 * foreach������ʾѧ��
	 */
	public void schoolShowOfForeach(){
		for (Student newStu : stu) {
			if( newStu != null){
				newStu.show();
			}
		}
	}
}
