package xyz.itwill02.factory;

//Factory 클래스에 의해 객체로 생성될 클래스 - 인터페이스를 상속받아 작성 
// => 인터페이스의 추상메소드를 반드시 오버라이드 선언
public class HelloMessageObject implements MessageObject {
	@Override
	public String getMessage() {
		return "Hello!!!";
	}
}
