package xyz.itwill.io;

import java.io.IOException;

//java.io 패키지 : 입력 스트림과 출력 스트림 관련 Java 자료형이 선언된 패키지

//스트림(Stream) : 값을 전달하기 위한 목적으로 선언된 입력 클래스 또는 출력 클래스로 생성된 객체
// => 시냇물이 흐르는 모양을 모델링하여 만들어진 클래스로 한쪽방향으로 전달되며 순차적으로 처리

//원시데이타 기반의 스트림(Byte Stream) : 가공되지 않은 순수한 원시데이타를 전달하기 위한 입력 또는 출력 스트림
// => 전달값을 1Byte 단위로 입력 또는 출력하기 위한 스트림
// => InputStream 클래스와 OutputStream 클래스를 기반으로 만들어진 클래스

//키보드로 입력받은 원시데이타(1Byte)를 모니터로 전달하여 출력하는 프로그램 작성
// => EOF(End Of File) 신호(입력스트림 종료 - Ctrl+Z)를 입력받으면 프로그램 종료
public class ByteStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 문자값을 입력해 주세요.[프로그램 종료 : Ctrl+Z]");
		
		//키보드 입력값(1Byte - 원시데이타)을 저장하기 위한 변수
		int readByte;
		
		while(true) {
			//System.in : Java 프로그램 개발을 위해 기본적으로 제공되는 키보드 입력스트림이 저장된 필드
			// => InputStream 클래스를 기반으로 생성된 입력스트림(객체)
			// => 키보드를 누르면 키보드의 입력값(ASCII Code - 1Byte)이 입력스트림으로 전달
			//InputStream.read() : 입력스트림에 존재하는 원시데이타(1Byte)를 얻어와 정수값(int)
			//으로 반환하는 메소드
			// => 입력스트림에 원시데이타가 하나도 없는 경우 스레드는 일시 중지 상태로 전환
			// => 키보드로 엔터(Enter)를 입력하면 일시 중지된 스레드는 재실행
			// => 입력스트림 또는 출력스트림 관련 메소드에서는 대부분 IOException 발생
			// => IOException : 입력스트림 또는 출력스트림에 문제가 있는 경우 발생되는 일반 예외
			readByte=System.in.read();
			
			//[Ctrl+Z]를 눌러 입력스트림에 종료신호(EOF : -1)가 전달된 경우 반복문 종료
			if(readByte == -1) break;
			
			//System.out : Java 프로그램 개발을 위해 기본적으로 제공되는 모니터 출력스트림이 저장된 필드
			// => OutputStream 클래스를 기반으로 생성된 출력스트림(객체) - PrintStream 클래스
			//OutputStream.write(int b) : 매개변수로 전달받은 정수값(1Byte)을 출력스트림에 원시데이타로 전달하는 메소드
			// => 원시데이타(1Byte)를 모니터 출력스트림으로 전달하면 모니터에 원시데이타가 출력 처리
			System.out.write(readByte);
		}
		
		System.out.println("[메세지]프로그램을 종료합니다.");
	}
}
