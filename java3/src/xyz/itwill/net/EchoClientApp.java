package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//키보드로 메세지를 입력받아 서버에 전달하는 클라이언트 프로그램 작성
public class EchoClientApp {
	public static void main(String[] args) throws IOException {
		//키보드 입력스트림(System.in)을 대량의 문자데이타를 제공받을 수 있는 입력스트림으로 확장
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//확장된 입력스트림을 이용하여 문자열(메세지)를 입력받아 저장
		System.out.print("전달 메세지 입력 >> ");
		String message=in.readLine();
		
		try {
			//서버 컴퓨터에 접속
			Socket socket=new Socket("192.168.13.31",3000);
			
			//소켓의 출력스트림을 대량의 문자데이타를 전달할 수 있는 출력스트림으로 확장
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//확장된 출력스트림을 이용하여 문자열(메세지)를 전달
			out.write(message);
			out.flush();
			
			//접속 해제
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("[에러]서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
	}
}
