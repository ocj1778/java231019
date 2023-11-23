package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//클라이언트에서 보내온 메세지를 제공받아 출력하는 서버 프로그램 작성
public class EchoServerApp {
	public static void main(String[] args) {
		ServerSocket echoServer=null;
		
		try {
			echoServer=new ServerSocket(3000);
			System.out.println("[메세지]Echo Server Running...");
			
			while(true) {
				Socket socket=echoServer.accept();
				
				//소켓의 입력스트림을 반환받아 대량의 문자데이타(문자열)를 제공받을 수 있는 입력스트림으로 확장
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//확장된 입력스트림으로 클라이언트가 보내온 문자열(메세지)를 반환받아 출력				
				System.out.println("["+socket.getInetAddress().getHostAddress()
						+"]님이 보내온 메세지 = "+in.readLine());
				
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("[에러]서버 네트워크에 문제가 발생 되었습니다.");
		}
	}
}








