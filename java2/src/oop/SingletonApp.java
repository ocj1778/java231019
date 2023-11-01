package oop;

public class SingletonApp {
	public static void main(String[] args) {
		/*
		//new 연산자로 생성자를 호출하여 객체를 생성해 참조변수에 저장
		// => 객체를 여러 개 생성하여 참조변수에 따로 저장하여 참조변수로 객체를 참조해 메소드 호출
		Singleton singleton1=new Singleton();
		Singleton singleton2=new Singleton();
		
		System.out.println("singleton1 = "+singleton1);
		System.out.println("singleton2 = "+singleton2);
		
		singleton1.display();
		singleton2.display();
		*/
		
		//싱글톤 클래스는 생성자가 은닉화 처리되어 new 연산자로 생성자를 호출해 객체 생성 불가능
		//Singleton singleton1=new Singleton();
		//싱글톤 클래스는 객체를 반환하는 정적 메소드를 클래스로 호출하여 객체를 반환받아 참조변수에 저장
		// => 정적 메소드를 호출하면 클래스 내부에 미리 생성된 하나의 객체만을 제공받아 반환
		Singleton singleton1=Singleton.getInstance();
		Singleton singleton2=Singleton.getInstance();
		
		System.out.println("singleton1 = "+singleton1);
		System.out.println("singleton2 = "+singleton2);

		singleton1.display();
		singleton2.display();
	}
}











