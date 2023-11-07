package xyz.itwill.nested;

import xyz.itwill.nested.OuterOne.InnerOne;

public class OuterOneApp {
	public static void main(String[] args) {
		OuterOne outerOne=new OuterOne(100);
		outerOne.outerDisplay();
		System.out.println("==============================================================");
		//외부클래스가 아닌 클래스의 메소드에서는 객체 내부클래스의 생성자를 직접 호출하여 
		//객체 생성 불가능
		//InnerOne innerOne=new InnerOne(200);
	
		//외부클래스로 생성된 객체를 이용하면 객체 내부클래스의 생성자를 호출하여 객체 생성 가능
		InnerOne innerOne=outerOne.new InnerOne(200);
		innerOne.innerDisplay();
		System.out.println("==============================================================");
	}
}
