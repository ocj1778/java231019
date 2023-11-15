package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

//GridLayout 클래스 : 컨테이너를 행과 열로 구분하여 컴퍼넌트를 배치하는 배치관리자
public class GridLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;

	public GridLayoutApp(String title) {
		super(title);
		
		//프레임의 배치관리자를 [GridLayout]으로 변경
		// => GridLayout 클래스의 매개변수가 작성된 생성자를 호출하여 행열을 초기값으로 설정
		setLayout(new GridLayout(3, 2, 5, 5));
		
		Button button1=new Button("BUTTON-1");
		Button button2=new Button("BUTTON-2");
		Button button3=new Button("BUTTON-3");
		Button button4=new Button("BUTTON-4");
		Button button5=new Button("BUTTON-5");
		Button button6=new Button("BUTTON-6");
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		
		setBounds(600, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutApp("GridLayout");
	}
}
