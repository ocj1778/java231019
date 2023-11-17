package xyz.itwill.swing;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

//프레임에서 마우스 버튼을 클릭한 경우 클릭한 위치의 좌표값을 문자열로 출력하는 프로그램 작성
// => 마우스 관련 이벤트는 MouseEvent 클래스를 사용하여 표현  
public class PaintApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//마우스 버튼을 클릭한 좌표값을 저장하기 위한 필드
	// => 이벤트 처리 메소드에서 좌표값을 제공받아 필드에 저장하여 paint() 메소드에서 사용
	int x, y;
	
	public PaintApp(String title) {
		super(title);
		
		//JFrame 컨테이너에서 마우스 관련 이벤트가 발생될 경우 이벤트를 처리하기 위한 객체 등록
		// => MouseAdapter 클래스를 상속받은 익명의 클래스를 사용하여 객체 생성
		addMouseListener(new MouseAdapter() {
			//이벤트 처리 메소드의 매개변수에는 발생된 이벤트 관련 정보가 저장된 객체가 전달
			//되어 메소드에서 사용 가능
			@Override
			public void mouseClicked(MouseEvent e) {
				//MouseEvent.getX() : 마우스 버튼을 클릭한 X 좌표값을 반환하는 메소드
				x=e.getX();
				//MouseEvent.getY() : 마우스 버튼을 클릭한 Y 좌표값을 반환하는 메소드
				y=e.getY();
				
				//paint() 메소드는 직접 호출 불가능하므로 repaint() 메소드 호출
				//Window.repaint() : paint() 메소드를 수동으로 호출하기 위한 메소드
				repaint();
			}
		});
		
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
		// => repaint() 메소드에 의해 paint() 메소드가 호출될 경우 컨테이너를 다시 출력하여 초기화 처리
		super.paint(g);
		
		/*
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
		*/
		
		g.drawString("["+x+","+y+"]", x, y);
	}
}







