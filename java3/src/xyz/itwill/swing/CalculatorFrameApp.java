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

//사칙 연산식을 입력받아 연산 결과를 출력하는 프로그램 작성
public class CalculatorFrameApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	//연산식을 입력받기 위한 컴퍼넌트를 저장한 필드
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bEquals, bPlus,
			bMinus, bMulti, bDiv, bClear;

	//연산 결과값을 출력하기 위한 컴퍼넌트를 저장한 필드
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
		
		p.add(bMulti);
		p.add(bDiv);
		p.add(bPlus);
		p.add(bMinus);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(b0);
		p.add(bEquals);
		p.add(bClear);
		
		Container container=getContentPane();
		container.setLayout(new BorderLayout(10, 10));
		container.setBackground(Color.BLACK);

		container.add(label, BorderLayout.NORTH);
		container.add(p, BorderLayout.CENTER);
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bDiv.addActionListener(this);
		bPlus.addActionListener(this);
		bMinus.addActionListener(this);
		bMulti.addActionListener(this);
		bClear.addActionListener(this);
		bEquals.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setBounds(500, 100, 400, 400);
		setVisible(true);
	}

	private void initButtons() {
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bEquals = new JButton("=");
		bPlus = new JButton("+");
		bMinus = new JButton("-");
		bMulti = new JButton("*");
		bDiv = new JButton("/");
		bClear = new JButton("C");

		b0.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b1.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b2.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b3.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b4.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b5.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b6.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b7.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b8.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b9.setFont(new Font("DIALOG", Font.PLAIN, 20));
		bDiv.setFont(new Font("DIALOG", Font.PLAIN, 20));
		bPlus.setFont(new Font("DIALOG", Font.PLAIN, 20));
		bMinus.setFont(new Font("DIALOG", Font.PLAIN, 20));
		bMulti.setFont(new Font("DIALOG", Font.PLAIN, 20));
		bClear.setFont(new Font("DIALOG", Font.PLAIN, 20));
		bEquals.setFont(new Font("DIALOG", Font.PLAIN, 20));
		
		b0.setBackground(Color.WHITE);
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		bDiv.setBackground(Color.YELLOW);
		bPlus.setBackground(Color.YELLOW);
		bMinus.setBackground(Color.YELLOW);
		bMulti.setBackground(Color.YELLOW);
		bClear.setBackground(Color.GREEN);
		bEquals.setBackground(Color.CYAN);
	}

	public static void main(String[] args) {
		new CalculatorFrameApp("계산기");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton eventSource=(JButton)e.getSource();
		
		if(eventSource == bClear) {
			
		} else if(eventSource == bEquals) {
			
		} else {
			operation+=eventSource.getText();
			
			label.setText(operation);
		}
	}
}