package controller;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import models.Kiosk;
import models.MyUtil;

public class CardPanel extends MyUtil {

	ImageIcon imgPos = new ImageIcon(
			new ImageIcon("images/pic/posPic.jpg").getImage().getScaledInstance(300, 188, Image.SCALE_SMOOTH));
	ImageIcon imgText = new ImageIcon(
			new ImageIcon("images/pic/text_info.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH));
	JLabel posInfo = new JLabel(imgPos);
	JLabel textInfo = new JLabel(imgText);

	public CardPanel() {
		setLayout(null);
		setBounds(0, 0, Kiosk.width, Kiosk.height);
		setBackground(Color.white);
		this.posInfo.setBounds((Kiosk.width / 2) - 225, 680, 300, 188);
		this.textInfo.setBounds((Kiosk.width / 2) - 200, (Kiosk.height / 2) - 150, 300, 200);
		add(this.posInfo);
		add(this.textInfo);
		

	}

}
