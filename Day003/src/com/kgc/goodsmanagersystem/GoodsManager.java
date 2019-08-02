package com.kgc.goodsmanagersystem;

import java.util.Scanner;

/**
 * 商品管理类
 * @author Administrator 
 *
 */
public class GoodsManager {
	//商品编号自增使用的静态变量
	public static int no;
	
	Scanner input = new Scanner(System.in);
	//存储商品的数组
	Goods[] goods = new Goods[500];
	
	//初始化方法
	public void init(){
		Goods goods1 = new Goods();
		goods1.setId("kgc" + ++no);
		goods1.setName("香蕉");
		goods1.setPrice(1.2);
		goods1.setNum(80);

		Goods goods2 = new Goods();
		goods2.setId("kgc" + ++no);
		goods2.setName("苹果");
		goods2.setPrice(3.5);
		goods2.setNum(67);
		
		Goods goods3 = new Goods();
		goods3.setId("kgc" + ++no);
		goods3.setName("橘子");
		goods3.setPrice(2);
		goods3.setNum(125);
		
		//将对象添加到数组中
		goods[0] = goods1;
		goods[1] = goods2;
		goods[2] = goods3;
	}
	
	/**
	 * 显示所有货物信息
	 */
	public void showAllGoods(Goods[] arr){
		System.out.println("编号\t商品名\t价格\t货量");
		System.out.println("===========================");
		for (Goods good : arr) {
			if(good != null){
				good.show();
			}
		}
	}
	
	/**
	 * 添加商品是否成功
	 * @param good	商品对象
	 */
	public boolean addGoods(Goods good){
		boolean flag = false;
		for (int i = 0; i < goods.length; i++) {
			if(goods[i] == null){
				goods[i] = good;
				flag = true;
				break;
			}
		}
		return flag;
		
	}
	
	/**
	 * 添加商品方法
	 */
	public void add(){
		System.out.print("请输入商品名称：");
		String name = input.next();
		System.out.print("请输入" + name + "价格：");
		double price = input.nextDouble();
		System.out.print("请输入" + name + "数量：");
		int num = input.nextInt();
		Goods good = new Goods(name,price,num);
		if(addGoods(good)){
			System.out.println("Add Success!");
			System.out.println();
		}else{
			System.out.println("default");
		}
	}
	
	/**
	 * 判断是否删除
	 * @param id	要删除的商品编号
	 * @return	是否删除成功
	 */
	public boolean delGoods(String id){
		for (int i = 0; i < goods.length;i++) {
			if(goods[i] != null && goods[i].getId().equals(id)){
				for (int j = i; j < goods.length - 1; j++) {
					goods[j] = goods[j+1];
				}
				goods[goods.length - 1] = null;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 删除功能
	 */
	public void delete(){
		System.out.println("请输入要烧出的商品编号：");
		String goodsId = input.next();
		if(delGoods(goodsId)){
			System.out.println("删除成功");
			System.out.println();
		}else{
			System.out.println("删除失败");
			System.out.println();
		}
	}
	
	/**
	 * 模糊查询
	 */
	public void query(){
		System.out.println("");
	}
	
	/**
	 * 是否查询到
	 * @param name
	 * @return
	 */
	public boolean queryGoods(String name){
		for (int i = 0; i < goods.length; i++) {
			if (goods[i] != null  && goods[i].getName().contains(name)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 批量打折
	 */
	public void discount(){
		System.out.println("请输入折扣：");
		double discountNum = input.nextDouble();
		for (int i = 0; i < goods.length; i++) {
			if (goods[i] != null) {
				goods[i].discount(discountNum);
			}
		}
	}
	
	public void discountPlus(){
		System.out.println("请输入要批量打折的商品编号(以，隔开)：");
		String nos = input.next();
		System.out.println("请输入折扣：");
		double discountNum = input.nextDouble();
		discount(nos.split(","),discountNum);
	}
	
	/**
	 * 批量打折升级版
	 * @param nos	要打折的编号数组
	 * @param discountNum	折扣价
	 */
	public void discount(String[] nos, double discountNum){
		boolean flag = false;
		for (int i = 0; i < nos.length; i++) {
			
			for (int j = 0; j < goods.length; j++) {
				if (goods[j] != null && goods[j].getId().equals(nos[i])) {
					goods[j].discount(discountNum);
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("没有【" + nos[i] + "】商品，打折失败！");
			}else{
				System.out.println("【" + nos[i] + "】商品，打折成功！");
			}
		}
		
	}
	
	/**
	 * 按照价格降序排列
	 */
	public void sortByPrice(){
		Goods[] newGoods = new Goods[goods.length];
		System.arraycopy(goods, 0, newGoods, 0, goods.length);
		for (int i = 0; i < newGoods.length - 1; i++) {
			if (newGoods[i] != null) {
				for (int j = i+1; j < newGoods.length; j++) {
					if (newGoods[j] != null && newGoods[i].getPrice() < newGoods[j].getPrice()) {
						Goods temp = newGoods[i];
						newGoods[i] = newGoods[j];
						newGoods[j] = temp;
					}
				}
			}
		}
		showAllGoods(newGoods);
		
	}
	
	/**
	 * 退出系统
	 * @throws InterruptedException
	 */
	public void exit() throws InterruptedException{
		System.out.print("退出系统中");
		for (int i = 0; i < 6; i++) {
			Thread.sleep(1000);
			System.out.print(".");
		}
		System.out.println("\n系统已经推出，欢迎您下次使用！");
	}
	
	/**
	 * 开始菜单
	 * @throws InterruptedException
	 */
	public void startMenu() throws InterruptedException{
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
    		System.out.print("请选择");
    		choice = input.nextInt();
    		switch (choice) {
    		
			case 0:
				exit();				//退出系统
				break;
				
			case 1:
				add();				//添加商品
				break;
			
			case 2:
				showAllGoods(goods);		//展示商品
				break;
			
			case 3:
				delete();			//删除商品
				break;
				
			case 8:
				discountPlus();		//打折加强版
				break;
				
			case 5:
				discount();			//批量打折
				break;
			case 6:
				sortByPrice();
				break;
			}
		} while (choice != 0);
	}
}
