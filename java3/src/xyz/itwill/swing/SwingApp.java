package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//GUI 프로그램의 UI 클래스는 java.awt 패키지의 컴퍼넌트를 이용하여 작성하는 것보다 javax.swing 
//패키지의 컴퍼넌트를 사용하여 작성하는 것을 권장
// => javax.swing 패키지의 컴퍼넌트는 Java 프로그램에서 제공하는 컴퍼넌트 - 플렛폼에 독립적으로 실행

//javax.swing 패키지의 컴퍼넌트(컨테이너)로 UI 클래스를 작성하는 방법 - AWT 프로그램과의 차이점
//1.java.awt 패키지의 컴퍼넌트(컨테이너)를 구현한 클래스 이름 앞에 [J]를 붙여 javax.swing
//패키지의 컴퍼넌트(컨테이너)로 구현
//2.프레임(JFrame 객체)의 [닫기] 버튼을 누른 경우 프레임이 보여지지 않는 기능 제공
// => JFrame.setDefaultCloseOperation(int operation) 메소드를 호출하여 프레임의 [닫기] 버튼을
//누른 경우 동작되는 기능을 변경 가능
//3.프레임을 직접 변경하지 않고 프레임의 Container 객체를 반환받아 변경 처리
// => JFrame.getContentPane() : 프레임의 Container 객체를 반환하는 메소드
// => 프레임의 배치관리자 변경, 프레임의 배경색 변경, 프레임의 컴퍼넌트 배치  등

//JTextField 컴퍼넌트에서 메세지를 입력한 후 엔터를 누르면 JTextArea 컴퍼넌트에 메세지를
//추가하여 출력되도록 프로그램 작성
// => JTextField 컴퍼넌트에서 문자열을 입력 후 엔터를 누르면 ActionEvent 발생
public class SwingApp extends JFrame {
	private static final long serialVersionUID = 1L;

	JTextArea textArea;
	JTextField textField;
	
	public SwingApp(String title) {
		super(title);

		textArea=new JTextArea("[홍길동]님이 입장 하였습니다.\n");
		textField=new JTextField();
		
		//Swing 컴퍼넌트에서는 플렛폼에서 제공하는 모든 글꼴 사용 가능
		textArea.setFont(new Font("굴림체", Font.BOLD, 20));
		textField.setFont(new Font("굴림체", Font.BOLD, 20));
		
		textArea.setBackground(Color.PINK);
		
		//JTextArea 컴퍼넌트에 입력 포커스가 제공되지 않도록 설정
		// => JTextArea 컴퍼넌트를 출력 전용 컴퍼넌트로 사용
		textArea.setFocusable(false);
		
		Container container=getContentPane();
		
		//JTextArea 컴퍼넌트는 폭과 높이를 벗어난 문자열 출력 불가능 - 스크롤 미발생
		// => JScrollPane 컨테이너에 JTextArea 컴퍼넌트를 배치하여 사용하면 스크롤 발생
		//container.add(textArea, BorderLayout.CENTER);
		
		//JScrollPane 클래스 : 컴퍼넌트에 스크롤을 제공하기 위한 컨테이너 클래스
		// => JScrollPane 클래스의 JScrollPane(Component view) 생성자로 객체 생성
		// => JScrollPane 생성자의 매개변수에는 스크롤을 제공하고 싶은 컴퍼넌트 전달
		JScrollPane scrollPane=new JScrollPane(textArea);
		
		container.add(scrollPane, BorderLayout.CENTER);
		container.add(textField, BorderLayout.SOUTH);
		
		//setDefaultCloseOperation(int operation) 메소드의 매개변수에는 WindowConstants 클래스의 상수 전달
		// => DO_NOTHING_ON_CLOSE : 아무런 동작도 실행되지 않도록 설정하는 상수
		// => HIDE_ON_CLOSE : 프레임이 보여지지 않도록 설정하는 상수 - 기본값
		// => DISPOSE_ON_CLOSE : 메모리를 정리한 후 프로그램을 종료되도록 설정하는 상수
		// => EXIT_ON_CLOSE : 프로그램이 무조건 종료되도록 설정하는 상수
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		textField.addActionListener(new TextComponentEventHandle());
		
		setBounds(800, 200, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingApp("Swing");
	}
	
	public class TextComponentEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//TextComponent.getText() : JTextField 컴퍼넌트 또는 JTextArea 컴퍼넌트에 입력된
			//문자열을 얻어와 반환하는 메소드
			String text=textField.getText();
			
			if(!text.equals("")) {//JTextField 컴퍼넌트에 입력된 문자열이 있는 경우
				//JTextArea.append(String text) : JTextArea 컴퍼넌트에 문자열을 추가하여 출력하는 메소드
				textArea.append("[홍길동]"+text+"\n");
				
				//JTextArea 컴퍼넌트의 스크롤을 JTextArea 컴퍼넌트의 끝지점으로 이동되도록 처리
				//JTextArea.setCaretPosition(int position) : JTextArea 컴퍼넌트의 출력 위치를 이동하는 메소드
				textArea.setCaretPosition(textArea.getText().length());
				
				//TextComponent.setText(String text) : JTextField 컴퍼넌트 또는 JTextArea 컴퍼넌트의 
				//문자열을 변경하는 메소드
				textField.setText("");				
			}
		}
	}
}
