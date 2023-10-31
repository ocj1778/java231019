package oop;

public class Overload {
	public void displayInt(int param) {
		System.out.println("정수값 = "+param);
	}
	
	public void displayBoolean(boolean param) {
		System.out.println("논리값 = "+param);
	}
	
	public void displayString(String param) {
		System.out.println("문자열 = "+param);
	}
	
	//메소드 오버로딩(Method Overloading) : 클래스에서 동일한 기능을 제공하는 메소드가 
	//매개변수에 의해 여러개 작성해야될 경우 메소드의 이름을 같도록 작성하는 기능
	// => 메소드의 이름은 같지만 매개변수의 자료형 또는 갯수를 다르게 작성
	// => 접근 제한자와 반환형은 메소드 오버로딩과 무관
	public void display(int param) {
		System.out.println("정수값 = "+param);
	}
	
	public void display(boolean param) {
		System.out.println("논리값 = "+param);
	}
	
	public void display(String param) {
		System.out.println("문자열 = "+param);
	}
}
