package xyz.itwill00.log;

public class HelloWorld {
	public String hello(String name) {
		System.out.println("HelloWorld 클래스의 hello 메소드 - 시작");
		String message=name+"님, 안녕하세요.";
		System.out.println("HelloWorld 클래스의 hello 메소드 - 종료");
		return message;
	}
}
