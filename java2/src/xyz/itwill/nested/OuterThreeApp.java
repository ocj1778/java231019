package xyz.itwill.nested;

public class OuterThreeApp {
	public static void main(String[] args) {
		OuterThree outerThree=new OuterThree(100);
		outerThree.outerDisplay();
		System.out.println("==============================================================");
		outerThree.local();
		System.out.println("==============================================================");
	}
}
