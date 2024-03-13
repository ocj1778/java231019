package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelloWorld {
	private static final Logger logger=LoggerFactory.getLogger(LogHelloWorld.class);

	public String hello(String name) {
		logger.info("시작");
		String message=name+"님, 안녕하세요.";
		logger.info("종료");
		return message;
	}
}
