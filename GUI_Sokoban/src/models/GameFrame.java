package models;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controller.GamePanel;

public class GameFrame extends JFrame{
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int W=dm.width;
	public static int H=dm.height;
	
	public static int width = 600;
	public static int height= 680;
	
	GamePanel gp = new GamePanel();
	
	public GameFrame() {
		setLayout(null);
		setBounds((W/2)-(width/2), (H/2)-(height/2), width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(gp);
		setVisible(true);
		revalidate();
	}

}
