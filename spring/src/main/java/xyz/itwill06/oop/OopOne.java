package xyz.itwill06.oop;

//OOP 문제점 : 모듈화(캡슐화)가 너무 강력해서 핵심관심코드와 횡단관심코드를 분리하여 프로그램을 작성하기 어려움
// => 코드의 중복성이 높이 프로그램의 생산성 및 유지보수의 효율성 감소
public class OopOne {
	/*
	private void beforeLog() {
		System.out.println("### 메소드 명령(핵심관심코드) 실행전에 기록될 내용 ###");
	}
	*/
	
	private OopLogger logger=new OopLogger();
	
	public void display1() {
		//횡단관심코드 : 프로그램 실행에 보조적인 기능을 제공하는 명령
		// => 로그 처리, 권한 처리, 트렌젝션 처리, 예외 처리 등
		//System.out.println("### 메소드 명령(핵심관심코드) 실행전에 기록될 내용 ###");
		//beforeLog();
		logger.beforeLog();
		
		//핵심관심코드 : 프로그램 실행에 핵심적인 기능을 제공하는 명령 - 데이타 처리 명령
		System.out.println("*** OopOne 클래스의 display1() 메소드 호출 ***");
	}
	
	public void display2() {
		//System.out.println("### 메소드 명령 실행전에 기록될 내용 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display2() 메소드 호출 ***");
	}
	
	public void display3() {
		//System.out.println("### 메소드 명령 실행전에 기록될 내용 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display3() 메소드 호출 ***");
	}
}
