package xyz.itwill09.util;

//스프링 스케줄링(Spring Scheduling) : 특정 날짜 및 시간마다 원하는 명령이 자동으로 실행되도록 제공하는 기능
// => 휴면 계정 처리, 메일 전송 등의 기능이 자동 실행되도록 설정
// => 스케줄링 관련 클래스를 작성하여 Spring Bean Configuration File(servlet-context.xml)에
//Spring Bean으로 등록하고 특정 날짜 및 시간마다 메소드가 자동 호출되도록 설정
// => 메소드에 @Scheduled 어노테이션을 사용하여 메소드가 자동 호출되도록 설정 가능
public class Scheduler {
	//@Scheduled : 메소드에 스케줄링 기능을 제공하기 위한 어노테이션
	//cron 속성 : 메소드를 호출하기 위한 날짜 및 시간을 속성값으로 설정
	// => 요일 : 0(일)~6(토) - [0] 대신 [7] 사용 가능
	//@Scheduled(cron = "1 * * * * *")//매월 매일 매요일 매시 매분 1초
	//@Scheduled(cron = "0 1 * * * *")//매월 매일 매요일 매시 1분 0초
	//@Scheduled(cron = "0 0 5 * * *")//매월 매일 매요일 5시 0분 0초
	//@Scheduled(cron = "0 0 5 1 * *")//매월 1일 매요일 5시 0분 0초
	//@Scheduled(cron = "0 0 5 1 1 *")//1월 1일 5시 0분 0초
	//@Scheduled(cron = "0 0 5 * * 1-5")//매월 매일 월요일부터 금요일까지 5시 0분 0초 
	//@Scheduled(cron = "0 0 5 1 1-12/3 *")//1월부터 12월까지 3개월마다 매일 5시 0분 0초 
	public void autoUpdate() {
		System.out.println("Scheduler 클래스의 autoUpdate() 메소드 호출");
	}
}
