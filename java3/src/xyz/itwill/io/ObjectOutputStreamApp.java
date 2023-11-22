package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;

public class ObjectOutputStreamApp {
	public static void main(String[] args) throws IOException {
		//ObjectOutputStream 클래스 : 원하는 자료형의 객체를 원시데이타로 변환하여 전달하는 
		//출력스트림을 생성하기 위한 클래스
		// => ObjectOutputStream(OutputStream out) 생성자를 사용하여 객체 생성
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("c:/data/object.txt"));
		
		//ObjectOutputStream.writeObject(Object obj) : 매개변수로 전달받은 객체를 원시데이타로
		//변환하여 출력스트림으로 전달하는 메소드
		out.writeObject("홍길동");//입력스트림으로 String 객체를 전달하여 파일에 저장
		out.writeObject(new Date());//입력스트림으로 Date 객체를 전달하여 파일에 저장
		out.writeObject(List.of("임꺽정","전우치","일지매"));//입력스트림으로 List 객체를 전달하여 파일에 저장
		
		out.close();
		
		System.out.println("c:\\data\\object.txt 파일을 확인해 보세요.");
	}
}
