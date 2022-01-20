package controller;

import java.awt.Font;

import javax.swing.JLabel;

import models.Kiosk;
import models.MyUtil;

public class CashPanel extends MyUtil {

	JLabel info = new JLabel();

	public CashPanel() {
		setLayout(null);
		setBounds(0, 0, Kiosk.width, Kiosk.height);

		info.setBounds(0, Kiosk.height / 2 - 250, Kiosk.width, 500);
		info.setText("현금을 투입구에 넣어주십시오");
		info.setFont(new Font("", Font.PLAIN, 30));
		info.setHorizontalAlignment(JLabel.CENTER);
		add(info);
	}
}
