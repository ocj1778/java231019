package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//색상 버튼을 누르면 캔버스의 배경색을 변경하는 프로그램 작성
public class EventSourceGetApp extends Frame {
	private static final long serialVersionUID = 1L;

	//이벤트 처리 클래스의 메소드에서 사용될 컴퍼넌트 또는 컨테이너를 저장하기 위한 필드 선언
	// => 이벤트 처리 클래스의 메소드에서 필드에 저장된 컴퍼넌트 또는 컨테이너 사용 가능
	Canvas canvas;
	
	public EventSourceGetApp(String title) {
		super(title);
		
		Button red=new Button("RED");
		Button green=new Button("GREEN");
		Button blue=new Button("BLUE");
		Button white=new Button("WHITE");
		
		canvas=new Canvas();
		
		Panel panel=new Panel();
		
		panel.setLayout(new GridLayout(1, 4));
		
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(white);
		
		add(panel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//컴퍼넌트에서 이벤트가 발생될 경우 이벤트를 처리하기 위한 객체 등록
		red.addActionListener(new RedButtonEventHandle());
		green.addActionListener(new GreenButtonEventHandle());
		blue.addActionListener(new BlueButtonEventHandle());
		white.addActionListener(new WhiteButtonEventHandle());
		
		setBounds(800, 200, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventSourceGetApp("이벤트 처리");
	}
	
	public class RedButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.RED);
		}
	}
	
	public class GreenButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.GREEN);
		}
	}
	
	public class BlueButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.BLUE);
		}
	}
	
	public class WhiteButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.WHITE);
		}
	}
}


















