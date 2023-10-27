package oop;

//실행의 목적으로 작성된 클래스
public class MethodApp {
	//JVM(Java Virtual Machine)에 의해 자동으로 호출되는 메소드
	// => 프로그램이 시작되는 위치
	public static void main(String[] args) {
		//클래스로 객체를 생성하여 객체의 메모리 주소를 참조변수에 저장
		// => 같은 패키지에 작성된 클래스는 패키지를 표현하지 않아도 클래스 사용 가능
		Method method=new Method();
		
		//참조변수를 출력할 경우 "자료형@메모리주소" 형식의 문자열을 제공받아 출력
		System.out.println("method = "+method);
		System.out.println("==============================================================");
		//참조변수에 저장된 메모리 주소로 객체를 참조하여 객체의 메소드 호출
		// => 메소드를 호출하면 프로그램의 흐름(스레드)이 객체의 메소드로 이동하여 메소드의
		//명령을 실행하고 메소드가 종료되는 다시 되돌아와 다음 명령 실행
		method.displayOne();
		method.displayTwo();
		method.displayOne();
		System.out.println("==============================================================");
	}
}
