package com.schoolexercise.second;
/**
 * ������
 * @author Administrator
 *
 */
public class TestSchool {
	public static void main(String[] args) {
		//����������School����
		School school = new School();
		//����school  ��init()����
		school.init();
		//����school��showStudent()������showStudentOfForeach()������ʾѧ����Ϣ
		school.showStudent();
		System.out.println("=============");
		school.showStudentOfForeach();
	}
}
