package xyz.itwill.util;

import java.util.Date;

//Date 클래스 : 날짜와 시간 관련 정보를 저장하기 위한 클래스
// => 날짜와 시간 관련 기능을 메소드로 제공
public class DateApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//new 연산자로 Date 클래스의 기본 생성자를 호출하여 객체를 생성하면 플렛폼의 현재
		//날짜와 시간 관련 정보가 저장된 Date 객체 생성
		Date now=new Date();
		
		//Date.toString() : Date 객체에 저장된 날짜와 시간 관련 정보를 문자열로 변환하여 반환하는 메소드
		System.out.println("now.toString() = "+now.toString());
		//Date 객체가 저장된 참조변수를 출력하면 자동으로 toString() 메소드 호출
		System.out.println("now = "+now);
		
		//Date.toLocaleString() : Date 객체에 저장된 날짜와 시간 관련 정보를 플렛폼의 지역 
		//관련 정보를 이용한 형태의 문자열로 변환하여 반환하는 메소드 - Deprecated 처리된 메소드
		//System.out.println("now = "+now.toLocaleString());

		//요일을 저장하기 위한 문자열 배열 선언
		String[] day={"일","월","화","수","목","금","토"};
		
		//Date 객체에 저장된 날짜와 시간 관련 정보를 활용하여 원하는 형태의 날짜를 출력
		// => Date 클래스에서 필요한 날짜와 시간을 반환하는 메소드는 Deprecated 처리된 메소드 
		//Date.getYear() : Date 객체에 저장된 날짜와 시간 관련 정보에서 [년]을 반환하는 메소드
		// => 1900년부터 1씩 증가되는 정수값 반환
		//Date.getMonth() : Date 객체에 저장된 날짜와 시간 관련 정보에서 [월]을 반환하는 메소드
		// => 0(1월) ~ 11(12월) 범위의 정수값 반환
		//Date.getDate() : Date 객체에 저장된 날짜와 시간 관련 정보에서 [일]을 반환하는 메소드
		//Date.getDay() : Date 객체에 저장된 날짜와 시간 관련 정보에서 [요일]을 반환하는 메소드
		// => 0(일) ~ 6(토) 범위의 정수값 반환
		String printDate=(now.getYear()+1900)+"년 "+(now.getMonth()+1)+"월 "
				+now.getDate()+"일 "+day[now.getDay()]+"요일";
		System.out.println("현재 날짜 = "+printDate);
		
		//Date.getTime() : Date 객체에 저장된 날짜와 시간 관련 정보를 타임스템프로 변환하여 반환하는 메소드
		//타임스템프(TimeStamp) : 1970년 1월 1일을 기준으로 1ms마다 1씩 증가된 정수값
		// => 날짜와 시간을 정수값(long)으로 변환하여 연산 처리하기 위해 사용
		long currentTime=now.getTime();//long currentTime=System.currentTimeMillis();
		
		//new 연산자로 Date 클래스의 Date(int year, int month, int date)의 생성자를 호출하여 Date 객체 생성
		// => [2000년 1월 1일 0시 0분 0초]의 날짜와 시간 관련 정보가 저장된 Date 객체 생성
		Date wantDate=new Date(100, 0, 1);
		System.out.println("wantDate = "+wantDate);
		
		long wantTime=wantDate.getTime();
		
		System.out.println("연산결과(일) = "+((currentTime-wantTime)/(1000*86400)));
	}
}
