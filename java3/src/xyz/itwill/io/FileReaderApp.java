package xyz.itwill.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

//파일에 저장된 값을 문자데이타로 제공받아 모니터에 전달하여 출력하는 프로그램 작성 
public class FileReaderApp {
	public static void main(String[] args) throws IOException {
		//FileReader : 파일에 저장된 값을 문자데이타로 제공받을 수 있는 입력스트림을 생성하기 위한 클래스
		// => FileReader(String name) 생성자를 사용하여 객체 생성
		// => name 매개변수에는 파일 입력스트림을 생성하기 위한 파일경로를 전달하여 저장
		// => 매개변수로 전달받은 위치(파일경로)에 파일이 없는 경우 FileNotFoundException 발생
		// => 파일이 없으면 파일 입력스트림을 생성할 수 없으므로 반드시 예외 처리
		FileReader in=null;
		try {
			in=new FileReader("c:/data/char.txt");
		} catch (FileNotFoundException e) {
			System.out.println("[에러]c:\\data\\char.txt 파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		
		System.out.println("[메세지]c:\\data\\char.txt 파일에 저장된 내용입니다.");
		
		//모니터 출력스트림을 전달받아 OutputStreamWriter 클래스로 출력스트림 확장
		// => 모니터에 문자데이타를 전달하기 위한 출력스트림 생성
		OutputStreamWriter out=new OutputStreamWriter(System.out);
		
		int readByte;
		
		while(true) {
			//파일 입력스트림을 사용하여 파일에 저장된 값을 문자데이타로 제공받아 저장 - LOAD
			readByte = in.read();
			
			//파일 입력스트림으로 제공받을 문자데이타가 없는 경우 반복문 종료
			if(readByte == -1) break;
			
			//문자데이타를 확장된 모니터 출력스트림으로 전달하여 출력 처리
			// => 모니터 출력스트림에는 출력버퍼가 존재하므로 반드시 flush() 메소드 호출
			out.write(readByte);
			out.flush();//출력버퍼에 존재하는 문자데이타를 출력스트림으로 전달하는 메소드
		}
		
		//FileReader.close() : 파일 입력스트림을 제거하는 메소드
		in.close();
	}
	
}
