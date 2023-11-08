package xyz.itwill.lambda;

//람다 표현식(Lambda Expression) : 익명의 클래스로 객체를 보다 쉽게 생성하기 위해 만들어진 표현식
// => 반드시 함수형 인터페이스가 있어야 람다 표현식 사용 가능

//람다 표현식을 사용하여 익명의 내부클래스로 객체를 생성하는 방법
//형식) (자료형 변수명, 자료형 변수명, ...) -> { 명령; 명령; ... }
// => 함수형 인터페이스에 선언된 추상메소드의 반환형 및 메소드명 생략
// => () 안에 함수형 인터페이스에 선언된 추상메소드의 매개변수를 작성
// => 매개변수의 자료형을 생략할 수 있으며 매개변수가 하나인 경우 () 생략 가능
// => { } 안에 함수형 인터페이스에 선언된 추상메소드를 오버라이드하여 실행될 명령 작성
// => { } 안에 작성될 명령이 하나인 경우 { } 기호를 생략 가능하지만 return 키워드에 의해 
//값을 반환하는 명령인 경우 { } 생략 불가능
// => { } 안에 작성된 하나의 명령이 return 키워드에 의해 값을 반환하는 경우 return 키워드 
//생략하면 { } 기호 생략 가능 

public class CalculateApp {
	public static void main(String[] args) {
		/*
		class CalculateImpl implements Calculate {
			@Override
			public int sum(int a, int b) {
				return a+b;
			}
		}
		
		Calculate calculate=new CalculateImpl();
		System.out.println("합계 = "+calculate.sum(10, 20));
		*/
		
		/*
		//익명의 내부클래스를 제공받아 객체를 생성하여 참조변수에 저장
		// => 익명의 내부클래스에는 반드시 모든 추상메소드를 오버라이드 선언
		Calculate calculate=new Calculate() {
			@Override
			public int sum(int a, int b) {
				return a+b;
			}
		};

		System.out.println("합계 = "+calculate.sum(10, 20));
		*/
		
		//Calculate calculate = (int a, int b) -> { return a+b; };
		//Calculate calculate = (a, b) -> { return a+b; };
		Calculate calculate = (a, b) -> a+b;
		
		System.out.println("합계 = "+calculate.sum(10, 20));
	}
}
