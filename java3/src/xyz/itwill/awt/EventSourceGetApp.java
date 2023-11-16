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
	Button red, green, blue, white;
	
	public EventSourceGetApp(String title) {
		super(title);
		
		red=new Button("RED");
		green=new Button("GREEN");
		blue=new Button("BLUE");
		white=new Button("WHITE");
		
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
		
		/**
		//컴퍼넌트에서 이벤트가 발생될 경우 이벤트를 처리하기 위한 객체 등록
		// => 컴퍼넌트마다 이벤트를 처리하는 클래스를 다르게 설정
		red.addActionListener(new RedButtonEventHandle());
		green.addActionListener(new GreenButtonEventHandle());
		blue.addActionListener(new BlueButtonEventHandle());
		white.addActionListener(new WhiteButtonEventHandle());
		*/
		
		//모든 Button 컴퍼넌트에서 발생되는 이벤트를 하나의 이벤트 처리 클래스로 처리되도록 설정
		// => 이벤트 처리 메소드에서는 이벤트가 발생된 컴퍼넌트를 비교하여 필요한 명령이 선택 실행
		red.addActionListener(new ColorButtonEventHandle());
		green.addActionListener(new ColorButtonEventHandle());
		blue.addActionListener(new ColorButtonEventHandle());
		white.addActionListener(new ColorButtonEventHandle());
		
		setBounds(800, 200, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventSourceGetApp("이벤트 처리");
	}
	
	/*
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
	*/
	
	public class ColorButtonEventHandle implements ActionListener {
		//이벤트 처리 메소드의 매개변수에는 컴퍼넌트에서 발생된 이벤트 정보가 저장된 
		//Event 객체가 전달되어 저장 - 이벤트 처리 메소드에서 발생된 이벤트 정보 사용
		@Override
		public void actionPerformed(ActionEvent e) {
			//Event.getSource() : 이벤트가 발생된 컴퍼넌트(컨테이너)를 반환하는 메소드
			// => 이벤트가 발생된 컴퍼넌트(컨테이너)가 Object 객체로 반환되므로 명시적 객체
			//형변환 사용해야 자식클래스의 메소드의 메소드 호출 가능
			Object eventSource=e.getSource();
			
			//이벤트가 발생된 컴퍼넌트(컨테이너)의 메모리 주소를 비교하여 명령 선택 실행
			if(eventSource == red) {
				canvas.setBackground(Color.RED);
			} else if(eventSource == green) {
				canvas.setBackground(Color.GREEN);
			} else if(eventSource == blue) {
				canvas.setBackground(Color.BLUE);
			} else if(eventSource == white) {
				canvas.setBackground(Color.WHITE);
			}
		}
	}
}
