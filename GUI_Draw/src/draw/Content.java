package draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

public class Content extends Util {

	// 목표1 : 사각형 여럿 그리기
	// 목표2 : 심화 - 삼각형도 그리기

	public JButton close = new JButton("close");
	// 그려지는 객체
	ArrayList<Nemo> nemos = new ArrayList<Nemo>();
	ArrayList<Nemo> semos = new ArrayList<Nemo>();
	ArrayList<Nemo> circles = new ArrayList<Nemo>();

	private Nemo nemo = null;
	private int x, y, startX, startY;

	private int type; // 0 1 2 동그라미, 세모, 네모
	private final int RECTANGLE = 0;
	private final int TRIANGLE = 1;
	private final int CIRCLE = 2;

	private JButton[] choice = new JButton[3];

	public Content() {
		setLayout(null);
		setBounds(0, 0, 900, 700);

		addMouseListener(this);
		addMouseMotionListener(this);

		setFocusable(true);
		addKeyListener(this);

		setButton();
	}

	private void setButton() {
		// btn close
		this.close.setBounds(750, 550, 100, 50);
		this.close.setBackground(Color.white);
		add(this.close);

		// btns
		int x = 30;
		int y = 50;
		String[] text = { "□", "△", "○" };
		for (int i = 0; i < choice.length; i++) {
			JButton bt = new JButton();
			bt.setBounds(x, y, 50, 50);
			bt.setBackground(Color.white);
			bt.setText(text[i]);
			bt.addActionListener(this);
			add(bt);
			x += y + 3;
			this.choice[i] = bt;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) { // JButton형변환이 가능ㅇ하면
			JButton target = (JButton) e.getSource();
			if (target == this.choice[0]) {
				this.type = RECTANGLE;
			} else if (target == this.choice[1]) {
				this.type = TRIANGLE;
			} else if (target == this.choice[2]) {
				this.type = CIRCLE;
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
		this.startX = x; // 프레스 시점의 좌표를 고정으로 기억!
		this.startY = y;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.x = this.startX; // 포인트 튀는 것 방지
		this.y = this.startY;

		int xx = e.getX(); // 드래그 지점 포인트
		int yy = e.getY();
		// 네모설정
		int width = this.type == TRIANGLE ? xx - x : Math.abs(xx - x);
		int height = this.type == TRIANGLE ? yy - y : Math.abs(yy - y);

		// 예외처리
		if (this.x > xx && width > 1) {
			x = startX - width; // 시작점-width값만큼!
		}
		if (this.y > yy && height > 1) {
			y = startY - height;
		}

		this.nemo = new Nemo(x, y, width, height, Color.blue);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println(this.type);
		if (this.type == RECTANGLE) {
			this.nemos.add(this.nemo);
		} else if (this.type == TRIANGLE) {
			this.semos.add(this.nemo);
		} else if (this.type == CIRCLE) {
			this.circles.add(this.nemo);
		}

		this.nemo = null;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 삼각형 그리기
		// drawPolygon(int[],int[],int);
		// (x좌표 배열, y좌표 배열, 꼭지점 개수)
//		int[] xxx = { 100, 50, 150 };
//		int[] yyy = { 100, 200, 200 };
//		g.set	Color(Color.green);
//		g.drawPolygon(xxx, yyy, 3);

		// 임시객체 nemo를 픽스

		// 네모그리기 스레드
		if (this.nemo != null) {
			g.setColor(this.nemo.getC());
			if (this.type == RECTANGLE) {
				g.drawRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight());
			} else if (this.type == TRIANGLE) {
				int xx[] = new int[3];
				int yy[] = new int[3];
				xx[0] = this.nemo.getX();
				yy[0] = this.nemo.getY();
				xx[1] = this.nemo.getX() - (this.nemo.getWidth() / 2);
				yy[1] = this.nemo.getY() + this.nemo.getHeight();
				xx[2] = this.nemo.getX() + (this.nemo.getWidth() / 2);
				yy[2] = this.nemo.getY() + this.nemo.getHeight();
				g.drawPolygon(xx, yy, 3);
			} else if (this.type == CIRCLE) {
				g.drawRoundRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight(),
						this.nemo.getWidth(), this.nemo.getHeight());
			}
		}

		// 네모 객체배열 전체 그리기 / fix
		for (Nemo n : this.nemos) {
			g.setColor(n.getC());
			g.drawRect(n.getX(), n.getY(), n.getWidth(), n.getHeight());
		}
		for (Nemo n : this.semos) {
			g.setColor(n.getC());
			int xx[] = new int[3];
			int yy[] = new int[3];
			xx[0] = n.getX();
			yy[0] = n.getY();
			xx[1] = n.getX() - (n.getWidth() / 2);
			yy[1] = n.getY() + n.getHeight();
			xx[2] = n.getX() + (n.getWidth() / 2);
			yy[2] = n.getY() + n.getHeight();
			g.drawPolygon(xx, yy, 3);
		}
		for (Nemo n : this.circles) {
			g.setColor(n.getC());
			g.drawRoundRect(n.getX(), n.getY(), n.getWidth(), n.getHeight(), n.getWidth(), n.getHeight());
		}
		requestFocusInWindow();
		repaint();
	}
}
