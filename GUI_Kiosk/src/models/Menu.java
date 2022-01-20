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
				itemName = "아메리카노";
			} else if (this.num == 2) {
				itemName = "스페셜 아메리카노";
			} else if (this.num == 3) {
				itemName = "헤이즐넛 아메리카노";
			} else if (this.num == 4) {
				itemName = "유자 아메리카노";
			} else if (this.num == 5) {
				itemName = "카푸치노";
			} else if (this.num == 6) {
				itemName = "카페라떼";
			} else if (this.num == 7) {
				itemName = "헤이즐넛라떼";
			} else if (this.num == 8) {
				itemName = "바닐라라떼";
			} else if (this.num == 9) {
				itemName = "크리미라떼";
			} else if (this.num == 10) {
				itemName = "헤이즐넛 크리미라떼";
			} else if (this.num == 11) {
				itemName = "카페모카";
			} else if (this.num == 12) {
				itemName = "카라멜 마끼아또";
			} else if (this.num == 13) {
				itemName = "에스프레소";
			} else if (this.num == 14) {
				itemName = "더치커피";
			} else if (this.num == 15) {
				itemName = "더치시나몬라떼";
			} else if (this.num == 16) {
				itemName = "더치코코넛라떼";
			}
		} else if(category==2){
			if (this.num == 1) {
				itemName = "허니레몬티";
			} else if (this.num == 2) {
				itemName = "허니유자티";
			} else if (this.num == 3) {
				itemName = "허니자몽티";
			} else if (this.num == 4) {
				itemName = "얼그레이";
			} else if (this.num == 5) {
				itemName = "국화차";
			} else if (this.num == 6) {
				itemName = "민트초코티";
			} else if (this.num == 7) {
				itemName = "케모마일";
			} else if (this.num == 8) {
				itemName = "페퍼민트";
			} else if (this.num == 9) {
				itemName = "청포도 에이드";
			} else if (this.num == 10) {
				itemName = "보이차";
			} else if (this.num == 11) {
				itemName = "루이보스";
			} else if (this.num == 12) {
				itemName = "로즈힙";
			} else if (this.num == 13) {
				itemName = "히비스커스";
			} else if (this.num == 14) {
				itemName = "복숭아 아이스티";
			} else if (this.num == 15) {
				itemName = "블루 레몬에이드";
			} else if (this.num == 16) {
				itemName = "자몽 에이드";
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
