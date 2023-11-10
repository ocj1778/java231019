package xyz.itwill.util;

import java.util.Random;

//java.util 패키지 : 프로그램 작성에 유용한 기능을 제공하는 Java 자료형이 선언된 패키지

//Scanner 클래스 : 입력장치로부터 값을 입력받기 위한 기능을 메소드로 제공하는 클래스
//Arrays 클래스 : 배열 요소값을 처리하기 위한 기능을 메소드로 제공하는 클래스

//Random 클래스 : 난수값 관련 기능을 메소드로 제공하는 클래스
public class RandomApp {
	public static void main(String[] args) {
		Random random=new Random();
		
		//Random.nextInt(int bound) : 0~bound-1 범위의 정수 난수값을 생성하여 반환하는 메소드
		for(int i=1;i<=5;i++) {
			System.out.println(i+"번째 난수값 = "+random.nextInt(100));//0~99
		}
	}
}
