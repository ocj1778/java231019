package xyz.itwill.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//ServerSocket 클래스와 Socket 클래스를 사용하여 TCP 네트워크 프로그램 작성
// => 서버와 클라이언트가 소켓을 사용하여 1:1로 연결돼 데이타를 송수신하는 프로그램 

//접속된 클라이언트에게 서버 컴퓨터의 현재 날짜와 시간을 전달하는 서버 프로그램 작성
// => NTP(Network Time Protocol) Server : 날짜와 시간 정보를 제공하는 서버 컴퓨터
public class TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer=null;
		
		try {
			//ServerSocket 클래스 : 서버 프로그램을 작성하기 위해 사용하는 클래스
			// => ServerSocket(int port) 생성자를 이용하여 객체 생성
			// => port 매개변수에는 클라이언트가 접속할 수 있는 포트번호를 전달하여 활성화 처리
			// => 매개변수로 전달받은 포트가 다른 네트워크 프로그램에서 사용중인 경우 IOException 발생
			ntpServer=new ServerSocket(2000);//포트가 활성되어 클라이언트가 접속할 수 있는 환경 제공
			//System.out.println("ntpServer = "+ntpServer);
			
			System.out.println("[메세지]NTP Server Running...");
			
			//서버는 다수의 클라이언트가 접속되어 서비스를 제공받을 수 있도록 무한루프 사용
			while(true) {
				//ServerSocket.accept() : 클라이언트가 서버에 접속되면 클라이언트와 데이타를
				//송수신하는 Socket 객체를 반환하는 메소드
				// => 클라이언트가 접속되기 전까지 스레드가 일시 중지되며 클라이언트가 접속되면
				//클라이언트의 소켓와 연결과 소켓을 생성하여 반환하고 스레드 재실행
				Socket socket=ntpServer.accept();
				//System.out.println("socket = "+socket);
				
				
			}
		} catch (IOException e) {
			System.out.println("[에러]서버 네트워크에 문제가 발생 되었습니다.");
		}
	}
}











