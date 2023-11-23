package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//DatagramSocket 클래스의 DatagramPacket 클래스를 이용하여 UDP 네트워크 프로그램 작성
// => 컴퓨터들이 접속을 하지 않고 데이타를 보내는 컴퓨터와 데이타를 받는 컴퓨터로 구분하여 처리

//키보드로 메세지를 입력받아 다른 컴퓨터에게 전달하는 UDP 네트워크 프로그램 작성
public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		//키보드 입력스트림(System.in)을 대량의 문자데이타를 제공받을 수 있는 입력스트림으로 확장
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//확장된 입력스트림을 이용하여 문자열(메세지)를 입력받아 저장
		System.out.print("전달 메세지 입력 >> ");
		String message=in.readLine();
		
		//DatagramSocket 클래스 : 다른 컴퓨터와 연결하기 위한 정보를 저장하기 위한 클래스
		// => 데이타를 보내기 위한 컴퓨터에서는 DatagramSocket() 생성자로 객체 생성 
		DatagramSocket datagramSocket=new DatagramSocket();
		
		//연결할 컴퓨터의 네트워크 식별자가 저장된 InetAddress 객체를 반환받아 저장
		InetAddress inetAddress=InetAddress.getByName("192.168.13.31");
		
		//전달할 문자열(메세지)를 byte 배열(원시데이타의 모임)로 변환하여 저장
		byte[] data=message.getBytes();
		
		//DatagramPacket 클래스 : 보내거나 받을 패킷 정보를 저장하기 위한 클래스
		// => 데이타를 보내기 위한 컴퓨터에서는 DatagramPacket(byte[] data, int length
		//, InetAddress address, int port) 생성자로 객체 생성
		DatagramPacket datagramPacket=new DatagramPacket(data, data.length, inetAddress, 4000);
		
		//DatagramSocket.send(DatagramPacket packet) : 매개변수로 전달받은 DatagramPacket 객체에
		//저장된 패킷정보를 이용하여 다른 컴퓨터에게 존달하는 메소드
		datagramSocket.send(datagramPacket);		
		
		//DatagramSocket.close() : DatagramSocket 객체를 제거하는 메소드
		datagramSocket.close();
		
		System.out.println("[결과]연결 컴퓨터에게 메세지를 보냈습니다.");
	}
}
