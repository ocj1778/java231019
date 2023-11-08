package xyz.itwill.nested;

public class AnonymousApp {
	public static void main(String[] args) {
		//인터페이스를 사용하여 참조변수 생성은 가능하지만 생성자가 없으므로 객체 생성은 불가능
		// => 인터페이스는 클래스가 상속받기 위한 자료형
		// => 인터페이스를 상속받은 자식클래스는 인터페이스에 존재하는 모든 추상메소드를 반드시 오버라이드 선언
		//Anonymous anonymous=new Anonymous();

		/*
		//인터페이스를 상속받은 자식클래스 작성 - 로컬 클래스(Local Class)
		class Test implements Anonymous {
			@Override
			public void display() {
				System.out.println("익명 내부클래스의 오버라이드 메소드 호출");
			}
		}
		
		//인터페이스를 상속받은 자식클래스의 기본 생성자를 이용해 객체를 생성해 인터페이스 참조변수에 저장 가능
		Anonymous anonymous=new Test();
		anonymous.display();
		*/
		
		//인터페이스를 상속받은 이름이 없는 자식클래스의 기본 생성자를 호출하여 객체를 생성해
		//인터페이스 참조변수에 저장
		// => 인터페이스를 상속받은 이름이 없는 자식클래스 - 익명 내부클래스
		//익명 내부클래스(Anonymous InnerClass) : 추상클래스 또는 인터페이스를 상속받아 JVM이
		//자동으로 만든 이름이 없는 지역 내부클래스 
		// => 익명 내부클래스는 메소드에서 사용될 하나의 객체만을 생성할 목적으로 사용
		// => 익명 내부클래스는 반드시 추상클래스 또는 인터페이스의 모든 추상메소드를 반드시 
		//오버라이드 선언
		Anonymous anonymous=new Anonymous() {
			@Override
			public void display() {
				System.out.println("익명 내부클래스의 오버라이드 메소드 호출");
			}
		};
		
		anonymous.display();
	}
}
