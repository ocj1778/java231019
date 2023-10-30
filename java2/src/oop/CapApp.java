package oop;

//Car 클래스를 객체로 생성하여 사용하기 위한 클래스 - 프로그램
public class CapApp {
	public static void main(String[] args) {
		//Car 클래스를 이용하여 객체를 생성해 참조변수에 저장
		// => 하나의 클래스로 서로 다른 속성값이 저장된 다수의 객체 생성
		// => 클래스는 객체를 생성하기 위한 틀(Template)
		// => 객체를 생성하면 객체 필드에는 기본값(숫자형 : 0, 논리형 : false, 참조형 : null)이 초기값으로 자동 저장
		Car carOne=new Car();
		Car carTwo=new Car();
		Car carThree=new Car();
		
		System.out.println("carOne = "+carOne);
		System.out.println("carTwo = "+carTwo);
		System.out.println("carThree = "+carThree);
	}
}
