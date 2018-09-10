package com.day01;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class BallGame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image ball = Toolkit.getDefaultToolkit().createImage("images/ball.png");
	
	Image desk = Toolkit.getDefaultToolkit().createImage("images/desk.jpg");
	
	double x = 100;
	double y = 100;
	
	//boolean right = true;
	
	double degree = 3.14/3;//弧度，此处是60度
	//画窗口的方法
	public void paint(Graphics g) {
		System.out.println("窗口被画了一次");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x,(int)y, null);
		/*if(right) {
			x = x+10;
		}else {
			x= x-10;
		}
		if(x > 786) {
			right = false;
		}
		
		if(x < 40) {
			right = true;
		}*/
		x = x + 10 * Math.cos(degree);
		y = y + 10 * Math.sin(degree);
		
		if(y > 500-40-30 || y < 40+40) {//500是桌子高度，40是桌子边框，30是小球直径，最后40是标题栏高度
			degree = -degree;
		}
		//碰到左右边界
		if(x > 856-40-30 || x < 40) {
			degree = 3.14 - degree;
		}
	}
	
	//窗口加载
	void launchFrame() {
		setSize(856,500);
		setLocation(50, 50);
		setVisible(true);
		//重画窗口，每秒画25次
		while(true) {			
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//加载图片	
	public static void main(String[] args) {
		BallGame game = new BallGame();
		game.launchFrame();
	}
}
