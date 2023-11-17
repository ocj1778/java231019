package xyz.itwill.swing;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PaintApp extends JFrame {
	private static final long serialVersionUID = 1L;

	public PaintApp(String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(800, 200, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PaintApp("Paint");
	}
	
	//JWindow.paint(Graphics g) : 컨테이너(JFrame, JWindow, JDialog 등)를 출력하는 메소드
	// => GUI 프로그램이 실행되어 컨테이너가 보여질 경우 또는 GUI 프로그램이 아이콘에서 해제되어 
	//컨테이너가 보여질 경우, 컨테이너의 크기가 변경될 경우 자동 호출되는 메소드
	// => Graphics 객체 : 컨테이너와 종속된 컴퍼넌트를 그리기 위한 기능을 제공하는 객체
	//JWindow 클래스(JFrame 클래스의 부모클래스)의 paint() 메소드를 오버라이드 선언
	@Override
	public void paint(Graphics g) {
		//System.out.println("paint(Graphics g) 메소드 호출");
		
		//super 키워드로 부모클래스의 숨겨진 메소드 호출 - 컨테이너 출력
		super.paint(g);
		
		//Graphics 객체의 메소드를 호출하여 다양한 형태의 그림 출력 가능
		g.setColor(Color.RED);//Graphics 객체의 색을 변경하는 메소드
		g.drawRect(20, 40, 50, 50);//사각형(선)을 그리는 메소드
		g.fillRect(20, 100, 100, 50);//사각형(면)을 그리는 메소드
		
		g.setColor(Color.GREEN);
		g.drawOval(125,175,50,50);//타원(선)을 그리는 메소드
		g.fillOval(100,250,100,50);//타원(면)을 그리는 메소드
		
		g.setColor(Color.BLUE);
		g.drawLine(100, 320, 200, 320);//선을 그리는 메소드
		g.drawString("홍길동", 100, 350);//문자열을 그리는 메소드
	}
}







