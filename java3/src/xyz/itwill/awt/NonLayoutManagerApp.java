package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

//배치관리자(LayoutManager) : 컨테이너에 컴퍼넌트를 자동으로 배치하기 위한 기능을 제공하는 객체
// => BorderLayout 클래스, FlowLayout 클래스, GridLayout 클래스, CardLayout 클래스 등

//컨테이너에는 컴퍼넌트를 자동 배치하기 위한 배치관리자가 기본적으로 설정
// => Frame 클래스, Window 클래스, Dialog 클래스 등 - BorderLayout
// => Panel 클래스, Applet 클래스 등 - FlowLayout

//배치관리자를 사용하지 않고 프레임에 컴퍼넌트를 배치하여 사용하는 프로그램 작성
public class NonLayoutManagerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public NonLayoutManagerApp(String title) {
		super(title);
		
		//Container.setLayout(LayoutManager mrg) : 매개변수로 전달받은 LayoutManager 객체로
		//컨테이너의 배치관리자를 변경하는 메소드
		// => 매개변수에 [null]를 전달할 경우 배치관리자를 사용하지 않도록 설정
		setLayout(null);
		
		Button button1=new Button("Button-1");
		Button button2=new Button("Button-2");
		
		//배치관리자가 없는 컨테이너에 컴퍼넌트를 배치하기 위해서는 반드시 컴퍼넌트의 배치
		//위치와 크기를 변경한 후 컴퍼넌트를 컨테이너에 배치
		button1.setBounds(80, 100, 150, 80);
		button2.setBounds(190, 300, 100, 120);
		
		add(button1);	
		add(button2);	
		
		setBounds(600, 100, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NonLayoutManagerApp("배치관리자 미사용 프레임");
	} 
	
}

