package oop;

public class MainArgsApp {
	//main 메소드는 JVM에 의해 자동 호출되는 메소드
	// => main 메소드의 매개변수에는 프로그램 실행시 제공받은 문자열들을 배열로 전달받아 저장
	public static void main(String[] args) {
		//main 메소드의 매개변수에 저장된 배열의 요소 갯수를 출력
		System.out.println("args.length = "+args.length);
		
		//main 메소드의 매개변수에 저장된 배열의 모든 요소값(String 객체 - 문자열)을 출력
		for(int i=0;i<args.length;i++) {
			System.out.println("args["+i+"] = "+args[i]);
		}
	}
}
