package xyz.itwill.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//java.util.function 패키지 : 함수형 인터페이스가 선언된 패키지
// => 함수형 인터페이스를 사용하여 람다표현식을 사용하여 객체 생성 

public class LamdaApp {
	public static void main(String[] args) {
		int number=100;
		
		//Consumer<T> 함수형 인터페이스 : 제네릭으로 전달된 Java 자료형의 객체(값)을 매개변수로 
		//제공받아 아무것도 반환하지 않는 accept() 추상메소드가 선언된 함수형 인터페이스
		
		/*
		//익명클래스를 이용하여 객체를 생성해 참조변수에 저장
		Consumer<Integer> integerConsumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				System.out.println(number + i);
			}
		};
		*/
		
		//람다표현식을 이용하여 객체를 생성해 참조변수에 저장
		Consumer<Integer> integerConsumer = i -> System.out.println(number + i);

		integerConsumer.accept(200);
		
		//Predicate<T> 함수형 인터페이스 : 제네릭으로 전달된 Java 자료형의 객체(값)을 매개변수로 
		//제공받아 [boolean]를 반환하는 test() 추상메소드가 선언된 함수형 인터페이스
		Predicate<Integer> isEven = i -> i % 2 == 0;
		
		if(isEven.test(10)) {
			System.out.println("입력값은 [짝수]입니다.");
		} else {
			System.out.println("입력값은 [홀수]입니다.");
		}
		
		//Function<T, R> 함수형 인터페이스 : 첫번째 제네릭으로 전달된 Java 자료형의 객체를
		//매개변수로 전달받아 처리하여 두번째 제네릭으로 전달된 Java 자료형의 객체로 반환하는
		//apply() 추상메소드가 선언된 함수형 인터페이스
		Function<String, Integer> stringLength = str -> str.length();

		System.out.println("문자 갯수 = "+stringLength.apply("Java Programming"));
	}
}





