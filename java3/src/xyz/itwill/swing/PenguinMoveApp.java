package xyz.itwill.swing;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
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
		
		//ImageIcon 클래스 : 사진파일에 대한 정보를 저장하기 위한 클래스
		// => ImageIcon 클래스의 ImageIcon(URL location) 생성자의 매개변수에 사진파일의 
		//URL 주소를 전달받아 ImageIcon 객체 생성
		//URL : 리소스 파일(사진 파일, 소리 파일, 동영상 파일 등)의 파일 경로 또는 인터넷 경로를
		//저장하기 위한 클래스
		//Object.getClass() : 현재 실행중인 클래스의 Class 객체(메모리에 저장된 클래스)를 반환하는 메소드
		//Class.getResource(String name) : 현재 실행중인 클래스의 파일경로를 기준으로 리소스
		//파일을 읽어 리소스 파일의 경로가 저장된 URL 객체를 반환하는 메소드
		//ImageIcon.getImage() : ImageIcon 객체에 저장된 사진파일에서 이미지가 저장된 Image 
		//객체를 반환하는 메소드
		backImage=new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();
		
		setResizable(false);//프레임의 크기를 변경하지 않도록 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setBounds(700, 200, 646, 461);
		setBounds(700, 200, JFRAME_WIDTH, JFRAME_HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PenguinMoveApp("펭귄 이동");
	}
	
	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		
		//Graphics.drawImage(Image image, int x, int y, int width, int height, ImageObserver observer)
		// => 이미지를 출력하는 메소드
		g.drawImage(backImage, 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT, this);
	}
}






