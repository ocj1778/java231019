package xyz.itwill06.oop;

public class AopApp {
	public static void main(String[] args) {
		AopProxy one=new AopProxy(new AopOne());
		AopProxy two=new AopProxy(new AopTwo());
		
		one.display1();
		one.display2();
		one.display3();
		
		two.display1();
		two.display2();
		two.display3();
	}
}
