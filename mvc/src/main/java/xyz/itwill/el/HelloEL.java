package xyz.itwill.el;

//EL 표현식에서 EL 함수를 사용할 경우 호출될 메소드가 작성된 클래스
public class HelloEL {
	//EL 표현식에서 EL 함수를 사용할 경우 호출될 메소드
	// => 반드시 정적 메소드(Static Method) 선언하면 실행 결과값을 무조건 반환 처리
	public static String hello(String name) {
		return name+"님, 안녕하세요.";
	}
}
