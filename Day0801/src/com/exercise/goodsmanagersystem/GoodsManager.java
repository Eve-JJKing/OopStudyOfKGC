package com.exercise.goodsmanagersystem;

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

	// ����һ������Ʒ���������
	Goods[] goodsArr = new Goods[200];

	public void init() {
		// ������Ʒ�������ַ�����
		Goods goods1 = new Goods("�㽶", BigDecimal.valueOf(2.2), 20);
		Goods goods2 = new Goods("����", BigDecimal.valueOf(1.5), 15);
		Goods goods3 = new Goods();
		goods3.setGoodsName("��֦");
		goods3.setGoodsPrice(BigDecimal.valueOf(5.6));
		goods3.setGoodsNum(10);
		Goods goods4 = new Goods("apple", BigDecimal.valueOf(5.6), 10);
		// ������浽��������
		goodsArr[0] = goods1;
		goodsArr[1] = goods2;
		goodsArr[2] = goods3;
		goodsArr[3] = goods4;
	}

	/**
	 * չʾ��ʼ�˵�
	 * 
	 * @throws InterruptedException
	 */
	public void startMenu() throws InterruptedException {
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
			case 1: // �����Ʒ
				add();
				break;
			case 2: // չʾ��Ʒ
				showAllGoods(goodsArr);
				break;
			case 3: // ɾ����Ʒ
				delete();
				break;
			case 4: // ģ����ѯ
				query();
				break;
			case 5: // ��������
				channel();
				break;
			case 6: // ���۸���
				sort();
				break;
			case 7: // �޸���Ʒ
				update();
				break;
			case 0: // �� ��
				exit();
				break;
			default:
				System.out.println("��ѡ����ȷ������ѡ��");
				break;
			}
		} while (choice != 0);
	}

	/**
	 * �����Ʒ
	 */
	public void add() {
		System.out.println("������Ҫ��ӵ���Ʒ���ƣ�");
		String addGoodsName = input.next();
		System.out.println("������" + addGoodsName + "�ļ۸�");
		BigDecimal addGoodsPrice = input.nextBigDecimal();
		System.out.println("������" + addGoodsName + "��������");
		int addGoodsNum = input.nextInt();
		Goods goods = new Goods(addGoodsName, addGoodsPrice, addGoodsNum);
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] == null) {
				goodsArr[i] = goods;
				System.out.println("��ӳɹ���");
				return;
			}
		}
		System.out.println("���ʧ�ܣ�");
	}

	/**
	 * չʾ��Ʒ
	 * 
	 * @param arr
	 *            Goods����
	 */
	public void showAllGoods(Goods[] arr) {
		System.out.println("���\t����\t�۸�\t����");
		System.out.println("=============================");
		for (Goods goods : arr) {
			if (goods != null) {
				goods.show();
			}
		}
	}

	/**
	 * ɾ��
	 */
	public void delete() {
		boolean flag = false; // �ж��Ƿ���ҵ�����Ʒ
		int index = -1;
		System.out.println("������Ҫɾ���Ĳ�Ʒ��ţ�");
		String delGoodsNo = input.next();
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null
					&& goodsArr[i].getGoodsNo().equals(delGoodsNo)) {
				index = i; // ��Ʒ��λ
				flag = true;
			}
		}
		if (flag) {
			for (int i = index; i < goodsArr.length - 1; i++) {
				goodsArr[i] = goodsArr[i + 1];
			}
			goodsArr[goodsArr.length - 1] = null;
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("û�и���Ʒ��");
		}
	}

	/**
	 * ģ����ѯ
	 */
	public void query() {
		int queryCount = 0; // ��ѯ���������Ʒ����
		boolean flag = false; // �Ƿ��������Ʒ
		System.out.println("������Ҫ��ѯ����Ʒ���ƣ�");
		String queryGoodsName = input.next();
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null
					&& goodsArr[i].getGoodsName().contains(queryGoodsName)) {
				queryCount++;
				flag = true;
			}
		}
		if (flag) {
			int index = 0;
			Goods[] newGoodsArr = new Goods[queryCount];
			for (int i = 0; i < goodsArr.length; i++) {
				if (goodsArr[i] != null
						&& goodsArr[i].getGoodsName().contains(queryGoodsName)) {
					newGoodsArr[index] = goodsArr[i];
					index++;
				}
			}
			showAllGoods(newGoodsArr);
		} else {
			System.out.println("δ��ѯ�������Ʒ");
		}
	}

	/**
	 * ��������
	 */
	public void channel() {
		BigDecimal min = BigDecimal.valueOf(0);
		BigDecimal max = BigDecimal.valueOf(10);
		System.out.println("�������ۿۣ�");
		BigDecimal num = input.nextBigDecimal();
		BigDecimal channelNum = BigDecimal.valueOf(0.1);
		if (num.compareTo(min)>0 && num.compareTo(max) < 0) {
			for (int i = 0; i < goodsArr.length; i++) {
				if (goodsArr[i] != null) {
					// ����������Ƚ��۸�ת��
					goodsArr[i].setGoodsPrice(goodsArr[i].getGoodsPrice().multiply(num).multiply(channelNum));
				}
			}
		} else {
			System.out.println("û�������ۿۣ�");
		}
	}
	
	/**
	 * ��������
	 */
	public void sort() {
		boolean flag = false;
		int count = 0;
		//�����ж��ټ���Ʒ
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null) {
				count ++;
				flag = true;
			}
		}
		if (flag) {
			Goods[] newGoods  = new Goods[count];
			int index = 0;
			//����Ʒ�ŵ��µ�������
			for (int i = 0; i < goodsArr.length; i++) {
				if (goodsArr[i] != null) {
					newGoods[index] = goodsArr[i];
					index++;
				}
			}
			//ð��������������Ʒ�۸�������Ʒ����
			for (int i = 0; i < newGoods.length -1; i++) {
				for (int j = 0; j < newGoods.length - 1 - i; j++) {
					if (newGoods[j].getGoodsPrice().compareTo(newGoods[j+1].getGoodsPrice()) < 0) {
						Goods goods = newGoods[j];
						newGoods[j] = newGoods[j+1];
						newGoods[j+1] = goods;
					}
				}
			}
			
			System.out.println("���۸���������");
			showAllGoods(newGoods);
		}else{
			System.out.println("û����Ʒ��");
		}
	}
	
	/**
	 * ���ݱ���޸���Ʒ
	 */
	public void update(){
		boolean flag = false;
		System.out.println("������Ҫ�޸ĵ���Ʒ��ţ�");
		String updateGoodsNo = input.next();
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null && goodsArr[i].getGoodsNo().equals(updateGoodsNo)) {
				flag = true;
			}
		}
		if (flag) {
			System.out.println("������Ҫ�޸ĵ���Ʒ���ƣ�");
			String updateGoodsName = input.next();
			System.out.println("������" + updateGoodsName + "�ļ۸�");
			BigDecimal updateGoodsPrice = input.nextBigDecimal();
			System.out.println("������" + updateGoodsName + "��������");
			int updateGoodsNum = input.nextInt();
			
			for (int i = 0; i < goodsArr.length; i++) {
				if (goodsArr[i] != null && goodsArr[i].getGoodsNo().equals(updateGoodsNo) ) {
					goodsArr[i].setGoodsName(updateGoodsName);
					goodsArr[i].setGoodsPrice(updateGoodsPrice);
					goodsArr[i].setGoodsNum(updateGoodsNum);
					System.out.println("�޸ĳɹ���");
					return;
				}
			}
		}else{
			System.out.println("û�и���Ʒ��");
		}
	}

	/**
	 * �˳�ϵͳ
	 * 
	 * @throws InterruptedException
	 */
	public void exit() throws InterruptedException {
		System.out.println("�����˳�ϵͳ");
		System.out.print("�����˳�ϵͳ");
		for (int i = 0; i < 4; i++) {
			System.out.print(".");
			Thread.sleep(800);
		}
		System.out.println("\nϵͳ�Ѿ��˳�����ӭ���´�ʹ�ã�");
	}
}
