package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//플렛폼의 현재 날짜와 시간을 1초마다 제공받아 출력하는 GUI 프로그램 작성
// => 새로운 스레드를 생성하여 플렛폼의 현재 날짜와 시간을 1초마다 제공받아 컴퍼넌트 변경 처리
public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;

	JLabel clockLable;
	JButton startButton, stopButton;
	
	//플렛폼의 현재 날짜와 시간 정보를 제공받아 출력하는 스레드의 실행상태를 저장하기 위한 필그
	// => false : 스레드 일시중지 상태, true : 스레드 실행 상태
	private boolean isRun;
	
	public DigitalClockApp(String title) {
		super(title);
		
		isRun=true;
		
		/*
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String printDate=dateFormat.format(now);
		*/
		
		//JLabel clockLable=new JLabel("2023년 11월 17일 13시 03분 20초", JLabel.CENTER);
		//JLabel clockLable=new JLabel(printDate, JLabel.CENTER);
		clockLable=new JLabel("", JLabel.CENTER);
		clockLable.setFont(new Font("굴림체", Font.BOLD, 30));
		
		startButton=new JButton("다시 실행");
		stopButton=new JButton("일시 중지");
		startButton.setFont(new Font("굴림체", Font.BOLD, 20));
		stopButton.setFont(new Font("굴림체", Font.BOLD, 20));
		
		startButton.setEnabled(false);
		
		JPanel panel=new JPanel();
		panel.add(startButton);
		panel.add(stopButton);
		
		//스레드 클래스로 객체를 생성하여 start() 메소드를 호출해 새로운 스레드를 만들어
		//run() 메소드의 명령 실행
		//new ClockThread().start();
		
		/*
		//익명의 내부클래스를 사용하여 Runnable 객체를 생성하여 매개변수로 제공받아 Thread 
		//객체를 생성하여 start() 메소드를 호출
		new Thread(new Runnable() {
			@Override
			public void run() {
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

				while(true) {
					Date now=new Date();
					String printDate=dateFormat.format(now);
					clockLable.setText(printDate);//JLabel 컴퍼넌트의 문자열 변경
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		*/
	
		//람다표현식을 사용하여 Runnable 객체 생성
		new Thread(() -> {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

			while(true) {
				//isRun 필드값이 [true]인 경우에만 플렛폼의 현재 날짜와 시간 정보를 제공받아
				//컴퍼넌트의 문자열 변경 처리
				if(isRun) {
					clockLable.setText(dateFormat.format(new Date()));
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		//JVM(Java Virtual Machine)은 이벤트를 처리하기 위해 Event-Queue 스레드를 자동 생성
		startButton.addActionListener(new ClockButtonEventHandle());
		stopButton.addActionListener(new ClockButtonEventHandle());
		
		getContentPane().add(clockLable, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 600, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DigitalClockApp("디지털 시계");
	}

	/*
	//플렛폼의 현재 날짜와 시간을 1초마다 제공받아 컴퍼넌트를 변경 처리하는 스레드 클래스
	public class ClockThread extends Thread {
		@Override
		public void run() {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

			while(true) {
				Date now=new Date();
				String printDate=dateFormat.format(now);
				clockLable.setText(printDate);//JLabel 컴퍼넌트의 문자열 변경
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	*/

	//JButton 컴퍼넌트를 누른 경우 이벤트 처리를 위해 작성한 클래스
	// => 버튼을 누른 경우 플렛폼의 현재 날짜와 시간 정보를 제공받아 출력하는 스레드를 일시 
	//중지하거나 재실행되도록 설정
	public class ClockButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource == startButton) {
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				
				isRun=true;
			} else if(eventSource == stopButton){
				startButton.setEnabled(true);
				stopButton.setEnabled(false);

				isRun=false;
			}
		}
	}
}
