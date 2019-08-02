package com.frame;


import java.awt.Graphics;

import javax.swing.*;

public class Test{
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(400,300);
		f.setLocation(200,200);
		
		MyPanel mp = new MyPanel();
		f.add(mp);

		Thread t = new Thread(mp);
		t.start();
		
		f.setVisible(true);
	}
	
}

class MyPanel extends JPanel implements Runnable{
	int x = 40;
	int y = 40;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.fillOval(x, y, 5, 5);
	}
	@Override
	public void run() {
		boolean right = true;
		boolean down = true;
		// TODO Auto-generated method stub
		while(true){
			
			if(right){
				x += 2;
			}else{
				x -= 2;
			}
			if(x == 360){
				right = false;
			}
			if(x == 0){
				right = true;
			}
			
			if(down){
				y += 2;
			}else{
				y -= 2;
			}
			
			if(y == 230){
				down = false;
			}
			if(y == 0){
				down = true;
			}
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}
	
	
}