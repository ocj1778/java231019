package basic;

//컴퓨터로부터 난수값을 제공받아 출력하는 프로그램 작성
// => 난수값 : 불규칙적으로 발생되는 숫자값
public class MathRandomApp {
	public static void main(String[] args) {
		//Math 클래스 : 수학 관련 기능을 제공하는 클래스
		//Math.random() : 0.0 보다 크거나 같고 1.0 보다 작은 실수 난수값을 생성하여 반환하는 메소드
		// => 0.0 <= 난수값 < 1.0
		for(int i=1;i<=5;i++) {
			System.out.println(i+"번째 실수 난수값 = "+Math.random());
		}
		System.out.println("==============================================================");
		for(int i=1;i<=5;i++) {
			//(int)(Math.random()*100) >> 0 <= 난수값 < 100 = 0 ~ 99 
			System.out.println(i+"번째 실수 난수값 = "+(int)(Math.random()*100));
		}
		System.out.println("==============================================================");
		for(int i=1;i<=5;i++) {
			//(int)(Math.random()*45)+1 >> 1 <= 난수값 < 46 = 1 ~ 45 
			System.out.println(i+"번째 실수 난수값 = "+((int)(Math.random()*45)+1));
		}
		System.out.println("==============================================================");
	}
}
