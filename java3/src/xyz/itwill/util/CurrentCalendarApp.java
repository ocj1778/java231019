package xyz.itwill.util;

import java.util.Calendar;

//현재 년월에 대한 달력을 출력하는 프로그램 작성
public class CurrentCalendarApp {
	public static void main(String[] args) {
		//플렛폼의 현재 날짜와 시간 관련 정보가 저장된 Calendar 객체 생성
		Calendar calendar=Calendar.getInstance();
		
		//Calendar 객체에 저장된 날짜와 시간 관련 정보 중 [일]을 [1일]로 변경
		// => 달력으로 출력될 년월의 [1일]에 대한 요일을 제공받기 위해 변경 처리
		//Calendar.set(int field, int value) : Calendar 객체에 저장된 날짜와 시간 관련 정보에서
		//매개변수로 전달받은 상수를 이용하여 필요한 정보를 변경하는 메소드
		calendar.set(Calendar.DATE, 1);
		
		//Calendar 객체에 저장된 날짜와 시간 관련 정보 중 [요일]을 반환받아 저장
		// => 달력으로 출력될 년월의 [1일]에 대한 요일을 제공받기 저장
		int week=calendar.get(Calendar.DAY_OF_WEEK);
		//System.out.println("week = "+week);
		
		//Calendar 객체에 저장된 날짜와 시간 관련 정보 중 [년]과[월]을 반환받아 출력
		System.out.println("         "+calendar.get(Calendar.YEAR)+"년 "
				+(calendar.get(Calendar.MONTH)+1)+"월");
		System.out.println("============================");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("============================");
		
		//[1]일이 출력되기 전까지의 요일을 공백으로 출력
		for(int i=1;i<week;i++) {
			System.out.print("    ");
		}
		
		//월의 [1일]부터 월의 마지막 일까지 출력
		//Calendar.getActualMaximum(int field) : Calendar 객체에 저장된 날짜와 시간 관련 정보에서
		//매개변수로 전달받은 상수에 대한 최대값을 반환하는 메소드
		for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			//날짜 출력 - 자릿수를 맞춰 출력되도록 선택문 사용
			if(i <= 9) {
				System.out.print("   "+i);
			} else {
				System.out.print("  "+i);
			}
			
			//요일 증가
			week++;
			
			//다음에 출력될 [일]에 대한 요일이 [일요일]인 경우 
			if(week % 7 == 1) {
				System.out.println();//엔터 출력
			}
		}
		System.out.println();
		System.out.println("============================");
		
	}
}
