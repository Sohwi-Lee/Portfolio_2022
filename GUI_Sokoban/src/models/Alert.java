package models;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Alert extends JFrame{
	
	private JLabel text = new JLabel();
	public Alert() {
		super("Clear");
		setLayout(null);
		setBounds((GameFrame.W/2)-(GameFrame.width/2), (GameFrame.H/2)-(GameFrame.height/2),200, 200);
		
		text.setBounds(0, 0, 200, 150);
		text.setText("Game Clear!");
		text.setFont(new Font("",Font.BOLD,20));
		text.setHorizontalAlignment(JLabel.CENTER);
		
		add(text);
		setVisible(true);
		revalidate();
		
	}

}
