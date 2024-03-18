package xyz.itwill06.oop;

//횡단관심코드의 메소드가 작성된 클래스 - 횡단관심모듈 : Advice 클래스
public class AopLogger {
	public void beforeLog() {
		//횡단관심코드
		System.out.println("### 메소드 명령(핵심관심코드) 실행전에 기록될 내용 ###");
	}
}
