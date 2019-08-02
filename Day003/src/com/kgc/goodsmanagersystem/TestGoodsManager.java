package com.kgc.goodsmanagersystem;

/**
 * 商品管理测试类
 * 
 * @author Administrator
 * 
 */
public class TestGoodsManager {
	public static void main(String[] args) throws InterruptedException {
		//创建对象
		GoodsManager gm = new GoodsManager();
		//gm对象初始化方法
		gm.init();
		//欢迎菜单
		gm.startMenu();
	}
}
