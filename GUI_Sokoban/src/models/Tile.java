package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tile {

	public static final int GROUND = 1;
	public static int WALL = 2;
	public static int PLAYER = 3;
	public static int BOX = 4;
	public static int POINT = 5;
	public static int BOXGOAL = 6;
	
	private int x, y, w, h, state;
	private String fileName;
	private ImageIcon image;
	
	public Tile(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h; this.fileName=fileName;
//		this.image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
		Image temp = new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		this.image = new ImageIcon(temp);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		// 이미지 바꿔주기
		this.fileName = String.format("images/tile%d.png",this.state);
		Image temp = new ImageIcon(fileName).getImage().getScaledInstance(w,h,Image.SCALE_SMOOTH);
		this.image = new ImageIcon(temp);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public String getFileName() {
		return fileName;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setFileName(String fileName) {
		// TODO Auto-generated method stub
		this.fileName = fileName;
	}

}
