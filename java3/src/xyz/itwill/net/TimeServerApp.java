package xyz.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//TCP 네트워크 프로그램 : ServerSocket 클래스와 Socket 클래스를 사용하여 작성
// => 클라이언트가 서버에 접속(Connection)하여 서버와 클라이언트에 만들어진 소켓을 사용해  
//1:1로 연결되어 데이타를 송수신하는 프로그램 

//접속된 클라이언트에게 서버 컴퓨터의 현재 날짜와 시간 정보를 전달하는 서버 프로그램 작성
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
				//클라이언트의 소켓와 연결된 소켓을 서버에 생성하여 반환하고 스레드 재실행
				Socket socket=ntpServer.accept();
				//System.out.println("socket = "+socket);
				
				/*
				//Socket.getOutputStream() : Socket 객체로부터 접속 컴퓨터에게 원시데이타를 
				//전달할 수 있는 출력스트림(OutputStream 객체)을 반환하는 메소드
				OutputStream stream=socket.getOutputStream();

				//매개변수로 OutputStream 객체를 전달받아 객체를 전달할 수 있는 출력스트림
				//(ObjectOutputStream)으로 확장
				ObjectOutputStream out=new ObjectOutputStream(stream);
				
				//확장된 출력스트림을 이용하여 플렛폼의 현재 날짜와 시간정보가 저장된 Date 객체를
				//접속 컴퓨터(클라리언트)에게 전달
				out.writeObject(new Date());
				*/
				
				//불필요한 식별자를 제거한 명령
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//로그 처리 - 기록
				//Socket.getInetAddress() : Socket 객체에 저장된 접속 컴퓨터의 네트워크 식별자가
				//저장된 InetAddress 객체를 반환하는 메소드
				System.out.println("[정보]클라이언트["+socket.getInetAddress().getHostAddress()
						+"]에게 날짜와 시간정보를 제공 하였습니다.");
				
				//Socket.close() : 소켓을 제거하는 메소드 - 접속 컴퓨터와의 연결 해제
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("[에러]서버 네트워크에 문제가 발생 되었습니다.");
		} finally {
			try {
				//ServerSocket.close() : ServerSocket 객체를 제거하는 메소드 - 서버 종료
				// => 접속된 모든 클라이언트의 접속 해제
				ntpServer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
