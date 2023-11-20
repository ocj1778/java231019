package xyz.itwill.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

//키보드의 방향키를 누르면 펭귄 이미지가 움직이는 프로그램 작성
public class PenguinMoveApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//프레임의 폭과 높이를 표현한 상수필드 선언
	// => 배경 이미지의 폭과 높이로 사용되도록 상수필드로 선언  
	private static final int JFRAME_WIDTH=646;
	private static final int JFRAME_HEIGHT=461;
	
	//펭귄 이미지의 폭과 높이를 표현한 상수필드 선언
	private static final int PENGUIN_SIZE=60;
	
	//배경 이미지를 저장하기 위한 필드
	//Image 클래스 : 그림파일(JPEG 파일, GIF 파일, PNG 파일 등)의 이미지 정보를 저장하기 위한 클래스 
	private Image backImage;
	
	//펭권 이미지를 저장하기 위한 필드 - 배열
	private Image[] penguins;
	
	//펭귄 이미지를 선택하기 위한 필드 - 배열의 요소값으로 사용
	private int penguinNo;
	
	//펭귄 이미지가 출력될 좌표값을 저장하기 위한 필드
	private int penguinX, penguinY; 
	
	public PenguinMoveApp(String title) {
		super(title);
		
		//ImageIcon 클래스 : 그림파일에 대한 정보를 저장하기 위한 클래스
		// => ImageIcon(URL location) 생성자의 매개변수에 그림파일의 경로가 저장된 URL 객체를 
		//전달받아 ImageIcon 객체 생성
		//URL 클래스 : 리소스 파일(그림파일, 소리파일, 동영상파일 등)의 파일 시스템 경로 또는
		//인터넷 경로를 저장하기 위한 클래스
		//Object.getClass() : 현재 실행중인 클래스의 Class 객체(메모리에 저장된 클래스 - Clazz)를 반환하는 메소드
		//Class.getResource(String name) : 현재 실행중인 클래스의 파일경로를 기준으로 리소스
		//파일을 읽어 리소스 파일의 경로가 저장된 URL 객체를 반환하는 메소드
		//ImageIcon.getImage() : ImageIcon 객체에 저장된 그림파일에서 이미지가 저장된 Image 
		//객체를 반환하는 메소드
		backImage=new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();

		//필드에 Image 객체 배열을 생성하여 저장
		penguins=new Image[3];
		
		//펭귄 이미지를 읽어 Image 객체 배열 요소에 저장
		for(int i=0;i<penguins.length;i++) {
			penguins[i]=new ImageIcon(getClass().getResource("/images/penguin"+(i+1)+".gif")).getImage();
		}
			
		//penguinNo=0;
		
		//펭귄 이미지가 출력될 좌표값을 필드에 저장 - 프레임 하단의 가운데 출력되도록 설정
		penguinX=JFRAME_WIDTH / 2 - PENGUIN_SIZE / 2;
		penguinY=JFRAME_HEIGHT - PENGUIN_SIZE;
		
		//프레임에서 키보드 관련 이벤트가 발생될 경우 이벤트를 처리하기 위한 객체 등록
		addKeyListener(new PenguinMoveHandle());
		
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
		//setResizable() 메소드에 의해 프레임의 크기를 변경하지 못하도록 설정해서 컨테이너를
		//초기화 처리하는 메소드 호출 생략 가능
		//super.paint(g);
		
		//Graphics.drawImage(Image image, int x, int y, int width, int height, ImageObserver observer)
		// => 컴퍼넌트(ImageObserver 객체)에 이미지를 출력하는 메소드
		g.drawImage(backImage, 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT, this);
		
		g.drawImage(penguins[penguinNo], penguinX, penguinY, PENGUIN_SIZE, PENGUIN_SIZE, this);
	}
	
	//키보드 관련 이벤트를 처리하기 위한 이벤트 처리 클래스
	// => KeyListener 인터페이스 대신 KeyAdapter 클래스를 상속받아 작성
	public class PenguinMoveHandle extends KeyAdapter {
		//키보드를 누르고 있는 상태에서 자동 호출되는 이벤트 처리 메소드
		@Override
		public void keyPressed(KeyEvent e) {
			//KeyEvent.getKeyCode() : 이벤트를 발생한 키보드의 고유값을 반환하는 메소드
			// => KeyEvent.getKeyChar() : 이벤트를 발생한 키보드의 문자값(코드값)을 반환하는 메소드
			int keyCode=e.getKeyCode();
			
			//KeyEvent 클래스에는 키보드(가상의 키보드)의 고유값이 저장된 상수 존재
			switch(keyCode) {
			//이벤트가 발생된 키보드가 왼쪽 방향키인 경우
			case KeyEvent.VK_LEFT:
				//펭귄 이미지가 출력될 X 좌표값이 저장된 필드값 변경
				penguinX-=10;
				
				if(penguinX <= 0) {
					penguinX = 0;
				}
				
				//펭귄 이미지를 나타내는 필드값 변경
				penguinNo++;
				penguinNo%=3;
				
				repaint();//paint() 메소드를 호출하여 이미지를 다시 출력
				break;
			case KeyEvent.VK_RIGHT:
				//펭귄 이미지가 출력될 X 좌표값이 저장된 필드값 변경
				penguinX+=10;
				
				if(penguinX >= JFRAME_WIDTH-PENGUIN_SIZE) {
					penguinX=JFRAME_WIDTH-PENGUIN_SIZE;
				}
				
				//펭귄 이미지를 나타내는 필드값 변경
				penguinNo++;
				penguinNo%=3;
				
				repaint();//paint() 메소드를 호출하여 이미지를 다시 출력
				break;	
			}
		}
	}
}
