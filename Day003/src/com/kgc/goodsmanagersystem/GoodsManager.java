package com.kgc.goodsmanagersystem;

import java.util.Scanner;

/**
 * ��Ʒ������
 * @author Administrator 
 *
 */
public class GoodsManager {
	//��Ʒ�������ʹ�õľ�̬����
	public static int no;
	
	Scanner input = new Scanner(System.in);
	//�洢��Ʒ������
	Goods[] goods = new Goods[500];
	
	//��ʼ������
	public void init(){
		Goods goods1 = new Goods();
		goods1.setId("kgc" + ++no);
		goods1.setName("�㽶");
		goods1.setPrice(1.2);
		goods1.setNum(80);

		Goods goods2 = new Goods();
		goods2.setId("kgc" + ++no);
		goods2.setName("ƻ��");
		goods2.setPrice(3.5);
		goods2.setNum(67);
		
		Goods goods3 = new Goods();
		goods3.setId("kgc" + ++no);
		goods3.setName("����");
		goods3.setPrice(2);
		goods3.setNum(125);
		
		//��������ӵ�������
		goods[0] = goods1;
		goods[1] = goods2;
		goods[2] = goods3;
	}
	
	/**
	 * ��ʾ���л�����Ϣ
	 */
	public void showAllGoods(Goods[] arr){
		System.out.println("���\t��Ʒ��\t�۸�\t����");
		System.out.println("===========================");
		for (Goods good : arr) {
			if(good != null){
				good.show();
			}
		}
	}
	
	/**
	 * �����Ʒ�Ƿ�ɹ�
	 * @param good	��Ʒ����
	 */
	public boolean addGoods(Goods good){
		boolean flag = false;
		for (int i = 0; i < goods.length; i++) {
			if(goods[i] == null){
				goods[i] = good;
				flag = true;
				break;
			}
		}
		return flag;
		
	}
	
	/**
	 * �����Ʒ����
	 */
	public void add(){
		System.out.print("��������Ʒ���ƣ�");
		String name = input.next();
		System.out.print("������" + name + "�۸�");
		double price = input.nextDouble();
		System.out.print("������" + name + "������");
		int num = input.nextInt();
		Goods good = new Goods(name,price,num);
		if(addGoods(good)){
			System.out.println("Add Success!");
			System.out.println();
		}else{
			System.out.println("default");
		}
	}
	
	/**
	 * �ж��Ƿ�ɾ��
	 * @param id	Ҫɾ������Ʒ���
	 * @return	�Ƿ�ɾ���ɹ�
	 */
	public boolean delGoods(String id){
		for (int i = 0; i < goods.length;i++) {
			if(goods[i] != null && goods[i].getId().equals(id)){
				for (int j = i; j < goods.length - 1; j++) {
					goods[j] = goods[j+1];
				}
				goods[goods.length - 1] = null;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ɾ������
	 */
	public void delete(){
		System.out.println("������Ҫ�ճ�����Ʒ��ţ�");
		String goodsId = input.next();
		if(delGoods(goodsId)){
			System.out.println("ɾ���ɹ�");
			System.out.println();
		}else{
			System.out.println("ɾ��ʧ��");
			System.out.println();
		}
	}
	
	/**
	 * ģ����ѯ
	 */
	public void query(){
		System.out.println("");
	}
	
	/**
	 * �Ƿ��ѯ��
	 * @param name
	 * @return
	 */
	public boolean queryGoods(String name){
		for (int i = 0; i < goods.length; i++) {
			if (goods[i] != null  && goods[i].getName().contains(name)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * ��������
	 */
	public void discount(){
		System.out.println("�������ۿۣ�");
		double discountNum = input.nextDouble();
		for (int i = 0; i < goods.length; i++) {
			if (goods[i] != null) {
				goods[i].discount(discountNum);
			}
		}
	}
	
	public void discountPlus(){
		System.out.println("������Ҫ�������۵���Ʒ���(�ԣ�����)��");
		String nos = input.next();
		System.out.println("�������ۿۣ�");
		double discountNum = input.nextDouble();
		discount(nos.split(","),discountNum);
	}
	
	/**
	 * ��������������
	 * @param nos	Ҫ���۵ı������
	 * @param discountNum	�ۿۼ�
	 */
	public void discount(String[] nos, double discountNum){
		boolean flag = false;
		for (int i = 0; i < nos.length; i++) {
			
			for (int j = 0; j < goods.length; j++) {
				if (goods[j] != null && goods[j].getId().equals(nos[i])) {
					goods[j].discount(discountNum);
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("û�С�" + nos[i] + "����Ʒ������ʧ�ܣ�");
			}else{
				System.out.println("��" + nos[i] + "����Ʒ�����۳ɹ���");
			}
		}
		
	}
	
	/**
	 * ���ռ۸�������
	 */
	public void sortByPrice(){
		Goods[] newGoods = new Goods[goods.length];
		System.arraycopy(goods, 0, newGoods, 0, goods.length);
		for (int i = 0; i < newGoods.length - 1; i++) {
			if (newGoods[i] != null) {
				for (int j = i+1; j < newGoods.length; j++) {
					if (newGoods[j] != null && newGoods[i].getPrice() < newGoods[j].getPrice()) {
						Goods temp = newGoods[i];
						newGoods[i] = newGoods[j];
						newGoods[j] = temp;
					}
				}
			}
		}
		showAllGoods(newGoods);
		
	}
	
	/**
	 * �˳�ϵͳ
	 * @throws InterruptedException
	 */
	public void exit() throws InterruptedException{
		System.out.print("�˳�ϵͳ��");
		for (int i = 0; i < 6; i++) {
			Thread.sleep(1000);
			System.out.print(".");
		}
		System.out.println("\nϵͳ�Ѿ��Ƴ�����ӭ���´�ʹ�ã�");
	}
	
	/**
	 * ��ʼ�˵�
	 * @throws InterruptedException
	 */
	public void startMenu() throws InterruptedException{
		int choice;
		do {
			System.out.println("****��Ʒ����ϵͳ*****");
    		System.out.println("**** 1.�����Ʒ*****");
    		System.out.println("**** 2.չʾ��Ʒ*****");
    		System.out.println("**** 3.ɾ����Ʒ*****");
    		System.out.println("**** 4.ģ����ѯ*****");
    		System.out.println("**** 5.��������*****");
    		System.out.println("**** 6.���۸���***");
    		System.out.println("**** 7.�޸���Ʒ*****");
    		System.out.println("**** 0.��       ��*****");
    		System.out.print("��ѡ��");
    		choice = input.nextInt();
    		switch (choice) {
    		
			case 0:
				exit();				//�˳�ϵͳ
				break;
				
			case 1:
				add();				//�����Ʒ
				break;
			
			case 2:
				showAllGoods(goods);		//չʾ��Ʒ
				break;
			
			case 3:
				delete();			//ɾ����Ʒ
				break;
				
			case 8:
				discountPlus();		//���ۼ�ǿ��
				break;
				
			case 5:
				discount();			//��������
				break;
			case 6:
				sortByPrice();
				break;
			}
		} while (choice != 0);
	}
}
