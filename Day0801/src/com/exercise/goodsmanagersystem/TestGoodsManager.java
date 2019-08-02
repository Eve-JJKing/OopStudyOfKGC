package com.exercise.goodsmanagersystem;
/**
 * 商品管理类测试类
 * @author Administrator
 *
 */
public class TestGoodsManager {
	public static void main(String[] args) throws InterruptedException {
		GoodsManager manager = new GoodsManager();
		manager.init();
		manager.startMenu();
		
	}
}
