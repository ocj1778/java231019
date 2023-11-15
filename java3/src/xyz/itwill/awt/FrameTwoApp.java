package xyz.itwill.awt;

import java.awt.Frame;

//GUI 프로그램에서 UI 구성 및 이벤트 처리를 위해서는 Frame 클래스를 상속받아 작성하는 것을 권장
public class FrameTwoApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	//생성자 내부에서 프레임을 구성하는 디자인 설정 - UI 구현
	public FrameTwoApp(String title) {
		//super 키워드로 부모클래스(Frame 클래스)의 생성자를 호출해 생성자 매개변수로 전달받은 
		//문자열(제목)을 Frame 객체에 저장하여 프레임 제목으로 사용 
		super(title);
		
		//Frame.setTitle(String title) : 프레임의 제목을 변경하는 메소드
		//setTitle("변경된 프레임 제목");
		
		//Component.setBounds(int x, int y, int width, int height) : 컴퍼넌트의 출력위치와
		//크기를 변경하는 메소드
		setBounds(600, 100, 500, 400);//Frame 객체를 참조하여 메소드 호출
		
		//Frame.setResizable(boolean resize) : 프레임의 크기 변경 가능 유무를 설정하기 위한 메소드
		// => false : 프레임 크기 변경 불가능, true : 프레임 크기 변경 가능 - 기본
		//setResizable(false);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//Frame 클래스를 상속받은 자식클래스의 생성자로 객체 생성 - Frame 객체 생성
		new FrameTwoApp("프레임 연습");
	}
}
