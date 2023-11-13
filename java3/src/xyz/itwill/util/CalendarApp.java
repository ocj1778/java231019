package xyz.itwill.util;

import java.util.Calendar;

//Calendar 클래스 : 날짜와 시간 관련 정보를 저장하기 위한 클래스
// => 날짜와 시간 관련 기능을 메소드로 제공
public class CalendarApp {
	public static void main(String[] args) {
		//Calendar 클래스의 생성자는 protected 접근제한자로 선언되어 있어 new 연사자로 생성자를
		//호출하여 객체 생성 불가능 - 상속받은 자식클래스의 생성자로 객체 생성 가능
		//Calendar calendar=new Calendar();//에러 발생
		
		//Calendar.getInstance() : Calendar 객체를 반환하는 정적메소드
		// => 플렛폼의 현재 날짜와 시간 관련 정보가 저장된 Calendar 객체 반환
		Calendar calendar=Calendar.getInstance();
		
		//Calendar.toString() : Calendar 객체에 저장된 날짜와 시간 관련 정보를 문자열로 변환하여 반환하는 메소드
		//System.out.println("calendar.toString() = "+calendar.toString());
		System.out.println("calendar = "+calendar);

		//요일을 저장하기 위한 문자열 배열 선언
		String[] day={"일","월","화","수","목","금","토"};
		
		//Calendar 객체에 저장된 날짜와 시간 관련 정보를 활용하여 원하는 형태의 날짜를 출력
		//Calendar.get(int field) : Calendar 객체에 저장된 날짜와 시간 관련 정보에서 매개변수로
		//전달받은 Calendar 클래스의 상수(Constant)에 대한 값을 반환하는 메소드
		// => [월]은 0(1월)~11(12월) 범위의 정수값으로 반환되며 [요일]은 1(일)~7(토) 범위의 정수값으로 반환
		String printDate=calendar.get(Calendar.YEAR)+"년 "
				+(calendar.get(Calendar.MONTH)+1)+"월 "
				+calendar.get(Calendar.DATE)+"일 "
				+day[calendar.get(Calendar.DAY_OF_WEEK)-1]+"요일";
		System.out.println("현재 날짜 = "+printDate);
	}
}
