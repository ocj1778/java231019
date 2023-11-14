package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//java.text 패키지 : 객체에 저장된 값을 변환하는 기능을 제공하는 Java 자료형이 선언된 패키지

//SimpleDateFormat 클래스 : Date 객체와 String 객체를 서로 변환하기 위한 기능을 메소드로 
//제공하기 위한 클래스
public class SimpleDateFormatApp {
	public static void main(String[] args) {
		Date now=new Date();
		
		//new 연산자로 SimpleDateFormat 클래스의 매개변수가 작성된 생성자를 호출하여 객체 생성
		// => SimpleDateFormat(String pattern) 생성자로 매개변수에 날짜와 시간 관련 패턴정보를
		//전달받아 저장한 SimpleDateFormat 객체 생성
		// => 패턴정보 : 패턴문자(날짜와 시간을 표현하기 위한 문자)를 사용하여 날짜와 시간을 표현한 문자열
		// => 패턴문자 : y(년), M(월), d(일), E(요일), AM or PM(오전 또는 오후), h(시:12)
		//, H(시:24), m(분), s(초)
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		
		//SimpleDateFormat.format(Date date) : 매개변수로 전달받은 Date 객체에 저장된 날짜와
		//시간 관련 정보를 SimpleDateFormat 객체에 저장된 패턴정보의 문자열(String 객체)로
		//변환하여 반환하는 메소드
		String printDate=dateFormat.format(now);//Date 객체 >> String 객체
		
		System.out.println("현재 날짜 = "+printDate);
		
		//SimpleDateFormat.applyPattern(String pattern) : SimpleDateFormat 객체에 저장된 패턴정보를
		//매개변수로 전달받은 문자열(패턴정보)로 변경하는 메소드
		dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("현재 날짜와 시간 = "+dateFormat.format(now));
		
		
		String want="2000-01-01 00:00:00";
		
		//SimpleDateFormat.parse(String str) : SimpleDateFormat 객체에 저장된 패턴정보와 같은
		//패턴의 문자열을 매개변수로 전달받아 Date 객체로 변환하여 반환하는 메소드 
		// => 매개변수에 SimpleDateFormat 객체에 저장된 패턴정보와 일치하지 않는 문자열이
		//전달된 경우 ParseException 발생 - 일반 예외이므로 반드시 예외 처리
		try {
			Date wantDate=dateFormat.parse(want);//String 객체 >> Date 객체
			
			System.out.println("wantDate = "+wantDate);
		} catch (ParseException e) {
			System.out.println("[에러]형식에 맞는 날짜와 시간을 입력해 주세요.");
		}
	}	
}
