package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;

//키보드로 입력받은 원시데이타를 파일로 전달하여 저장하는 프로그램 작성
// => EOF(End Of File) 신호(입력스트림 종료 - Ctrl+Z)를 입력받으면 프로그램 종료
public class FileOutputStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[프로그램 종료 : Ctrl+Z]");
		
		//FileOutputStream 클래스 : 파일에 원시데이타를 전달할 출력스트림을 생성하기 위한 클래스
		// => FileOutputStream(String name) 생성자를 사용하여 객체 생성
		// => name 매개변수에는 파일 출력스트림을 생성하기 위한 파일경로를 전달하여 저장
		// => 매개변수로 전달받은 위치(파일경로)에 파일이 존재하지 않는 경우 FileNotFoundException 발생
		// => FileNotFoundException 대신 IOException를 이용하여 예외 처리 또는 예외 전달 가능
		//파일 출력스트림은 매개변수로 전달받은 파일이 없는 경우 파일을 생성하여 출력스트림 제공
		// => 매개변수로 전달받은 파일이 있는 경우 기존 파일에 저장된 데이타는 초기화 처리되고 
		//출력스트림으로 새롭게 전달받은 값으로 파일에 저장 - 덮어씌우기(OverWrite)
		FileOutputStream out=new FileOutputStream("c:/data/byte.txt");
		
		int readByte;
		
		while(true) {
			//키보드 입력스트림에 존재하는 원시데이타를 반환받아 변수에 저장
			readByte=System.in.read();
			
			if(readByte == -1) break;
			
			//파일 출력스트림에 원시데이타를 전달하여 저장 - SAVE
			out.write(readByte);
		}
		
		//FileOutputStream.close() : 파일 출력스트림을 제거하는 메소드
		// => 파일에는 입력스트림과 출력스트림을 각각 하나씩만 생성하여 사용 가능
		out.close();	
		
		System.out.println("[결과]c:\\data\\byte.txt 파일을 확인해 보세요.");
	}
}
