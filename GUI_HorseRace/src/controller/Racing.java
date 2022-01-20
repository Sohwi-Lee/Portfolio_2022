package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

import models.Horse;
import models.MyUtil;
import models.Race;

public class Racing extends MyUtil implements Runnable {
	private int ms;
	private boolean isRun;
	private JLabel timer = new JLabel();

	private Random random = new Random();
	private JButton reset = new JButton("start");
	private final int SIZE = 5;
	private Horse[] horses = new Horse[SIZE];

	private int rank;

	public Racing() {
		setLayout(null);
		setBounds(0, 0, Race.WIDTH, Race.HEIGHT);

		setTimer();
		setButton();
		setGame();
	}

	private void setGame() {
		this.timer.setText("ready");
		rank = 1;
		int x = 30;
		int y = 100;
		for (int i = 0; i < SIZE; i++) {
			this.horses[i] = new Horse(i + 1, x, y, 120, 90, String.format("images/horse%d.png", i + 1));
			y += 100;
			System.out.println();
		}
	}

	private void setButton() {
		this.reset.setBounds(40, 50, 80, 30);
		this.reset.setBackground(Color.white);
		this.reset.addActionListener(this);
		add(this.reset);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 형변환!
		if (e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			if (target == this.reset) {
				this.isRun = !this.isRun; // this.isRun ? false : true;
				this.reset.setText(this.isRun ? "reset" : "start");

				if (!this.isRun) {
					setGame();
				}
			}
		}
	}

	private void setTimer() {
		this.timer.setBounds(135, 40, 100, 50);
		add(this.timer);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw horses
		g.drawLine(30, 90, Race.WIDTH - 30, 90);
		for (int i = 0; i < SIZE; i++) {
			Horse h = this.horses[i];// 임시
			g.drawImage(h.getImage().getImage(), h.getX(), h.getY(), null);
			// track
			g.drawLine(30, h.getY() + h.getH(), Race.WIDTH - 30, h.getY() + h.getH());

			// 랭크출력
			if (h.getState() == h.GOAL) {
				g.setFont(new Font("", Font.PLAIN, 10));
				g.drawString(h.getRecord(), Race.WIDTH - 180, h.getY() + h.getH() / 2);
				g.setFont(new Font("", Font.BOLD, 20));
				g.drawString(h.getRank() + "등", Race.WIDTH - 180 - 30, h.getY() + h.getH() / 2);
			}
		}
		try {
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}
		update();
		repaint();
	}

	private void update() {
		boolean goal = false; // 동시도착 예외처리할것!
		// RUN!
		if (this.isRun) {
			for (int i = 0; i < SIZE; i++) {
				Horse h = this.horses[i];
				int jump = random.nextInt(10) * 3 + 3;
				int tempX = h.getX() + jump; // 검증

				if (h.getState() == h.RUN) {
					// stop horse
					if (tempX >= Race.WIDTH - 30 - h.getW() && !goal) { // 도착
						h.setState(h.GOAL);
						h.setRecord(String.format("%4d.%3d", this.ms / 1000, this.ms % 1000));
						h.setRank(this.rank);
						this.rank++;
						goal = !goal;
					} else if (tempX > Race.WIDTH - 30 - h.getW()) {
						i--;
						// 되돌아가는 말이 발생할 경우 ms홀딩 변수를 활용
						continue;
					}
					// run horse
					h.setX(tempX);
				}

			}
		}
	}

	@Override
	public void run() {
		while (true) {
			if (isRun) {
				this.ms++;
				this.timer.setText(String.format("%3d.%3d", this.ms / 1000, this.ms % 1000));
			}

			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
	}

}
