package xyz.itwill.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//다른 컴퓨터에서 보내온 메세지를 제공받아 출력하는 UDP 프로그램 작성
public class MessageReceiveApp {
	public static void main(String[] args) throws IOException {
		//데이타를 받기 위한 컴퓨터에서는 DatagramSocket(int port) 생성자로 객체 생성
		// => 데이타를 받기 위해 포트번호를 활성화 처리
		DatagramSocket datagramSocket=new DatagramSocket(4000);
		
		//제공받을 원시데이타를 저장하기 위한 byte 배열 생성
		byte[] data=new byte[1024];
		
		//데이타를 받기 위한 컴퓨터에서는 DatagramPacket(byte[] data, int length) 생성자로 객체 생성
		DatagramPacket datagramPacket=new DatagramPacket(data, data.length);
		
		System.out.println("메세지 수신 중...");
		
		//DatagramSocket.receive(DatagramPacket packet) : 연결 컴퓨터에서 보내온 원시데이타를
		//제공받아 DatagramPacket 객체의 byte 배열에 저장하는 메소드
		// => 원시데이타를 받기 전까지 스레드 일시 중지
		// => 제공받을 원시데이타가 많은 경우 반복문 사용
		datagramSocket.receive(datagramPacket);
		
		//제공받은 원시데이타를 문자열로 변환하여 저장
		String message=new String(data);
		
		System.out.println("[결과]보내온 메세지 = "+message);
		
		datagramSocket.close();
	}
}








