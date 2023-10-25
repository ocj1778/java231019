package basic;

//import : 다른 패키지의 클래스를 불러오기 위해 사용하는 키워드
import java.util.Scanner;

//System.in : 키보드로부터 입력된 값을 얻어와 프로그램에 제공하기 위한 객체 - 입력스트림
//System.out : 프로그램의 값을 화면(콘솔)에 전달하기 위한 객체 - 출력스트림

//사용자로부터 키보드로 이름과 나이를 입력받아 화면에 출력하는 프로그램 작성
public class ScannerApp {
	public static void main(String[] args) {
		//Scanner 클래스 : 입력스트림(키보드, 파일 등)을 이용하여 원하는 자료형의 값을 제공
		//받기 위한 기능(메소드)가 선언된 클래스
		//Scanner 클래스를 이용하여 객체를 생성한 후 참조변수에 저장
		// => new Scanner(System.in) : 키보드로부터 제공된 값을 얻아올 수 있는 객체 생성
		// => 생성된 객체를 참조변수에 저장하여 참조변수로 객체의 메소드를 호출하여 필요한 기능 구현
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("이름 입력 >> ");
		//Scanner.nextLine() : 입력값을 문자열로 변환하여 반환하는 메소드
		//키보드로 입력된 값을 문자열로 반환받아 문자열 변수에 저장
		// => 키보드 입력값이 없는 경우 프로그램의 흐름(스레드)이 일시 중지
		// => 키보드로 값을 입력한 후 엔터(Enter)를 눌러 프로그램의 흐름이 재실행되도록 처리
		String name=scanner.nextLine();		
		
		System.out.print("나이 입력 >> ");
		//Scanner.nextInt() : 입력값을 정수값으로 변환하여 반환하는 메소드
		//키보드로 입력된 값을 정수값로 반환받아 정수형 변수에 저장
		// => 키보드로 입력된 값이 정수값이 아닌 경우 예외(Exception) 발생 - 프로그램 강제 종료
		int age=scanner.nextInt();
		
		System.out.println("[결과]이름 = "+name+"님의 나이는 "+age+"살입니다.");
		
		//Scanner.close() : Scanner 객체가 사용한 입력스트림을 제거하는 메소드
		scanner.close();
	}
	
}
