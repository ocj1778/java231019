package xyz.itwill.app;

import java.util.Date;
import java.util.Scanner;

//키보드로 이름과 태어난 년도를 입력받아 나이를 계산하여 이름과 나이를 출력하는 프로그램 작성
//ex) 이름 입력 >> 홍길동
//    태어난 년도 입력 >> 2000
//    [결과]홍길동님의 나이는 23살입니다.
public class CalcAgeApp {
	public static void main(String[] args) {
		//Scanner 클래스로 객체를 생성하여 참조변수에 저장
		Scanner scanner=new Scanner(System.in);
		
		//키보드를 이용하여 사용자로부터 이름과 태어난 년도를 입력받아 변수에 저장
		System.out.print("이름 입력 >> ");
		String name=scanner.nextLine();
		
		System.out.print("태어난 년도 입력 >> ");
		int birthYear=scanner.nextInt();
		
		//Date 클래스로 객체를 생성하여 참조변수에 저장
		// => java.util.Date 클래스 : 날짜와 시간을 저장하기 위한 클래스
		// => Date 클래스의 기본 생성자를 이용하여 객체를 생성하면 Date 객체에는 현재 시스템의
		//날짜와 시간이 자동으로 저장
		Date now=new Date();
		
		//Date.getYear() : Date 객체에 저장된 날짜와 시간에서 년도를 반환하는 메소드
		// => Date 객체의 년도는 1900년을 기준으로 1년에 1씩 증가된 정수값이 저장되어 있으므로
		// 반드시 1900을 더해야 현재 년도를 표현 가능
		// => @Deprecated 어노테이션이 적용된 메소드
		//@Deprecated : 메소드 사용을 권장하지 않도록 설정하는 어노테이션
		// => @Deprecated 어노테이션이 적용된 메소드를 호출할 경우 경고 발생
		//@SuppressWarnings : 경고를 제거하는 어노테이션
		//형식) @SuppressWarnings(속성 = 속성값, 속성 = 속성값, ...)
		// => @SuppressWarnings 어노테이션은 명령에서 사용 가능하지만 메소드, 클래스에서도 사용 가능
		// => @SuppressWarnings 어노테이션의 value 속성에 경고 관련 속성값을 반드시 설정 - 속성값의 경고 제거
		// => @SuppressWarnings 어노테이션에 value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
		@SuppressWarnings("deprecation")
		int currentYear=now.getYear()+1900;
		
		//현재 년도와 태어난 년도를 이용하여 나이를 계산하여 변수에 저장
		//int age=2023-birthYear;
		int age=currentYear-birthYear;
		
		//실행 결과 출력 
		System.out.println("[결과]"+name+"님의 나이는 "+age+"살입니다.");
		
		scanner.close();
	}
}
