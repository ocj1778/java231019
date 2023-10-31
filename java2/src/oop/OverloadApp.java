package oop;

public class OverloadApp {
	public static void main(String[] args) {
		Overload overload=new Overload();
		
		overload.displayInt(100);
		//메소드 호출시 매개변수에 잘못된 값을 전달할 경우 에러 발생
		//overload.displayInt(false);
		overload.displayBoolean(false);
		overload.displayString("홍길동");
		System.out.println("==============================================================");
		//메소드 오버로딩으로 작성된 메소드는 매개변수에 전달되는 값에 따라 메소드를 선택하여 호출
		// => 메소드 오버로딩에 의한 다형성
		//다형성(Polymorphism) : 같은 이름의 메소드를 호출할 경우 상태에 따라 메소드를 선택 호출하는 기능
		// => 메소드 오버로딩, 메소드 오버라이딩 
		overload.display(200);
		overload.display(true);
		overload.display("임꺽정");
		//전달받은 값에 대한 자료형의 매개변수가 없는 경우 에러 발생 
		//overload.display(12.34);
		System.out.println("==============================================================");
	}
}
