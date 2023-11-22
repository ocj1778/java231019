package xyz.itwill.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

//키보드로 이름과 태어난 년도를 입력받아 이름과 나이를 계산하여 모니터에 출력하는 프로그램 작성
public class ConsoleIOApp {
	public static void main(String[] args) throws IOException {
		//Java 프로그램 개발을 위해 기본적으로 제공되는 키보드 입력스트림(InputStream 객체)을
		//전달받아 InputStreamReader 클래스를 사용하여 문자데이타를 입력받을 수 입력스트림
		//(Reader 객체)으로 확장하고 확장된 입력스트림를 다시 전달받아 BufferedReader 클래스를 
		//사용하여 대량의 문자데이타(문자열)를 입력받을 수 있는 입력스트림으로 확장
		// => 입력 또는 출력 관련 클래스는 스트림의 다단계 연결을 사용하여 스트림 확장 가능
		//키보드로 문자열을 입력받기 위한 입력스트림(BufferedReader 객체) 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		/*		
		//모니터로 문자열을 전달하기 위한 출력스트림 생성
		// => 다단계 연결을 사용한 출력스트림 확장
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		out.write("이름 입력 >> ");
		out.flush();
		*/
		
		//Java 프로그램 개발을 위해 기본적으로 제공되는 모니터 출력스트림(PrintStream 객체)은
		//print() 또는 println() 메소드를 사용하여 매개변수로 전달받은 모든 형태의 값을 문자열로
		//변환하여 출력스트림으로 전달해 모니터에 출력 처리 - 출력스트림 확장 불필요
		System.out.print("이름 입력 >> ");
		//BufferedReader.readLine() : 입력스트림에서 대량의 문자값들(문자열)을 얻어와 반환하는 메소드
		String name=in.readLine();
		
		System.out.print("태어난 년도 입력 >> ");
		//키보드로 입력받은 문자열을 정수값으로 변환하여 저장 - NumberFormatException 발생
		int birthYear=Integer.parseInt(in.readLine());
		
		int age=Calendar.getInstance().get(Calendar.YEAR)-birthYear;
		
		System.out.println("[결과]"+name+"님의 나이는 "+age+"살입니다.");
	}
}
