package xyz.itwill.util;

import java.util.Calendar;
import java.util.Scanner;

//키보드로 [년]과 [월]을 입력받아 해당 년월에 대한 달력을 출력하는 프로그램 작성
public class WantCalendarApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("년 입력 >> ");
		int year=scanner.nextInt();
		
		System.out.print("월 입력 >> ");
		int month=scanner.nextInt();
		
		scanner.close();

		//플렛폼의 현재 날짜와 시간 관련 정보가 저장된 Calendar 객체를 반환받아 저장
		Calendar calendar=Calendar.getInstance();
		
		//Calendar 객체에 저장된 날짜와 시간 관련 정보 중 년월일을 키보드로 입력받은 [년]과
		//[월]의 [1일]로 변경 처리
		// => Calendar 객체는 월을 0~11 범위의 정수값으로 표현하므로 키보드 입력값을 [1] 감소하여 변경
		calendar.set(year, month-1, 1);
		
		int week=calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("          "+year+"년 "+month+"월");
		System.out.println("============================");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("============================");
		
		for(int i=1;i<week;i++) {
			System.out.print("    ");
		}
		
		for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			if(i <= 9) {
				System.out.print("   "+i);
			} else {
				System.out.print("  "+i);
			}
			
			week++;
			
			if(week % 7 == 1) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("============================");
	}
}
