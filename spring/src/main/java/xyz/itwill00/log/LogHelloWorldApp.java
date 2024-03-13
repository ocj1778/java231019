package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelloWorldApp {
	//Logger 객체 : 로그 이벤트를 발생하기 위한 객체
	// => Logger 객체에 의해 로그 이벤트가 발생되면 로그 구현체가 로깅 정보를 제공받아 기록
	//LoggerFactory 클래스 : Logger 객체를 생성하여 제공하기 위한 클래스 - Factory 클래스
	//LoggerFactory.getLogger(Class<T> clazz) : 메모리에 저장된 클래스(Class 객체 - Clazz)를 전달받아 
	//해당 클래스에서 로그 이벤트를 발생할 수 있는 Logger 객체를 생성하여 반환하는 정적 메소드
	private static final Logger logger=LoggerFactory.getLogger(LogHelloWorldApp.class);
	
	public static void main(String[] args) {
		//Logger.info(String message) : Logger 객체로 INFO 레벨의 로그 이벤트를 발생하는 메소드
		// => 매개변수에는 로그 구현체로 기록될 로그 메세지 전달
		logger.info("시작");
		LogHelloWorld hw=new LogHelloWorld();
		String message=hw.hello("홍길동");
		System.out.println("message = "+message);
		logger.info("종료");
	}
}
