package com.exercise.goodsmanagersystem;

import java.math.BigDecimal;

/**
 * 商品类
 * @author Administrator
 *
 */
public class Goods {
	private BigDecimal min = BigDecimal.valueOf(0);
	/**
	 * 控制商品编号自增
	 */
	public static int no = 0;
	
	
	/**
	 * 商品编号
	 */
	private String goodsNo;
	/**
	 * 商品名称
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
	
	
	//getter和setter  方法
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
		if(goodsPrice.compareTo(min) > 0 ){
			this.goodsPrice = goodsPrice;
		}else{
			System.out.println("不能赔钱卖呀！");
			this.goodsPrice = min;
		}
		
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		if (goodsNum >= 0) {
			this.goodsNum = goodsNum;
		}else{
			System.out.println("商品数量不能为负数！");
			this.goodsNum = 0;
		}
		
	}

	/**
	 * 无参构造方法
	 */
	public Goods(){
		this.goodsNo = "goods"+ ++no;
	}
	
	/**
	 * 有参构造方法
	 * @param name	商品名
	 * @param price	商品价格
	 * @param num	商品数量
	 */
	public Goods(String name, BigDecimal price, int num){
		this.goodsNo = "goods"+ ++no;
		this.goodsName = name;
		if(price.compareTo(min) > 0 || price.equals(min) ){
			this.goodsPrice = price;
		}else{
			System.out.println(this.goodsNo + "不能赔钱卖呀！");
			this.goodsPrice = min;
		}
		if (num >= 0) {
			this.goodsNum = num;
		}else{
			System.out.println(this.goodsNo + "商品数量不能为负数！");
			this.goodsNum = 0;
		}
	}
	
	/**
	 * 展示商品
	 */
	public void show(){
		System.out.println(goodsNo + "\t" + goodsName + "\t" + goodsPrice + "\t" + goodsNum);
	}
}
