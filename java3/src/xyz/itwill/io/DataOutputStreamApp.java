package xyz.itwill.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamApp {
	public static void main(String[] args) throws IOException {
		//DataOutputStream 클래스 : 원하는 자료형의 값을 원시데이타로 변환하여 전달하는 
		//출력스트림을 생성하기 위한 클래스
		// => DataOutputStream(OutputStream out) 생성자를 사용하여 객체 생성
		DataOutputStream out=new DataOutputStream(new FileOutputStream("c:/data/data.txt"));
		
		//DataOutputStream.writeInt(int v) : 매개변수로 전달받은 정수값을 원시데이타로 변환
		//하여 출력스트림으로 전달하는 메소드
		out.writeInt(100);//파일 출력스트림을 이용하여 파일에 정수값 저장

		//DataOutputStream.writeBoolean(boolean v) : 매개변수로 전달받은 논리값을 원시데이타로 
		//변환하여 출력스트림으로 전달하는 메소드
		out.writeBoolean(true);//파일 출력스트림을 이용하여 파일에 논리값 저장
		
		//DataOutputStream.writeUTF(String str) : 매개변수로 전달받은 문자열을 원시데이타로 
		//변환하여 출력스트림으로 전달하는 메소드
		out.writeUTF("홍길동");//파일 출력스트림을 이용하여 파일에 문자열 저장
		
		out.close();
		
		System.out.println("c:\\data\\data.txt 파일을 확인해 보세요.");
	}
}
