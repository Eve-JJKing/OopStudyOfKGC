package com.exercise.goodsmanager;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * ��Ʒ������
 * 
 * @author Administrator
 * 
 */
public class GoodsManager {

	Scanner input = new Scanner(System.in);

	/**
	 * ����Goods��������洢��Ʒ��Ϣ
	 */
	Goods[] goodsArr = new Goods[200];

	/**
	 * ��ʼ����Ʒ����
	 */
	public void init() {

		Goods goods1 = new Goods("apple", BigDecimal.valueOf(2.3), 24);
		Goods goods2 = new Goods("origin", BigDecimal.valueOf(1.2), 45);
		Goods goods3 = new Goods("banana", BigDecimal.valueOf(1.8), 21);

		goodsArr[0] = goods1;
		goodsArr[1] = goods2;
		goodsArr[2] = goods3;

	}

	/**
	 * չʾ����
	 */
	public void startMenu() {
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
			System.out.print("��ѡ���ܣ�");
			choice = input.nextInt();

			switch (choice) {
			case 0:
				exit(); // �˳�����
				break;

			case 1:
				add(); // �����Ʒ
				break;

			case 2:
				show(); // չʾ��Ʒ
				break;

			case 3:
				delete();//��Ʒɾ��
				break;
				
			case 4:
				query();//��ѯ��Ʒ
				break;
				
			case 5:
				discount();//��Ʒ��������
				break;
				
			case 6:
				 sortByPriceDesc();//�۸�������
				 break;
			case 7:
				 update();//�޸���Ϣ
				 break;
			default:
				System.out.println("��ѡ����ȷ�Ĺ��ܣ�");
				break;
			}
		} while (choice != 0);
	}

	/**
	 * �����Ʒ
	 */
	public void add() {
		System.out.print("������Ҫ��ӵ���Ʒ���ƣ�");
		String name = input.next();
		System.out.print("�����롾" + name + "���ļ۸�");
		BigDecimal price = input.nextBigDecimal();
		System.out.print("�����롾" + name + "����������");
		int num = input.nextInt();
		Goods goods = new Goods(name, price, num);
		if (add(goods)) {
			System.out.println("��" + name + "����Ʒ��ӳɹ���");
		}
	}

	/**
	 * �����Ʒ����ʵ��
	 * 
	 * @param goods
	 *            Goods����
	 */
	public boolean add(Goods goods) {
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] == null) {
				goodsArr[i] = goods;
				return true;
			}
		}
		return false;
	}

	/**
	 * չʾ��Ʒ
	 */
	public void show() {
		
		show(goodsArr);
	}

	/**
	 * չʾ��Ʒ��Ϣ
	 * 
	 * @param goods
	 *            Goods����
	 */
	public void show(Goods[] goods) {
		System.out.println("���\t����\t�۸�\t����");
		System.out.println("==================================");
		for (int i = 0; i < goods.length; i++) {
			if (goods[i] != null) {
				goods[i].show();
			}
		}
	}

	/**
	 * ɾ����Ʒ
	 */
	public void delete(){
		System.out.println("������Ҫɾ������Ʒ��ţ�");
		String no = input.next();
		if(isFind(no)){
			//�ҵ�Ҫɾ������Ʒ�ı��
			int index = -1;
			for (int i = 0; i < goodsArr.length; i++) {
				if(goodsArr[i] != null && goodsArr[i].getGoodsNo().equals(no)){
					index = i;
					break;
				}
			}
			for (int i = index; i < goodsArr.length - 1; i++) {
				goodsArr[i] = goodsArr[i+1];
			}
			goodsArr[goodsArr.length - 1] = null;
			System.out.println("���Ϊ" + no + "����Ʒɾ���ɹ���");
		}else{
			System.out.println("û��" + no + "��Ʒ���,�޷�ɾ����");
		}
	}
	
	/**
	 * �Ƿ��ҵ���Ʒ���
	 * @param no
	 * @return
	 */
	public boolean isFind(String no){
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null && goodsArr[i].getGoodsNo().equals(no)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ģ����ѯ
	 */
	public void query(){
		System.out.println("������Ҫ��ѯ����Ʒ����;");
		String name = input.next();
		if (query(name)) {
			int count = 0;
			for (int i = 0; i < goodsArr.length; i++) {
				if(goodsArr[i] != null && goodsArr[i].getGoodsName().contains(name)){
					count ++;
				}
			}
//			System.out.println(count);
			Goods[] goods = new Goods[count];
			int index = 0;
			for (int i = 0; i < goodsArr.length; i++) {
				if(goodsArr[i] != null && goodsArr[i].getGoodsName().contains(name)){
					goods[index++] = goodsArr[i];
				}
			}
			System.out.println("��ѯ�������:");
			show(goods);
		}else{
			System.out.println("û�в�ѯ�������Ʒ��");
		}
		
	}
	
	/**
	 * ��ѯ�Ƿ��п�����ʾ����Ʒ
	 * @param name
	 * @return
	 */
	public boolean query(String name){
		for (int i = 0; i < goodsArr.length; i++) {
			if(goodsArr[i] != null && goodsArr[i].getGoodsName().contains(name)){
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * ��������
	 */
	public void discount(){
		System.out.println("������Ҫ���۵���Ʒ�ۿ�(0.0~1.0֮��)");
		BigDecimal discount = input.nextBigDecimal();
		BigDecimal min = BigDecimal.valueOf(0);
		BigDecimal max = BigDecimal.valueOf(1);
		boolean flag = false;
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null) {
				if(discount.compareTo(min)> 0 && discount.compareTo(max) < 0){
					goodsArr[i].discount(discount);
					flag = true;
				}
			}
		}
		if (flag) {
			System.out.println("���۳ɹ���ȫ��" + discount + "��!");
		}else{
			System.out.println("�������ۿ۲���~");
		}
	}

	/**
	 * ���ռ۸���������Ʒ
	 */
	public void sortByPriceDesc(){
		Goods[] goods = new Goods[goodsArr.length];
		System.arraycopy(goodsArr, 0, goods, 0, goodsArr.length);
		for (int i = 0; i < goods.length - 1; i++) {
			if (goods[i] != null) {
				for (int j = i+1; j < goods.length; j++) {
					if (goods[j] != null && goods[i].getGoodsPrice().compareTo(goods[j].getGoodsPrice()) < 0) {
						Goods good = goods[i];
						goods[i] = goods[j];
						goods[j] = good;
					}
				}
			}
		}
		show(goods);
	}
	
	/**
	 * ������Ϣ
	 */
	public void update(){
		System.out.println("������Ҫ�޸ĵ���Ʒ���");
		String no = input.next();
		if(isFind(no)){
			for (int i = 0; i < goodsArr.length; i++) {
				if(goodsArr[i]!=null && goodsArr[i].getGoodsNo().equals(no)){
					System.out.print("������Ҫ��ӵ���Ʒ���ƣ�");
					String name = input.next();
					System.out.print("�����롾" + name + "���ļ۸�");
					BigDecimal price = input.nextBigDecimal();
					System.out.print("�����롾" + name + "����������");
					int num = input.nextInt();
					goodsArr[i].setGoodsName(name);
					goodsArr[i].setGoodsPrice(price);
					goodsArr[i].setGoodsNum(num);
					System.out.println("��Ϣ�޸ĳɹ���");
				}
			}
		}else{
			System.out.println("û�б��Ϊ��" + no + "������Ʒ");
		}
	}
	
	/**
	 * �˳�����
	 */
	public void exit() {
		System.out.println("׼���˳�����...");
		System.out.print("�����˳���");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("\n�����˳��ɹ�����ӭ���´�ʹ�ã�");
	}

}