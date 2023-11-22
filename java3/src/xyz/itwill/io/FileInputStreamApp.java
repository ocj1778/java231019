package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//파일에 저장된 값을 원시데이타로 제공받아 모니터에 전달하여 출력하는 프로그램 작성 
public class FileInputStreamApp {
	public static void main(String[] args) throws IOException {
		//FileInputStream 클래스 : 파일에 저장된 값을 원시데이타로 제공받을 수 있는 입력스트림을 
		//생성하기 위한 클래스
		// => FileInputStream(String name) 생성자를 사용하여 객체 생성
		// => name 매개변수에는 파일 입력스트림을 생성하기 위한 파일경로를 전달하여 저장
		// => 매개변수로 전달받은 위치(파일경로)에 파일이 없는 경우 FileNotFoundException 발생
		// => 파일이 없으면 파일 입력스트림을 생성할 수 없으므로 반드시 예외 처리
		FileInputStream in=null;
		try {
			in=new FileInputStream ("c:/data/byte.txt");
		} catch (FileNotFoundException e) {
			System.out.println("[에러]c:\\data\\byte.txt 파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		
		System.out.println("[메세지]c:\\data\\byte.txt 파일에 저장된 내용입니다.");
		
		int readByte;
		
		while(true) {
			//파일 입력스트림을 사용하여 파일에 저장된 값을 원시데이타로 제공받아 저장 - LOAD
			readByte = in.read();
			
			//파일 입력스트림으로 제공받을 원시데이타가 없는 경우 반복문 종료
			if(readByte == -1) break;
			
			//원시데이타를 모니터 출력스트림으로 전달하여 출력 처리
			System.out.write(readByte);
		}
		
		//FileInputStream.close() : 파일 입력스트림을 제거하는 메소드
		in.close();
	}
}
