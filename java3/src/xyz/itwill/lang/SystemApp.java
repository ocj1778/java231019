package xyz.itwill.lang;

import java.util.Scanner;

//Java API(Application Programming Interface) : Java 프로그램 개발에 필요한 기능을 제공하기 위한 도구
// => 라이브러리에 의해 배포된 Java 자료형(클래스, 인터페이스, 열거형)
// => API 문서를 활용하여 Java 자료형에 대한 설명을 제공받아 사용
// => 온라인 API 문서 - https://docs.oracle.com/en/java/javase/17/docs/api/index.html

//java.lang 패키지 : Java 프로그램 개발에 필요한 기본 자료형을 제공하는 패키지
// => java.lang 패키지의 자료형은 import 처리하지 않아도 사용

//Object 클래스 : 모든 Java 클래스가 반드시 상속받는 부모클래스
// => 모든 Java 클래스를 대표하여 사용할 수 있는 클래스
//Class 클래스 : 메모리(MethodArea)에 저장된 클래스정보(Class 객체 - Clazz)를 저장하여 필요한
//기능을 메소드로 제공하는 클래스
//Math 클래스 : 수학 관련 기능을 메소드로 제공하는 클래스

//System 클래스 : 표준 입출력 스트림을 제공하거나 시스템 관련 기능을 메소드로 제공하는 클래스
public class SystemApp {
	public static void main(String[] args) {
		//System.in : Java 프로그램에서 제공하는 표준 입력장치(키보드)에 대한 입력스트림(객체)이 저장된 필드 
		Scanner scanner=new Scanner(System.in);
		
		//System.out : Java 프로그램에서 제공하는 표준 출력장치(모니터)에 대한 출력스트림(객체)이 저장된 필드
		System.out.print("정수값 입력 >> ");
		int num=scanner.nextInt();
		
		if(num==0) {
			System.out.println("[메세지]프로그램을 종료합니다.");
			//System.exit(int status) : 프로그램의 모든 스레드를 소멸시키는 메소드
			// => 프로그램을 강제로 종료하는 메소드
			System.exit(0);
		}
		
		//System.gc() : 메모리를 청소하는 프로그램(Garbage Collector)를 실행하는 메소드
		System.gc();
		
		//System.currentTimeMillis() : 플렛폼(Platform : 프로그램이 실행될 수 있는 환경을 
		//제공하는 프로그램 - 운영체제)의 현재 날짜와 시간에 대한 타임스템프를 반환하는 메소드
		//타임스템프(TimeStamp) : 날짜와 시간을 정수값으로 표현하기 위해 만들어진 시간값
		// => 1970년 1월 1일을 기준으로 1/1000초(1ms)당 1씩 증가된 정수값
		// => 날짜와 시간을 정수값으로 표현하여 연산(-)하기 위해 사용
		long startTime=System.currentTimeMillis();
		
		for(int i=1;i<=num;i++) {
			System.out.println(i+"번째 실행되는 명령");
		}
		
		long endTime=System.currentTimeMillis();
		
		System.out.println("반복문 실행 시간 = "+(endTime-startTime)+"ms");
		
		scanner.close();
	}
}
