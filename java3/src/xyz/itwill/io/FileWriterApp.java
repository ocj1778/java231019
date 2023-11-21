package xyz.itwill.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//키보드로 입력받은 값을 문자데이타로 제공받아 파일로 전달하여 저장하는 프로그램 작성
// => EOF(End Of File) 신호(입력스트림 종료 - Ctrl+Z)를 입력받으면 프로그램 종료
public class FileWriterApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[프로그램 종료 : Ctrl+Z]");

		//키보드 입력스트림을 전달받아 InputStreamReader 클래스로 입력스트림 확장
		// => 키보드 입력값을 문자데이타로 제공받기 위한 입력스트림 생성
		InputStreamReader in=new InputStreamReader(System.in);
		
		//FileWriter 클래스 : 파일에 문자데이타를 전달할 출력스트림을 생성하기 위한 클래스
		// => FileWriter(String name) 생성자를 사용하여 객체 생성
		// => name 매개변수에는 파일 출력스트림을 생성하기 위한 파일경로를 전달하여 저장
		// => 매개변수로 전달받은 위치(파일경로)에 파일이 존재하지 않는 경우 IOException 발생
		// => 파일 출력스트림은 매개변수로 전달받은 파일이 없는 경우 파일을 생성하여 출력스트림 제공
		// => 매개변수로 전달받은 파일이 있는 경우 기존 파일에 저장된 데이타는 초기화 처리되고 
		//출력스트림으로 새롭게 전달받은 값으로 파일에 저장 - 덮어씌우기(OverWrite)
		//FileWriter out=new FileWriter("c:/data/char.txt");
		
		//FileWriter(String name, boolean append) 생성자를 사용하여 객체 생성
		FileWriter out=new FileWriter("c:/data/char.txt", true);
		
		int readByte;
		
		while(true) {
			//키보드 입력스트림에 존재하는 값을 문자데이타로 반환받아 변수에 저장
			readByte=in.read();
			
			if(readByte == -1) break;
			
			//파일 출력스트림에 문자데이타를 전달하여 저장 - SAVE
			out.write(readByte);
		}
		
		//FileWriter.close() : 파일 출력스트림을 제거하는 메소드
		out.close();
		
		System.out.println("[결과]c:\\data\\char.txt 파일을 확인해 보세요.");
	}
}
