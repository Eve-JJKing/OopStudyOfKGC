package com.schoolexercise.second;
/**
 * ѧУ��
 * @author Administrator
 *
 */
public class School {
	//��������ѧ����������
	Student[] stus = new Student[50];
	
	/**
	 * ��ʼ������
	 */
	public void init(){
		//����������ѧ������stu1
		Student stu1 = new Student();
		//���Ը�ֵ
		stu1.stuNo = "kgc01";
		stu1.name = "AngelAA";
		stu1.age = 22;
		stu1.clazz = "�м���";
		//����������ѧ������stu2
		Student stu2 = new Student();
		//���Ը�ֵ
		stu2.stuNo = "kgc02";
		stu2.name = "AngelBB";
		stu2.age = 23;
		stu2.clazz = "�м���2";
		//��������������stu3
		Student stu3 = new Student();
		//���Ը�ֵ
		stu3.stuNo = "kgc03";
		stu3.name = "AngelCC";
		stu3.age = 24;
		stu3.clazz = "�м���3";
		//�������ŵ�����������
		stus[0] = stu1;
		stus[1] = stu2;
		stus[3] = stu3;
	}
	
	/**
	 * չʾѧ������Ϣ
	 */
	public void showStudent(){
		//ѭ������stus��������
		for (int i = 0; i < stus.length; i++) {
			//�����µ�Student����
			Student newStu = stus[i];
			if (newStu!=null) {	//�п�
				newStu.show();
			}
		}
	}
	
	/**
	 * չʾѧ����Ϣ��foreach������
	 */
	public void showStudentOfForeach(){
		//foreach����������������
		for (Student newStu : stus) {
			if (newStu!=null) {	//�п�
				newStu.show();
			}
		}
	}
}
