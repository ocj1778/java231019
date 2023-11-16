package xyz.itwill.awt;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//프레임의 [닫기] 버튼을 누른 경우 프로그램을 종료하는 기능의 프로그램 작성
// => 프레임에서는 발생되는 WindowEvent를 WindowListener 인터페이스를 상속받은 자식클래스로 처리
public class WindowListenerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowListenerApp(String title) {
		super(title);
		
		//프레임에서 WindowEvent가 밝생될 경우 이벤트 처리를 위한 객체 등록
		addWindowListener(new WindowEventHandleOne());
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowListenerApp("윈도우 이벤트");
	}
	
	//Listener 인터페이스를 상속받은 자식클래스(이벤트 처리 클래스)는 무조건 인터페이스의 모든
	//추상메소드를 오버라이드 선언
	// => Listener 인터페이스를 상속받으면 불필요한 이벤트 처리 메소드도 오버라이드 선언
	public class WindowEventHandleOne implements WindowListener {
		@Override
		public void windowOpened(WindowEvent e) {
			//System.out.println("windowOpened() 메소드 호출");
		}

		//프레임의 [닫기] 버튼을 누른 경우 자동 호출되는 이벤트 처리 메소드
		@Override
		public void windowClosing(WindowEvent e) {
			//System.out.println("windowClosing() 메소드 호출");
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			//System.out.println("windowClosed() 메소드 호출");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			//System.out.println("windowIconified() 메소드 호출");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			//System.out.println("windowDeiconified() 메소드 호출");
		}

		@Override
		public void windowActivated(WindowEvent e) {
			//System.out.println("windowActivated() 메소드 호출");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			//System.out.println("windowDeactivated() 메소드 호출");
		}
	}
}








