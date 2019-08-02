package com.exercise.goodsmanager;

import java.math.BigDecimal;

/**
 * ��Ʒ��
 * @author Administrator
 *
 */
public class Goods {
	
	public static int no;
	
	/**
	 * ��Ʒ���
	 */
	private String goodsNo;
	/**
	 * ��Ʒ����
	 */
	private String goodsName;
	/**
	 * ��Ʒ�۸�
	 */
	private BigDecimal goodsPrice;
	/**
	 * ��Ʒ����
	 */
	private int goodsNum;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Goods(){
		this.goodsNo = "kgc" + ++no;		//��Ʒ�������
	}
	
	public Goods(String name, BigDecimal price, int num){
		this.goodsNo = "kgc" + ++no;
		this.goodsName = name;
		this.goodsPrice = price;
		this.goodsNum = num;
	}
	
	
	//get ��  set ����
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
	 * չʾ��Ʒ
	 */
	public void show(){
		System.out.println(goodsNo + "\t" + goodsName + "\t" + goodsPrice + "\t" + goodsNum);
	}
	
	/**
	 * ��Ʒ����
	 * @param num
	 */
	public void discount(BigDecimal num){
		this.goodsPrice = this.goodsPrice.multiply(num); 
	}
	
	
}
