package xyz.itwill00.log;

public class HelloWorldApp {
	public static void main(String[] args) {
		System.out.println("HelloWorldApp 클래스의 main 메소드 - 시작");
		HelloWorld hw=new HelloWorld();
		String message=hw.hello("홍길동");
		System.out.println("message = "+message);
		System.out.println("HelloWorldApp 클래스의 main 메소드 - 종료");
	}
}
