package com.exercise.goodsmanagersystem;

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

	// 声明一个存商品对象的数组
	Goods[] goodsArr = new Goods[200];

	public void init() {
		// 创建商品对象（两种方法）
		Goods goods1 = new Goods("香蕉", BigDecimal.valueOf(2.2), 20);
		Goods goods2 = new Goods("橘子", BigDecimal.valueOf(1.5), 15);
		Goods goods3 = new Goods();
		goods3.setGoodsName("荔枝");
		goods3.setGoodsPrice(BigDecimal.valueOf(5.6));
		goods3.setGoodsNum(10);
		Goods goods4 = new Goods("apple", BigDecimal.valueOf(5.6), 10);
		// 将对象存到数组里面
		goodsArr[0] = goods1;
		goodsArr[1] = goods2;
		goodsArr[2] = goods3;
		goodsArr[3] = goods4;
	}

	/**
	 * 展示开始菜单
	 * 
	 * @throws InterruptedException
	 */
	public void startMenu() throws InterruptedException {
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
			case 1: // 添加商品
				add();
				break;
			case 2: // 展示商品
				showAllGoods(goodsArr);
				break;
			case 3: // 删除商品
				delete();
				break;
			case 4: // 模糊查询
				query();
				break;
			case 5: // 批量打折
				channel();
				break;
			case 6: // 按价格降序
				sort();
				break;
			case 7: // 修改商品
				update();
				break;
			case 0: // 退 出
				exit();
				break;
			default:
				System.out.println("请选择正确的数字选项");
				break;
			}
		} while (choice != 0);
	}

	/**
	 * 添加商品
	 */
	public void add() {
		System.out.println("请输入要添加的商品名称：");
		String addGoodsName = input.next();
		System.out.println("请输入" + addGoodsName + "的价格：");
		BigDecimal addGoodsPrice = input.nextBigDecimal();
		System.out.println("请输入" + addGoodsName + "的数量：");
		int addGoodsNum = input.nextInt();
		Goods goods = new Goods(addGoodsName, addGoodsPrice, addGoodsNum);
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] == null) {
				goodsArr[i] = goods;
				System.out.println("添加成功！");
				return;
			}
		}
		System.out.println("添加失败！");
	}

	/**
	 * 展示商品
	 * 
	 * @param arr
	 *            Goods数组
	 */
	public void showAllGoods(Goods[] arr) {
		System.out.println("编号\t名称\t价格\t数量");
		System.out.println("=============================");
		for (Goods goods : arr) {
			if (goods != null) {
				goods.show();
			}
		}
	}

	/**
	 * 删除
	 */
	public void delete() {
		boolean flag = false; // 判断是否查找到该商品
		int index = -1;
		System.out.println("请输入要删除的产品编号：");
		String delGoodsNo = input.next();
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null
					&& goodsArr[i].getGoodsNo().equals(delGoodsNo)) {
				index = i; // 商品定位
				flag = true;
			}
		}
		if (flag) {
			for (int i = index; i < goodsArr.length - 1; i++) {
				goodsArr[i] = goodsArr[i + 1];
			}
			goodsArr[goodsArr.length - 1] = null;
			System.out.println("删除成功！");
		} else {
			System.out.println("没有该商品！");
		}
	}

	/**
	 * 模糊查询
	 */
	public void query() {
		int queryCount = 0; // 查询到的相关商品数量
		boolean flag = false; // 是否有相关商品
		System.out.println("请输入要查询的商品名称：");
		String queryGoodsName = input.next();
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null
					&& goodsArr[i].getGoodsName().contains(queryGoodsName)) {
				queryCount++;
				flag = true;
			}
		}
		if (flag) {
			int index = 0;
			Goods[] newGoodsArr = new Goods[queryCount];
			for (int i = 0; i < goodsArr.length; i++) {
				if (goodsArr[i] != null
						&& goodsArr[i].getGoodsName().contains(queryGoodsName)) {
					newGoodsArr[index] = goodsArr[i];
					index++;
				}
			}
			showAllGoods(newGoodsArr);
		} else {
			System.out.println("未查询到相关商品");
		}
	}

	/**
	 * 批量打折
	 */
	public void channel() {
		BigDecimal min = BigDecimal.valueOf(0);
		BigDecimal max = BigDecimal.valueOf(10);
		System.out.println("请输入折扣：");
		BigDecimal num = input.nextBigDecimal();
		BigDecimal channelNum = BigDecimal.valueOf(0.1);
		if (num.compareTo(min)>0 && num.compareTo(max) < 0) {
			for (int i = 0; i < goodsArr.length; i++) {
				if (goodsArr[i] != null) {
					// 避免出现误差，先将价格转换
					goodsArr[i].setGoodsPrice(goodsArr[i].getGoodsPrice().multiply(num).multiply(channelNum));
				}
			}
		} else {
			System.out.println("没有这种折扣！");
		}
	}
	
	/**
	 * 降序排列
	 */
	public void sort() {
		boolean flag = false;
		int count = 0;
		//查找有多少件商品
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null) {
				count ++;
				flag = true;
			}
		}
		if (flag) {
			Goods[] newGoods  = new Goods[count];
			int index = 0;
			//将商品放到新的数组中
			for (int i = 0; i < goodsArr.length; i++) {
				if (goodsArr[i] != null) {
					newGoods[index] = goodsArr[i];
					index++;
				}
			}
			//冒泡排序（条件：商品价格，排序商品对象）
			for (int i = 0; i < newGoods.length -1; i++) {
				for (int j = 0; j < newGoods.length - 1 - i; j++) {
					if (newGoods[j].getGoodsPrice().compareTo(newGoods[j+1].getGoodsPrice()) < 0) {
						Goods goods = newGoods[j];
						newGoods[j] = newGoods[j+1];
						newGoods[j+1] = goods;
					}
				}
			}
			
			System.out.println("按价格排序结果：");
			showAllGoods(newGoods);
		}else{
			System.out.println("没有商品！");
		}
	}
	
	/**
	 * 根据编号修改商品
	 */
	public void update(){
		boolean flag = false;
		System.out.println("请输入要修改的商品编号：");
		String updateGoodsNo = input.next();
		for (int i = 0; i < goodsArr.length; i++) {
			if (goodsArr[i] != null && goodsArr[i].getGoodsNo().equals(updateGoodsNo)) {
				flag = true;
			}
		}
		if (flag) {
			System.out.println("请输入要修改的商品名称：");
			String updateGoodsName = input.next();
			System.out.println("请输入" + updateGoodsName + "的价格：");
			BigDecimal updateGoodsPrice = input.nextBigDecimal();
			System.out.println("请输入" + updateGoodsName + "的数量：");
			int updateGoodsNum = input.nextInt();
			
			for (int i = 0; i < goodsArr.length; i++) {
				if (goodsArr[i] != null && goodsArr[i].getGoodsNo().equals(updateGoodsNo) ) {
					goodsArr[i].setGoodsName(updateGoodsName);
					goodsArr[i].setGoodsPrice(updateGoodsPrice);
					goodsArr[i].setGoodsNum(updateGoodsNum);
					System.out.println("修改成功！");
					return;
				}
			}
		}else{
			System.out.println("没有该商品！");
		}
	}

	/**
	 * 退出系统
	 * 
	 * @throws InterruptedException
	 */
	public void exit() throws InterruptedException {
		System.out.println("即将退出系统");
		System.out.print("正在退出系统");
		for (int i = 0; i < 4; i++) {
			System.out.print(".");
			Thread.sleep(800);
		}
		System.out.println("\n系统已经退出，欢迎您下次使用！");
	}
}
