package xyz.itwill.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//문자데이타 기반의 스트림(Character Stream) : 원시데이타를 가동 처리한 문자데이타를 전달하기
//위한 입력 또는 출력 스트림
// => 원시데이타를 인코딩 처리하여 원하는 문자형태(캐릭터셋 - CharacterSet)의 문자데이터로 변환
// => 전달값을 2Byte 단위로 입력 또는 출력하기 위한 스트림
// => Reader 클래스와 Writer 클래스를 기반으로 만들어진 클래스

//키보드로 입력받은 문자데이타(2Byte)를 모니터로 전달하여 출력하는 프로그램 작성
// => EOF(End Of File) 신호(입력스트림 종료 - Ctrl+Z)를 입력받으면 프로그램 종료
public class CharacterStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 문자값을 입력해 주세요.[프로그램 종료 : Ctrl+Z]");

		//InputStreamReader 클래스 : 매개변수로 InputStream 객체를 전달받아 문자데이타를 입력
		//받기 위한 입력스트림(Reader 객체)을 생성하는 클래스 - 스트림 확장
		// => 키보드를 사용하여 인코딩 처리된 문자값(2Byte)을 전달받을 수 있는 입력스트림 생성 
		InputStreamReader in=new InputStreamReader(System.in);
		
		//OutputStreamWriter 클래스 : 매개변수로 OutputStream 객체를 전달받아 문자데이타를  
		//출력하기 위한 출력스트림(Writer 객체)을 생성하기 클래스 - 스트림 확장
		// => 모니터를 사용하여 인코딩 처리된 문자값(2Byte)을 전달하여 출력할 수 있는 출력스트림 생성 
		//OutputStreamWriter out=new OutputStreamWriter(System.out);
		
		//PrintWriter 클래스 : 매개변수로 OutputStream 객체를 전달받아 문자데이타를 출력하기  
		//위한 출력스트림(Writer 객체)을 생성하는 클래스 - 스트림 확장
		// => OutputStreamWriter 클래스보다 출력 처리하기 위한 많은 메소드 제공
		// => 매개변수로 전달받은 모든 형태의 값을 문자열로 변환하여 출력스트림으로 전달 - print() or println()
		PrintWriter out=new PrintWriter(System.out);
		
		int readByte;
		
		while(true) {
			//Reader.read() : 입력스트림에 존재하는 문자값(2Byte)을 문자데이타로 얻어와
			//정수값으로 반환하는 메소드
			readByte=in.read();
			
			if(readByte == -1) break;
			
			//Writer.write(int b) : 매개변수로 전달받은 정수값(2Byte)을 출력스트림에 문자데이타로 전달하는 메소드
			// => 출력스트림에 따라 문자데이타를 출력스트림의 버퍼(Buffer : 임시메모리)에 일정한
			//크기만큼 저장하고 한번에 출력스트림으로 전달하여 출력 처리
			out.write(readByte);
			//Writer.flush() : 출력스트림의 버퍼에 존재하는 모든 문자데이타를 출력스트림으로 전달하는 메소드
			out.flush();
		}
		
		System.out.println("[메세지]프로그램을 종료합니다.");
	}
}
