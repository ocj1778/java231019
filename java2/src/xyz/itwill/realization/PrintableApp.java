package xyz.itwill.realization;

public class PrintableApp {
	public static void main(String[] args) {
		//기본메소드를 호출하기 위해서는 참조변수를 인터페이스로 선언하는 것을 권장
		Printable printOne=new PrintSingle();
		
		printOne.print();//묵시적 객체 형변환에 의해 자식클래스의 오버라이드 메소드 호출 
		printOne.scan();//인터페이스의 기본메소드 호출
		System.out.println("==============================================================");
		Printable printTwo=new PrintMulti();
		
		//묵시적 객체 형변환에 의해 자식클래스의 오버라이드 메소드 호출
		printTwo.print();
		printTwo.scan();
		System.out.println("==============================================================");
	}
}
