package com.kgc.goodsmanagersystem;

/**
 * ��Ʒ��
 * 
 * @author Administrator
 * 
 */
public class Goods {
	/**
	 * ��Ʒ���
	 */
	private String id;
	/**
	 * ��Ʒ��
	 */
	private String name;
	/**
	 * �۸�
	 */
	private double price;
	/**
	 * ����
	 */
	private int num;

	/**
	 * �޲�������
	 */
	public Goods() {
	}

	/**
	 * �вι���
	 * 
	 * @param name
	 *            ��Ʒ��
	 * @param price
	 *            �۸�
	 * @param num
	 *            ��Ʒ����
	 */
	public Goods(String name, double price, int num) {
		this.id = "kgc" + ++GoodsManager.no;
		this.name = name;
		this.price = price;
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * չʾ��Ʒ
	 */
	public void show() {
		System.out.print(id);
		System.out.print("\t" + name);
		System.out.print("\t" + price);
		System.out.println("\t" + num);
	}
	/**
	 * ���۹���
	 * @param num	�ۿۼ�
	 */
	public void discount(double num) {
		price *= num;
	}
}