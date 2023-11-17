package xyz.itwill.swing;

import java.awt.Image;

import javax.swing.JFrame;

public class PenguinMoveApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//프레임의 폭과 높이를 표현한 상수필드 선언
	private static final int JFRAME_WIDTH=646;
	private static final int JFRAME_HEIGHT=461;
	
	//배경이미지를 저장하기 위한 필드
	//Image 클래스 : 사진파일(JPEG 파일, GIF 파일, PNG 파일 등)의 이미지 정보를 저장하기 위한 클래스 
	private Image backImage;
	
	public PenguinMoveApp(String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setBounds(700, 200, 646, 461);
		setBounds(700, 200, JFRAME_WIDTH, JFRAME_HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PenguinMoveApp("펭귄 이동");
	}
}
