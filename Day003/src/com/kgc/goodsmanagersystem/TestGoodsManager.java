package com.kgc.goodsmanagersystem;

/**
 * ��Ʒ���������
 * 
 * @author Administrator
 * 
 */
public class TestGoodsManager {
	public static void main(String[] args) throws InterruptedException {
		//��������
		GoodsManager gm = new GoodsManager();
		//gm�����ʼ������
		gm.init();
		//��ӭ�˵�
		gm.startMenu();
	}
}
