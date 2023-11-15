package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

//플레임에 버튼을 배치하여 출력하는 프로그램 작성
public class ComponentAddApp extends Frame {
	private static final long serialVersionUID = 1L;

	public ComponentAddApp(String title) {
		super(title);
		
		//Button 클래스 : 버튼 컴퍼넌트를 구현하기 위한 클래스
		//new 연산자로 Button 클래스의 Button(String label) 생성자를 호출하여 객체 생성
		// => 매개변수로 전달받은 문자열을 라벨로 사용하는 버튼 생성 
		Button button=new Button("Button");
		
		//Container.add(Component c) : 매개변수로 전달받은 컴퍼넌트를 컨테이너에 배치하는 메소드
		// => 컨테이너에 설정된 배치관리자(LayoutManager 객체)에 의해 컴퍼넌트의 배치 위치와 크기가
		//자동 설정되어 자동으로 배치 처리
		add(button);
		
		setBounds(600, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComponentAddApp("컴퍼넌트 배치");
	}
}
