package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//[EXIT] 버튼을 누른 경우 프로그램을 종료하는 기능의 프로그램 작성
// => UI 클래스와 이벤트 처리 클래스를 하나의 클래스로 작성 가능
// => UI 클래스와 이벤트 처리 클래스가 하나의 클래스로 작성되어 있으므로 유지보수의 효율성이
//낮아 간단한 GUI 프로그램을 작성할 경우에만 사용
public class EventSourceHandleApp extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public EventSourceHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT");
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);

		exit.addActionListener(this);
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventSourceHandleApp("이벤트 처리");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}


