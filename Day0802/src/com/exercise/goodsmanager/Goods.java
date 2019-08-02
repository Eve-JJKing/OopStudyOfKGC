package com.exercise.goodsmanager;

import java.math.BigDecimal;

/**
 * 商品类
 * @author Administrator
 *
 */
public class Goods {
	
	public static int no;
	
	/**
	 * 商品编号
	 */
	private String goodsNo;
	/**
	 * 商品名字
	 */
	private String goodsName;
	/**
	 * 商品价格
	 */
	private BigDecimal goodsPrice;
	/**
	 * 商品数量
	 */
	private int goodsNum;
	
	/**
	 * 默认构造方法
	 */
	public Goods(){
		this.goodsNo = "kgc" + ++no;		//商品编号自增
	}
	
	public Goods(String name, BigDecimal price, int num){
		this.goodsNo = "kgc" + ++no;
		this.goodsName = name;
		this.goodsPrice = price;
		this.goodsNum = num;
	}
	
	
	//get 和  set 方法
	public String getGoodsNo() {
		return goodsNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}



	/**
	 * 展示商品
	 */
	public void show(){
		System.out.println(goodsNo + "\t" + goodsName + "\t" + goodsPrice + "\t" + goodsNum);
	}
	
	/**
	 * 商品打折
	 * @param num
	 */
	public void discount(BigDecimal num){
		this.goodsPrice = this.goodsPrice.multiply(num); 
	}
	
	
}
