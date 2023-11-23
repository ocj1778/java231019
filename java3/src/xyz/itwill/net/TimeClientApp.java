package xyz.itwill.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

//NTP 서버에 접속하여 서버에서 보내온 날짜와 시간 정보를 제공받아 출력하는 클라이언트 프로그램 작성
public class TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//Socket 클래스 : TCP 네트워크 프로그램에서 컴퓨터와의 접속 정보를 저장하기 위한 클래스
			// => 접속된 컴퓨터의 소켓과 연결되면 데이타를 송수신할 수 있는 입력스트림과 출력스트림이 자동 제공
			// => Socket(String host, int port) 생성자를 사용하여 객체 생성
			// => host 매개변수는 접속할 서버 컴퓨터의 이름 또는 IP 주소를 전달하고 port 
			//매개변수에는 서버에서 활성화 처리한 포트번호를 전달하여 저장
			// => UnknownHostException 및 IOException 발생
			Socket socket=new Socket("192.168.13.31", 2000);//Socket 객체 생성 - 서버 접속
			//System.out.println("socket = "+socket);

			//Socket.getInputStream() : Socket 객체로부터 접속 컴퓨터에서 보내온 원시데이타를 
			//제공 받을 수 있는 입력스트림(InputStream 객체)을 반환하는 메소드
			InputStream stream=socket.getInputStream();
			
			//매개변수로 InputStream 객체를 전달받아 원시데이타를 객체로 제공 받을 수 있는 
			//입력스트림(ObjectInputStream)으로 확장
			ObjectInputStream in=new ObjectInputStream(stream);
			
			//입력스트림을 사용하여 접속 컴퓨터에서 보내온 객체를 반환받아 저장
			// => 입력스트림에 객체가 없는 경우 스레드 일시 중지
			Date date=(Date)in.readObject();
			
			//Date 객체에 저장된 날짜와 시간 정보를 원하는 패턴의 문자열로 변환하여 출력 처리
			System.out.println("[결과]서버에서 보내온 날짜와 시간 = "
					+new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(date));
			
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("[에러]서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
	}
}
