package xyz.itwill.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//프레임의 [닫기] 버튼을 누른 경우 프로그램을 종료하는 기능의 프로그램 작성
// => 프레임에서는 발생되는 WindowEvent를 WindowAdapter 클래스를 상속받은 자식클래스로 처리
public class WindowAdapterApp extends Frame {
	private static final long serialVersionUID = 1L;
 
	public WindowAdapterApp(String title) {
		super(title);
		
		//addWindowListener(new WindowEventHandleTwo());
		
		//Adapter 클래스(추상클래스)를 상속받은 익명의 내부클래스로 객체를 생성하여 이벤트 
		//처리를 위한 객체로 등록 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowListenerApp("윈도우 이벤트");
	}
	
	/*
	//Adapter 클래스 : Listener 인터페이스에 추상메소드가 2개 이상 선언된 경우 Listener
	//인터페이스 대신 이벤트 처리를 위해 제공되는 클래스
	// => Adapter 클래스를 상속받은 자식클래스는 필요한 이벤트 처리 메소드만 오버라이드 선언
	//하여 이벤트 처리 가능
	public class WindowEventHandleTwo extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	*/
}
