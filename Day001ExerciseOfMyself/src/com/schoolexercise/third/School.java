package com.schoolexercise.third;


/**
 * ѧУ��
 * @author Administrator
 *
 */
public class School {
	Student[] stus = new Student[50];
	
	/**
	 * ��ʼ��
	 */
	public void init(){
		Student stu1 = new Student();
		stu1.stuNo = "kgc01";
		stu1.name = "zhangsan";
		stu1.age = 22;
		stu1.clazz = "middleClass";
		Student stu2 = new Student();
		stu2.stuNo = "kgc02";
		stu2.name = "lisi";
		stu2.age = 24;
		stu2.clazz = "middleClass";
		Student stu3 = new Student();
		stu3.stuNo = "kgc03";
		stu3.name = "John";
		stu3.age = 26;
		stu3.clazz = "middleClass";
		stus[0] = stu1;
		stus[1] = stu2;
		stus[2] = stu3;
	}
	
	/**
	 * ��ʾѧ����Ϣ
	 */
	public void showStudents(){
		for (int i = 0; i < stus.length; i++) {
			Student newStu = stus[i];
			if(newStu!=null){
				newStu.show();
			}
		}
	}
	/**
	 * ��ʾѧ����Ϣ��foreach������
	 */
	public void showStudentOfForeach(){
		for (Student newStu : stus) {
			if (newStu!=null) {
				newStu.show();
			}
		}
	}
}
