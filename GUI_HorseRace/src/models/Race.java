package models;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controller.Racing;

public class Race extends JFrame {
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	// 스크린사이즈
	public static final int W = dm.width;
	public static final int H = dm.height;
	// 창 크기
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;

	private Racing rp = new Racing();

	public Race() {
		super("Racing Game");
		setLayout(null);
		setBounds((W / 2) - (WIDTH / 2), (H / 2) - (HEIGHT / 2), WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 종료조건
		add(rp);
		setVisible(true);
		revalidate();// 갱신메서드
		rp.run();
	}

}
