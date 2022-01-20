package draw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Grimpan extends JFrame implements ActionListener {

	private Content con = new Content();

	public Grimpan() {
		super("그림판");
		setLayout(null);
		setBounds(100, 100, 900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		con.close.addActionListener(this);
		add(con);
		setVisible(true);
		revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == con.close) {
			this.dispose();
		}

	}

}
