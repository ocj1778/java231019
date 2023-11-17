package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//[EXIT] 버튼을 누른 경우 프로그램을 종료하는 기능의 프로그램 작성
// => 익명의 내부클래스를 이용하여 이벤트 처리 객체를 생성해 이벤트 처리되도록 등록 
public class EventAnonymousHandleApp extends Frame {
	private static final long serialVersionUID = 1L;

	public EventAnonymousHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT");
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//exit.addActionListener(e -> System.exit(0));
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventAnonymousHandleApp("이벤트 처리");
	}
}
