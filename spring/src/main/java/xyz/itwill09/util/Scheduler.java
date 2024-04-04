package xyz.itwill09.util;

import org.springframework.scheduling.annotation.Scheduled;

//스프링 스케줄링(Spring Scheduling) : 특정 날짜 및 시간마다 원하는 명령이 자동으로 실행되도록 제공하는 기능
// => 휴면 계정 처리, 메일 전송 등의 기능이 자동 실행되도록 설정
// => 스케줄링 관련 클래스를 작성하여 Spring Bean Configuration File(servlet-context.xml)에
//Spring Bean으로 등록하고 특정 날짜 및 시간마다 메소드가 자동 호출되도록 설정
// => 메소드에 @Scheduled 어노테이션을 사용하여 메소드가 자동 호출되도록 설정 가능

public class Scheduler {
	//@Scheduled : 메소드에 스케줄링 기능을 제공하기 위한 어노테이션
	//cron 속성 : 메소드를 호출하기 위한 날짜 및 시간을 속성값으로 설정
	@Scheduled(cron = "1 * * * * *")
	public void autoUpdate() {
		System.out.println("Scheduler 클래스의 autoUpdate() 메소드 호출");
	}
}
