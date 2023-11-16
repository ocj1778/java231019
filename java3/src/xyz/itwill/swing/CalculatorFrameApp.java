package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//사칙 연산식을 입력받아 연산 결과를 출력하는 프로그램
public class CalculatorFrameApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	//연산식을 입력하기 위한 필드(컴퍼넌트)
	private JButton b_0, b_1, b_2, b_3, b_4, b_5, b_6, b_7, b_8, b_9, b_equals, b_plus,
			b_minus, b_multi, b_div, b_C;

	//연산 결과를 출력하기 위한 필드(컴퍼넌트)
	private JLabel label;

	//연산식을 저장하기 위한 필드
	private String operation="";
	
	public CalculatorFrameApp(String title) {
		super(title);
		initButtons();
		init();
	}

	private void init() {
		label = new JLabel("0");
		label.setFont(new Font("DIALOG", Font.BOLD, 30));
		label.setHorizontalAlignment(JLabel.RIGHT);
		label.setBackground(Color.LIGHT_GRAY);
		label.setForeground(Color.WHITE);

		JPanel p = new JPanel(new GridLayout(4, 4, 5, 5));
		p.setBackground(Color.BLACK);
		
		p.add(b_multi);
		p.add(b_div);
		p.add(b_plus);
		p.add(b_minus);
		p.add(b_1);
		p.add(b_2);
		p.add(b_3);
		p.add(b_4);
		p.add(b_5);
		p.add(b_6);
		p.add(b_7);
		p.add(b_8);
		p.add(b_9);
		p.add(b_0);
		p.add(b_equals);
		p.add(b_C);
		
		Container container=getContentPane();
		container.setLayout(new BorderLayout(10, 10));
		container.setBackground(Color.BLACK);
		container.add(label, BorderLayout.NORTH);
		container.add(p, BorderLayout.CENTER);
		
		b_0.addActionListener(this);
		b_1.addActionListener(this);
		b_2.addActionListener(this);
		b_3.addActionListener(this);
		b_4.addActionListener(this);
		b_5.addActionListener(this);
		b_6.addActionListener(this);
		b_7.addActionListener(this);
		b_8.addActionListener(this);
		b_9.addActionListener(this);
		b_div.addActionListener(this);
		b_plus.addActionListener(this);
		b_minus.addActionListener(this);
		b_multi.addActionListener(this);
		b_C.addActionListener(this);
		b_equals.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setBounds(500, 100, 400, 400);
		setVisible(true);
	}

	private void initButtons() {
		b_0 = new JButton("0");
		b_1 = new JButton("1");
		b_2 = new JButton("2");
		b_3 = new JButton("3");
		b_4 = new JButton("4");
		b_5 = new JButton("5");
		b_6 = new JButton("6");
		b_7 = new JButton("7");
		b_8 = new JButton("8");
		b_9 = new JButton("9");
		b_equals = new JButton("=");
		b_plus = new JButton("+");
		b_minus = new JButton("-");
		b_multi = new JButton("*");
		b_div = new JButton("/");
		b_C = new JButton("C");

		b_0.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_1.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_2.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_3.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_4.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_5.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_6.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_7.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_8.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_9.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_div.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_plus.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_minus.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_multi.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_C.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_equals.setFont(new Font("DIALOG", Font.PLAIN, 20));
		
		b_0.setBackground(Color.WHITE);
		b_1.setBackground(Color.WHITE);
		b_2.setBackground(Color.WHITE);
		b_3.setBackground(Color.WHITE);
		b_4.setBackground(Color.WHITE);
		b_5.setBackground(Color.WHITE);
		b_6.setBackground(Color.WHITE);
		b_7.setBackground(Color.WHITE);
		b_8.setBackground(Color.WHITE);
		b_9.setBackground(Color.WHITE);
		b_div.setBackground(Color.YELLOW);
		b_plus.setBackground(Color.YELLOW);
		b_minus.setBackground(Color.YELLOW);
		b_multi.setBackground(Color.YELLOW);
		b_C.setBackground(Color.GREEN);
		b_equals.setBackground(Color.CYAN);
	}

	public static void main(String[] args) {
		new CalculatorFrameApp("계산기");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton eventSource=(JButton)e.getSource();
		
		if(eventSource == b_C) {
			
		} else if(eventSource == b_equals) {
			
		} else {
			operation+=eventSource.getText();
			
			label.setText(operation);
		}
	}
}