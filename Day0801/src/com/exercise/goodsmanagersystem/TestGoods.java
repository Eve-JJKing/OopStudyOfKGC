package com.exercise.goodsmanagersystem;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Goods≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class TestGoods {
	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.setGoodsName("s");
		goods.setGoodsPrice(BigDecimal.valueOf(2.3));
		goods.setGoodsNum(45);
		goods.show();
	/*	Goods goods1= new Goods("apple",3,50);
		Goods goods2= new Goods("apple",-3.5,50);
		Goods goods4= new Goods("apple",3.5,-50);
	
		goods1.show();
		goods2.show();*/
//		goods4.show();
		
		}
}
