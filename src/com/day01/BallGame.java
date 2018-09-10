package com.day01;

import javax.swing.JFrame;

public class BallGame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	void launchFrame() {
		setSize(300,300);
		setLocation(50, 50);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		BallGame game = new BallGame();
		game .launchFrame();
	}
}
