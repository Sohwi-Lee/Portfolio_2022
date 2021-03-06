package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Menu {
	private int category, width, height, num, state, price;
	private String itemName, fileName;
	private ImageIcon image;

	public Menu(int category, int num, int width, int height) {
		this.num = num;
		this.category = category;
		this.width = width;
		this.height = height;
		if (num < 10) {
			this.fileName = String.format("images/menus/%s0%d.png", this.category == 1 ? "coffee_sub" : "tea_sub",
					this.num);
		} else {
			this.fileName = String.format("images/menus/%s%d.png", this.category == 1 ? "coffee_sub" : "tea_sub",
					this.num);
		}
		Image temp = new ImageIcon(fileName).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		this.image = new ImageIcon(temp);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		if (category == 1) {
			if (this.num == 1) {price=1500;
			} else if (this.num == 2) {price=2500;
			} else if (this.num == 3) {price=2000;
			} else if (this.num == 4) {price=2500;
			} else if (this.num == 5) {price=2500;
			} else if (this.num == 6) {price=2500;
			} else if (this.num == 7) {price=3000;
			} else if (this.num == 8) {price=3000;
			} else if (this.num == 9) {price=3000;
			} else if (this.num == 10) {price=3500;
			} else if (this.num == 11) {price=3500;
			} else if (this.num == 12) {price=3500;
			} else if (this.num == 13) {price=1500;
			} else if (this.num == 14) {price=2500;
			} else if (this.num == 15) {price=3000;
			} else if (this.num == 16) {price=3000;}
		} else if(category==2){
			if (this.num == 1) {price=3500;
			} else if (this.num == 2) {price=3500;
			} else if (this.num == 3) {price=3500;
			} else if (this.num == 4) {price=2500;
			} else if (this.num == 5) {price=2500;
			} else if (this.num == 6) {price=2500;
			} else if (this.num == 7) {price=2500;
			} else if (this.num == 8) {price=2500;
			} else if (this.num == 9) {price=3500;
			} else if (this.num == 10) {price=2500;
			} else if (this.num == 11) {price=2500;
			} else if (this.num == 12) {price=2500;
			} else if (this.num == 13) {price=2500;
			} else if (this.num == 14) {price=3000;
			} else if (this.num == 15) {price=3500;
			} else if (this.num == 16) {price=3500;}
		}
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getItemName() {
		if (category == 1) {
			if (this.num == 1) {
				itemName = "??????????";
			} else if (this.num == 2) {
				itemName = "?????? ??????????";
			} else if (this.num == 3) {
				itemName = "???????? ??????????";
			} else if (this.num == 4) {
				itemName = "???? ??????????";
			} else if (this.num == 5) {
				itemName = "????????";
			} else if (this.num == 6) {
				itemName = "????????";
			} else if (this.num == 7) {
				itemName = "????????????";
			} else if (this.num == 8) {
				itemName = "??????????";
			} else if (this.num == 9) {
				itemName = "??????????";
			} else if (this.num == 10) {
				itemName = "???????? ??????????";
			} else if (this.num == 11) {
				itemName = "????????";
			} else if (this.num == 12) {
				itemName = "?????? ????????";
			} else if (this.num == 13) {
				itemName = "??????????";
			} else if (this.num == 14) {
				itemName = "????????";
			} else if (this.num == 15) {
				itemName = "??????????????";
			} else if (this.num == 16) {
				itemName = "??????????????";
			}
		} else if(category==2){
			if (this.num == 1) {
				itemName = "??????????";
			} else if (this.num == 2) {
				itemName = "??????????";
			} else if (this.num == 3) {
				itemName = "??????????";
			} else if (this.num == 4) {
				itemName = "????????";
			} else if (this.num == 5) {
				itemName = "??????";
			} else if (this.num == 6) {
				itemName = "??????????";
			} else if (this.num == 7) {
				itemName = "????????";
			} else if (this.num == 8) {
				itemName = "????????";
			} else if (this.num == 9) {
				itemName = "?????? ??????";
			} else if (this.num == 10) {
				itemName = "??????";
			} else if (this.num == 11) {
				itemName = "????????";
			} else if (this.num == 12) {
				itemName = "??????";
			} else if (this.num == 13) {
				itemName = "??????????";
			} else if (this.num == 14) {
				itemName = "?????? ????????";
			} else if (this.num == 15) {
				itemName = "???? ??????????";
			} else if (this.num == 16) {
				itemName = "???? ??????";
			}
		}
		
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

}
