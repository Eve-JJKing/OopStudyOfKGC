package com.exercise.goodsmanagersystem;

import java.math.BigDecimal;

/**
 * ��Ʒ��
 * @author Administrator
 *
 */
public class Goods {
	private BigDecimal min = BigDecimal.valueOf(0);
	/**
	 * ������Ʒ�������
	 */
	public static int no = 0;
	
	
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
	
	
	//getter��setter  ����
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
			System.out.println("������Ǯ��ѽ��");
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
			System.out.println("��Ʒ��������Ϊ������");
			this.goodsNum = 0;
		}
		
	}

	/**
	 * �޲ι��췽��
	 */
	public Goods(){
		this.goodsNo = "goods"+ ++no;
	}
	
	/**
	 * �вι��췽��
	 * @param name	��Ʒ��
	 * @param price	��Ʒ�۸�
	 * @param num	��Ʒ����
	 */
	public Goods(String name, BigDecimal price, int num){
		this.goodsNo = "goods"+ ++no;
		this.goodsName = name;
		if(price.compareTo(min) > 0 || price.equals(min) ){
			this.goodsPrice = price;
		}else{
			System.out.println(this.goodsNo + "������Ǯ��ѽ��");
			this.goodsPrice = min;
		}
		if (num >= 0) {
			this.goodsNum = num;
		}else{
			System.out.println(this.goodsNo + "��Ʒ��������Ϊ������");
			this.goodsNum = 0;
		}
	}
	
	/**
	 * չʾ��Ʒ
	 */
	public void show(){
		System.out.println(goodsNo + "\t" + goodsName + "\t" + goodsPrice + "\t" + goodsNum);
	}
}
