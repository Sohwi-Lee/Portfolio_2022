package models;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.CardPanel;
import controller.CashPanel;
import controller.CoffeePanel;
import controller.PayPanel;
import controller.Receipt;
import controller.TablePanel;
import controller.TeaPanel;

class HereOrTogo extends JPanel {
	public HereOrTogo() {
		setLayout(null);
		setBounds(0, 0, Kiosk.width, Kiosk.height);
	}
}

public class Kiosk extends JFrame implements ActionListener {

	public static Vector<Vector<String>> selectItems = new Vector<>();
	// â ũ�� ����
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int W = dm.width;
	public static int H = dm.height;
	public static int width = 800;
	public static int height = 1000;

	// ���� or ���� ���ù�ư
	ImageIcon hereImg = new ImageIcon(
			new ImageIcon("images/pic/inDrink.png").getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH));
	ImageIcon togoImg = new ImageIcon(
			new ImageIcon("images/pic/takeout.png").getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH));
	JButton here = new JButton(hereImg); // ����
	JButton toGo = new JButton(togoImg); // ����

	// coffee & tea ���ù�ư
	JButton btnCoffee = new JButton();
	JButton btnTea = new JButton();
	public static int COFFEE = 1;
	public static int TEA = 2;

	// �޴����� �� ���� ��ư
	JButton selectFinish = new JButton();
	public static int total; // �ѱݾ�
	public static JLabel totalText = new JLabel();

	// ������� ���ù�ư
	JButton card = new JButton();
	JButton cash = new JButton();

	// ��������� ���ù�ư
	JButton receiptY = new JButton();
	JButton receiptN = new JButton();

	// �� ������ �гε�
	HereOrTogo firstPage = new HereOrTogo();
	TablePanel showTable = new TablePanel();
	CoffeePanel coffeeMenus = new CoffeePanel();
	TeaPanel teaMenus = new TeaPanel();
	PayPanel payment = new PayPanel();
	CardPanel payCard = new CardPanel();
	CashPanel payCash = new CashPanel();
	Receipt rec = new Receipt();
	private static Component add;

	public Kiosk() {
		super("KIOSK_SH");
		setLayout(null);
//		setBounds((W / 2) - (width / 2), (H / 2) - (height / 2), width, height);
		setBounds((W / 2) - (width / 2), 0, width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setFirstPageBtn();
		setSecondPageBtn();
//		selectItems = new Vector<>();
		setVisible(true);
		revalidate();
	}

	private void setFourthPageBtn() {
		this.receiptY.setBounds(200, 630, 180, 150);
		this.receiptN.setBounds(420, 630, 180, 150);
		this.receiptY.setBackground(Color.white);
		this.receiptN.setBackground(Color.white);
		this.receiptY.setText("��");
		this.receiptN.setText("�ƴϿ�");
		this.receiptY.setFont(new Font("", Font.BOLD, 30));
		this.receiptN.setFont(new Font("", Font.BOLD, 30));
		this.receiptY.addActionListener(this);
		this.receiptN.addActionListener(this);
		add(this.receiptY);
		add(this.receiptN);
	}

	private void setThirdPageBtn() {
		this.card.setBounds(200, (Kiosk.H / 2) - (Kiosk.height / 2) + 300, 180, 180);
		this.cash.setBounds(420, (Kiosk.H / 2) - (Kiosk.height / 2) + 300, 180, 180);
		this.card.setBackground(Color.white);
		this.cash.setBackground(Color.white);
		this.card.setText("ī�����");
		this.cash.setText("���ݰ���");
		this.card.setFont(new Font("", Font.BOLD, 30));
		this.cash.setFont(new Font("", Font.BOLD, 30));
		this.card.addActionListener(this);
		this.cash.addActionListener(this);
		add(this.card);
		add(this.cash);
	}

	private void setSecondPageBtn() {
		this.btnCoffee.setBounds((Kiosk.width / 2) - 50 - 50, 30, 100, 50);
		this.btnTea.setBounds((Kiosk.width / 2), 30, 100, 50);
		this.selectFinish.setBounds((Kiosk.width / 2) - 60, 840, 120, 80);

		this.btnCoffee.setBackground(Color.white); // �ʱ� ����â - coffee
		this.btnTea.setBackground(Color.gray);
		this.selectFinish.setBackground(Color.yellow);

		this.btnCoffee.setBorderPainted(false);
		this.btnTea.setBorderPainted(false);

		this.btnCoffee.setText("Coffee");
		this.btnTea.setText("Tea");
		this.selectFinish.setText("����");// ���� ����߷��ֱ�

		this.btnCoffee.setFont(new Font("", Font.BOLD, 15));
		this.btnTea.setFont(new Font("", Font.BOLD, 15));
		this.selectFinish.setFont(new Font("", Font.BOLD, 20));

		this.btnCoffee.addActionListener(this);
		this.btnTea.addActionListener(this);
		this.selectFinish.addActionListener(this);

	}

	private void setFirstPageBtn() {
		this.here.setBounds(200, (Kiosk.H / 2) - (Kiosk.height / 2) + 300, 180, 180);
		this.here.setBackground(Color.white);
		this.here.addActionListener(this);
		add(this.here);

		this.toGo.setBounds(420, (Kiosk.H / 2) - (Kiosk.height / 2) + 300, 180, 180);
		this.toGo.setBackground(Color.white);
		this.toGo.addActionListener(this);
		add(this.toGo);

	}

	public static void calculate() { // �հ� ���
		total = 0;
		for (int i = 0; i < selectItems.size(); i++) {
			int count = Integer.parseInt(selectItems.get(i).get(1));
			int price = Integer.parseInt(selectItems.get(i).get(2));
			total += (count * price);
		}
		System.out.println(total);
	}

	public static void setTotal() {
		totalText.setBounds(560, 800, 300, 60);
		totalText.setText("�հ� : " + total + "��");
		totalText.setFont(new Font("", Font.BOLD, 20));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ȭ��1 - ����or���� ����
		if (e.getSource() == this.here || e.getSource() == this.toGo) {
			this.setContentPane(coffeeMenus);
		}
		add(showTable, 0);
		setTotal();
		add(totalText);

		// ȭ��2 - �޴�����
		if (e.getSource() == this.btnCoffee && this.getContentPane() == teaMenus) {
			System.out.println("COFFEE");
			this.setContentPane(coffeeMenus);
			this.btnTea.setBackground(Color.gray);
			this.btnCoffee.setBackground(Color.white);
		}
		if (e.getSource() == this.btnTea && this.getContentPane() == coffeeMenus) {
			System.out.println("TEA");
			this.setContentPane(teaMenus);
			this.btnCoffee.setBackground(Color.gray);
			this.btnTea.setBackground(Color.white);
		}
		setTotal();
		add(totalText);
		add(showTable, 0);
		add(this.btnCoffee);
		add(this.btnTea);
		add(this.selectFinish);

		// ���ķ� ��ư, ���̺� ȭ�鿡�� �����
		if (e.getSource() == this.selectFinish || e.getSource() == this.card || e.getSource() == this.cash) {
			remove(this.btnCoffee);
			remove(this.btnTea);
			remove(this.selectFinish);
			remove(showTable);
		}
		if (e.getSource() == this.selectFinish) {
			this.setContentPane(payment);
			setThirdPageBtn();

		}

		// ȭ��3 - ����â
		if (e.getSource() == this.card) {
			this.setContentPane(payCard);
			this.setContentPane(rec);
			setFourthPageBtn();
		} else if (e.getSource() == this.cash) {
			this.setContentPane(payCash);
		}

		// ȭ��4 - ������ ��¿��� �� ����
		if (e.getSource() == this.receiptY) {
			System.out.println("END-�̿����ּż� �����մϴ�, �������� �޾ư��ʽÿ� page");
			this.dispose();
		} else if (e.getSource() == this.receiptN) {
			System.out.println("END-�̿����ּż� �����մϴ� page");
			this.dispose();
		}
	}

}