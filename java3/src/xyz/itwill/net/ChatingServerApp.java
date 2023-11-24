package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

//채팅 서버 프로그램
// => 클라이언트의 접속으로 생성된 소켓을 사용하여 클라이언트가 보내온 메세지를 제공받아
//모든 클라이언트에게 전달하는 기능의 서버 프로그램
// => 클라이언트의 접속으로 생성된 소켓은 새로운 스레드를 생성하여 독립적으로 입력 또는 출력
//처리되도록 다중 스레드 프로그램으로 작성
public class ChatingServerApp {
	//현재 서버에 접속중인 모든 클라이언트의 소켓정보가 저장될 List 객체를 저장하기 위한 필드 
	private List<SocketThread> clientList; 

	public ChatingServerApp() {
		ServerSocket chatingServer=null;
		
		//Vector 객체를 생성하여 필드에 저장
		clientList=new Vector<SocketThread>();
		
		try {
			chatingServer=new ServerSocket(5000);
			System.out.println("[메세지]채팅 서버 동작중...");

			while(true) {
				Socket socket=chatingServer.accept();
				
				System.out.println("[접속로그]"+socket.getInetAddress().getHostAddress()
						+"의 컴퓨터에서 채팅서버에 접속 하였습니다.");
				
				//Thread 클래스를 상속받은 자식클래스로 객체 생성 - Thread 객체
				// => 클라이언트의 접속으로 생성된 Socket 객체를 매개변수로 전달하여 SocketThread
				//객체의 socket 필드에 Socket 객체 저장
				SocketThread socketThread=new SocketThread(socket);
				
				//List 객체의 요소로 SocketThread 객체를 추가하여 저장
				clientList.add(socketThread);
				
				//Thread 객체로 새로운 스레드를 생성하여 run() 메소드의 명령 실행
				socketThread.start();			
			}
		} catch (IOException e) {
			System.out.println("[에러로그]서버가 정상적으로 동작되지 않습니다.");
		}
	}
	
	public static void main(String[] args) {
		new ChatingServerApp();
	}
	
	//현재 서버에 접속중인 모든 클라이언트에게 매개변수로 제공받은 메세지를 전달하는 메소드
	public void sendMessage(String message) {
		//List 객체에 저장된 요소값(SocketThread 객체)를 하나씩 제공받아 반복 처리
		for(SocketThread client : clientList) {
			//SocketThread 객체의 out 필드에 저장된 출력스트림을 사용하여 클라이언트에게 메세지 전달
			// => 외부클래스의 메소드에서는 내부클래스로 생성된 객체를 사용하여 접근제한자에
			//상관없이 필드 또는 메소드 사용 가능
			client.out.println(message);
		}
	}
	
	//클라이언트의 접속으로 생성된 소켓을 저장하여 입력 또는 출력 기능을 제공하기 위한 클래스
	// => 새로운 스레드를 생성하여 소켓을 사용하여 독립적으로 입력 또는 출력 입력 또는 출력 
	//명령을 실행할 수 있도록 Thread 클래스를 상속받아 작성
	public class SocketThread extends Thread {
		//클라이언트의 접속으로 생성된 소켓(Socket 객체)를 저장하기 위한 필드
		private Socket socket;
		
		//클라이언트에서 보내온 메세지를 제공받기 위한 입력스트림을 저장하기 위한 필드
		private BufferedReader in;
		
		//클라이언트에게 메세지를 전달하기 위한 출력스트림을 저장하기 위한 필드
		PrintWriter out;
		
		//매개변수로 전달받은 Socket 객체를 socket 필드에 저장
		public SocketThread(Socket socket) {
			this.socket=socket;
		}
		
		//새로운 스레드로 실행될 명령을 작성하기 위한 메소드
		// => 클라이언트가 보내온 메세지를 제공받아 모든 클라이언트에게 전달하는 기능의 메소드
		@Override
		public void run() {
			//클라이언트의 대화명을 저장하기 위한 변수
			String aliasName="";
			try {
				//소켓의 입력스트림을 제공받아 대량의 문자데이타를 제공받을 수 있는 입력스트림으로
				//확장하여 필드에 저장
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//소켓의 출력스트림을 제공받아 대량의 문자데이타를 전달할 수 있는 출력스트림으로
				//확장하여 필드에 저장
				//PrintWriter(OutputStream out, boolean autoFlush) 생성자로 객체 생성
				// => autoFlush 매개변수에 [true]를 전달하면 버퍼를 사용하지 않고 무조건
				//출력스트림으로 문자데이타 전달 - Writer.flush() 메소드 호출 생략 가능
				out=new PrintWriter(socket.getOutputStream(), true);
				
				//클라이언트에서 보내온 대화명을 제공받아 저장
				// => 클라이언트가 대화명을 전달하기 전까지 스레드는 일시 중지
				aliasName=in.readLine();
				
				//현재 접속중인 모든 클라이언트에게 입장 메세지 전달
				// => 내부클래스의 메소드에서는 외부클래스의 필드 또는 메소드를 접근제한자에
				//상관없이 사용 가능
				sendMessage("["+aliasName+"]님이 입장 하였습니다.");
				
				//클라이언트가 보내온 메세지를 제공받아 현재 서버에 접속중인 모든 클라이언트에게 전달
				// => 클라이언트가 접속을 종료하기 전까지 반복 처리
				// => 클라이언트가 접속을 종료하면 입력스트림과 출력스트림이 소멸되어 IOException 발생
				while(true) {
					//클라이언트가 메세지를 보내기 전까지 스레드는 일시 중지
					// => 클라이언트가 접속을 종료한 경우 IOException 발생
					sendMessage("["+aliasName+"]"+in.readLine());
				}
			} catch (IOException e) {//클라이언트가 접속을 종료한 경우 실행될 명령 작성
				//List 객체에 저장된 요소 중 접속 종료된 클라이언트의 소켓정보(SocketThread 객체) 삭제 처리
				clientList.remove(this);
				
				//현재 접속중인 모든 클라이언트에게 퇴장 메세지 전달
				sendMessage("["+aliasName+"]님이 퇴장 하였습니다.");
				
				System.out.println("[해제로그]"+socket.getInetAddress().getHostAddress()
						+"의 컴퓨터가 채팅서버의 접속을 종료 하였습니다.");
			}
		}
	}
}
