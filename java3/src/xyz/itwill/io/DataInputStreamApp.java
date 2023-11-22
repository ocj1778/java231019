package xyz.itwill.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamApp {
	public static void main(String[] args) throws IOException {
		//DataInputStream 클래스 : 원시데이타를 원하는 자료형의 값으로 변환하여 제공받을 
		//입력스트림을 생성하기 위한 클래스
		// => DataInputStream(InputStream in) 생성자를 사용하여 객체 생성
		DataInputStream in=new DataInputStream(new FileInputStream("c:/data/data.txt"));
		
		//반드시 파일에 저장된 자료형의 순서대로 메소드를 호출하여 값을 반환받아 사용
		// => 순서대로 메소드를 호출하지 않으면 잘못된 값이 저장되거나 EOFException 발생
		
		//DataInputStream.readInt() : 입력스트림의 원시데이타를 정수값으로 변환하여 반환하는 메소드
		int value1=in.readInt();
		
		//DataInputStream.readBoolean() : 입력스트림의 원시데이타를 논리값으로 변환하여 반환하는 메소드
		boolean value2=in.readBoolean();

		//DataInputStream.readUTF() : 입력스트림의 원시데이타를 문자열로 변환하여 반환하는 메소드
		String value3=in.readUTF();
		
		System.out.println("value1 = "+value1);
		System.out.println("value2 = "+value2);
		System.out.println("value3 = "+value3);
		
		in.close();
	}
}









