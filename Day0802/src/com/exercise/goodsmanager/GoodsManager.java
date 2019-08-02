package com.exercise.goodsmanager;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 商品管理类
 * 
 * @author Administrator
 * 
 */
public class GoodsManager {

	Scanner input = new Scanner(System.in);

	/**
	 * 创建Goods对象数组存储商品信息
	 */
	Goods[] goodsArr = new Goods[200];

	/**
	 * 初始化商品管理
	 */
	public void init() {

		Goods goods1 = new Goods("apple", BigDecimal.valueOf(2.3), 24);
		Goods goods2 = new Goods("origin", BigDecimal.valueOf(1.2), 45);
		Goods goods3 = new Goods("banana", BigDecimal.valueOf(1.8), 21);

		goodsArr[0] = goods1;
		goodsArr[1] = goods2;
		goodsArr[2] = goods3;

	}

	/**
	 * 展示界面
	 */
	public void startMenu() {
		int choice;
		do {
			System.out.println("****商品管理系统*****");
			System.out.println("**** 1.添加商品*****");
			System.out.println("**** 2.展示商品*****");
			System.out.println("**** 3.删除商品*****");
			System.out.println("**** 4.模糊查询*****");
			System.out.println("**** 5.批量打折*****");
			System.out.println("**** 6.按价格降序***");
			System.out.println("**** 7.修改商品*****");
			System.out.println("**** 0.退       出*****");
			System.out.print("请选择功能：");
			choice = input.nextInt();

			switch (choice) {
			case 0:
				exit(); // 退出程序
				break;

			case 1:
				add(); // 添加商品
				break;

			case 2:
				show(); // 展示商品
				break;

			case 3:
				delete();//商品删除
				break;
				
			case 4:
				query();//查询商品
				break;
				
			case 5:
				discount();//商品批量打折
				break;
				
			case 6:
				 sortByPriceDesc();//价格降序排列
				 break;
			case 7:
				 update();//修改信息
				 break;
			default:
				System.out.println("请选择正确的功能！");
				break;
			}
		} while (choice != 0);
	}

	/**
	 * 添加商品
	 */
	public void add() {
		System.out.print("请输入要添加的商品名称：");
		String name = input.next();
		System.out.print("请输入【" + name + "】的价格：");
		BigDecimal price = input.nextBigDecimal();
		System.out.print("请输入【" + name + "】的数量：");
		int num = input.nextInt();
		Goods goods = new Goods(name, price, num);
		if (add(goods)) {
			System.out.println("【" + name + "】商品添加成功！");
		}
	}

	/**
	 * 添加商品功能实现
	 * 
	 * @param goods
	 *            Goods对象
	 */
	public boolean add(Goods goods) {
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] == null) {
				goodsArr[i] = goods;
				return true;
			}
		}
		return false;
	}

	/**
	 * 展示商品
	 */
	public void show() {
		
		show(goodsArr);
	}

	/**
	 * 展示商品信息
	 * 
	 * @param goods
	 *            Goods数组
	 */
	public void show(Goods[] goods) {
		System.out.println("编号\t名称\t价格\t数量");
		System.out.println("==================================");
		for (int i = 0; i < goods.length; i++) {
			if (goods[i] != null) {
				goods[i].show();
			}
		}
	}

	/**
	 * 删除商品
	 */
	public void delete(){
		System.out.println("请输入要删除的商品编号：");
		String no = input.next();
		if(isFind(no)){
			//找到要删除的商品的编号
			int index = -1;
			for (int i = 0; i < goodsArr.length; i++) {
				if(goodsArr[i] != null && goodsArr[i].getGoodsNo().equals(no)){
					index = i;
					break;
				}
			}
			for (int i = index; i < goodsArr.length - 1; i++) {
				goodsArr[i] = goodsArr[i+1];
			}
			goodsArr[goodsArr.length - 1] = null;
			System.out.println("编号为" + no + "的商品删除成功！");
		}else{
			System.out.println("没有" + no + "商品编号,无法删除！");
		}
	}
	
	/**
	 * 是否找到商品编号
	 * @param no
	 * @return
	 */
	public boolean isFind(String no){
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null && goodsArr[i].getGoodsNo().equals(no)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 模糊查询
	 */
	public void query(){
		System.out.println("请输入要查询的商品名称;");
		String name = input.next();
		if (query(name)) {
			int count = 0;
			for (int i = 0; i < goodsArr.length; i++) {
				if(goodsArr[i] != null && goodsArr[i].getGoodsName().contains(name)){
					count ++;
				}
			}
//			System.out.println(count);
			Goods[] goods = new Goods[count];
			int index = 0;
			for (int i = 0; i < goodsArr.length; i++) {
				if(goodsArr[i] != null && goodsArr[i].getGoodsName().contains(name)){
					goods[index++] = goodsArr[i];
				}
			}
			System.out.println("查询结果如下:");
			show(goods);
		}else{
			System.out.println("没有查询到相关商品！");
		}
		
	}
	
	/**
	 * 查询是否有可以显示的商品
	 * @param name
	 * @return
	 */
	public boolean query(String name){
		for (int i = 0; i < goodsArr.length; i++) {
			if(goodsArr[i] != null && goodsArr[i].getGoodsName().contains(name)){
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * 批量打折
	 */
	public void discount(){
		System.out.println("请输入要打折的商品折扣(0.0~1.0之间)");
		BigDecimal discount = input.nextBigDecimal();
		BigDecimal min = BigDecimal.valueOf(0);
		BigDecimal max = BigDecimal.valueOf(1);
		boolean flag = false;
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null) {
				if(discount.compareTo(min)> 0 && discount.compareTo(max) < 0){
					goodsArr[i].discount(discount);
					flag = true;
				}
			}
		}
		if (flag) {
			System.out.println("打折成功！全场" + discount + "折!");
		}else{
			System.out.println("这样的折扣不行~");
		}
	}

	/**
	 * 按照价格降序排列商品
	 */
	public void sortByPriceDesc(){
		Goods[] goods = new Goods[goodsArr.length];
		System.arraycopy(goodsArr, 0, goods, 0, goodsArr.length);
		for (int i = 0; i < goods.length - 1; i++) {
			if (goods[i] != null) {
				for (int j = i+1; j < goods.length; j++) {
					if (goods[j] != null && goods[i].getGoodsPrice().compareTo(goods[j].getGoodsPrice()) < 0) {
						Goods good = goods[i];
						goods[i] = goods[j];
						goods[j] = good;
					}
				}
			}
		}
		show(goods);
	}
	
	/**
	 * 更改信息
	 */
	public void update(){
		System.out.println("请输入要修改的商品编号");
		String no = input.next();
		if(isFind(no)){
			for (int i = 0; i < goodsArr.length; i++) {
				if(goodsArr[i]!=null && goodsArr[i].getGoodsNo().equals(no)){
					System.out.print("请输入要添加的商品名称：");
					String name = input.next();
					System.out.print("请输入【" + name + "】的价格：");
					BigDecimal price = input.nextBigDecimal();
					System.out.print("请输入【" + name + "】的数量：");
					int num = input.nextInt();
					goodsArr[i].setGoodsName(name);
					goodsArr[i].setGoodsPrice(price);
					goodsArr[i].setGoodsNum(num);
					System.out.println("信息修改成功！");
				}
			}
		}else{
			System.out.println("没有编号为【" + no + "】的商品");
		}
	}
	
	/**
	 * 退出程序
	 */
	public void exit() {
		System.out.println("准备退出程序...");
		System.out.print("程序退出中");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("\n程序退出成功，欢迎您下次使用！");
	}

}