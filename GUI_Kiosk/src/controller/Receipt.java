package controller;

import java.awt.Font;

import javax.swing.JLabel;

import models.Kiosk;
import models.MyUtil;

public class Receipt extends MyUtil{
	// table 데이터를 이용하여 영수증 그리기
	JLabel question = new JLabel();
	public Receipt() {
		setLayout(null);
		setBounds(0, 0, Kiosk.width, Kiosk.height);
		
		this.question.setBounds((Kiosk.width/2)-130, 550, 300, 80);
		this.question.setText("영수증을 출력하시겠습니까?");
		this.question.setFont(new Font("",Font.PLAIN,20));
		add(this.question);
	}
}
