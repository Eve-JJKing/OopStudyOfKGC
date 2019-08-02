package com.kgc.goodsmanagersystem;

/**
 * 商品类
 * 
 * @author Administrator
 * 
 */
public class Goods {
	/**
	 * 商品编号
	 */
	private String id;
	/**
	 * 商品名
	 */
	private String name;
	/**
	 * 价格
	 */
	private double price;
	/**
	 * 数量
	 */
	private int num;

	/**
	 * 无参数构造
	 */
	public Goods() {
	}

	/**
	 * 有参构造
	 * 
	 * @param name
	 *            商品名
	 * @param price
	 *            价格
	 * @param num
	 *            商品数量
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
	 * 展示商品
	 */
	public void show() {
		System.out.print(id);
		System.out.print("\t" + name);
		System.out.print("\t" + price);
		System.out.println("\t" + num);
	}
	/**
	 * 打折功能
	 * @param num	折扣价
	 */
	public void discount(double num) {
		price *= num;
	}
}