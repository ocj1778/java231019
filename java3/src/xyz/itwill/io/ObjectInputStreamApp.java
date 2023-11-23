package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

public class ObjectInputStreamApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//ObjectInputStream 클래스 : 원시데이타를 원하는 자료형의 객체로 변환하여 제공받는 
		//입력스트림을 생성하기 위한 클래스
		// => ObjectInputStream(InputStream in) 생성자를 사용하여 객체 생성
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("c:/data/object.txt"));
		
		//ObjectInputStream.readObject() : 입력스트림의 원시데이타를 객체로 변환하여 반환하는 메소드
		// => Object 타입의 객체로 반환되므로 반드시 명시적 객체 형변환을 이용하여 원하는
		//자료형의 객체로 반환받아 사용
		// => 반환되는 객체의 자료형(클래스)가 없는 경우 ClassNotFoundException이 발생되므로 
		//예외 처리하거나 예외 전달
		// => 파일에 저장된 객체를 순서대로 제공받지 않은 경우 ClassCastException 발생 가능
		String string=(String)in.readObject();
		Date date=(Date)in.readObject();
		@SuppressWarnings("unchecked")
		List<String> list=(List<String>)in.readObject();
		
		System.out.println("string = "+string);//String.toString() 메소드 자동 호출
		System.out.println("date = "+date);//Date.toString() 메소드 자동 호출
		System.out.println("list = "+list);//List.toString() 메소드 자동 호출
		
		in.close();
	}
}
