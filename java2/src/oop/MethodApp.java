package oop;

//실행의 목적으로 작성된 클래스
public class MethodApp {
	//JVM(Java Virtual Machine)에 의해 자동으로 호출되는 메소드
	// => 프로그램이 시작되는 위치
	public static void main(String[] args) {
		//클래스로 객체를 생성하여 객체의 메모리 주소를 참조변수에 저장
		// => 같은 패키지에 작성된 클래스는 패키지를 표현하지 않아도 클래스 사용 가능
		Method method=new Method();
		
		//참조변수를 출력할 경우 "자료형@메모리주소" 형식의 문자열을 제공받아 출력
		System.out.println("method = "+method);
		System.out.println("==============================================================");
		//참조변수에 저장된 메모리 주소로 객체를 참조하여 객체의 메소드 호출
		// => 메소드를 호출하면 프로그램의 흐름(스레드)이 객체의 메소드로 이동하여 메소드의
		//명령을 실행하고 메소드가 종료되는 다시 되돌아와 다음 명령 실행
		method.displayOne();
		method.displayTwo();
		method.displayOne();
		System.out.println("==============================================================");
		method.printOne();
		method.printOne();
		System.out.println("==============================================================");
		method.printTwo(50);
		method.printTwo(80);
		method.printTwo(-30);
		System.out.println("==============================================================");
		method.printThree(35, 79);
		method.printThree(19, 88);
		method.printThree(67, 12);
		System.out.println("==============================================================");
		//객체의 메소드를 호출하여 반환되는 값을 제공받아 변수에 저장
		int sum=method.returnTotal(30, 70);
		System.out.println("합계 = "+sum);
		//객체의 메소드를 호출하여 반환되는 값을 제공받아 출력 처리
		System.out.println("합계 = "+method.returnTotal(20, 80));
		System.out.println("==============================================================");
		boolean result=method.isOddEven(10);
		//조건식 대신 boolean 변수에 저장된 논리값을 사용하여 명령 선택 실행 
		if(result) {
			System.out.println("매개변수로 전달된 값은 [짝수]입니다.");
		} else {
			System.out.println("매개변수로 전달된 값은 [홀수]입니다.");
		}
		
		//조건식 대신 메소드의 반환값(논리값)을 사용하여 명령 선택 실행 
		if (method.isOddEven(11)) {
			System.out.println("매개변수로 전달된 값은 [짝수]입니다.");
		} else {
			System.out.println("매개변수로 전달된 값은 [홀수]입니다.");
		}
		System.out.println("==============================================================");
		/*
		//메소드를 호출하여 반환되는 배열의 메모리 주소를 참조변수에 저장 
		// => 참조변수에 저장된 메모리 주소를 이용하여 배열 참조
		int[] numArray=method.returnArray();//배열을 반환받아 저장
		for(int number : numArray) {
			System.out.print(number+" ");
		}
		System.out.println();
		*/
		
		for(int number : method.returnArray()) {
			System.out.print(number+" ");
		}
		System.out.println();
		System.out.println("==============================================================");
		/*
		int[] suArray={10, 20, 30};
		//매개변수에 배열을 전달하여 메소드 호출 - 반환값(모든 요소값의 합계)을 제공받아 출력
		System.out.println("합계 = "+method.sumOne(suArray));
		*/
		
		//배열을 생성하여 매개변수에 배열을 전달하여 메소드 호출
		//System.out.println("합계 = "+method.sumOne({10, 20, 30}));//에러 발생
		System.out.println("합계 = "+method.sumOne(new int[]{10, 20, 30}));
		//배열에는 요소값을 0개 이상 저장하여 전달해 메소드 호출 가능 
		System.out.println("합계 = "+method.sumOne(new int[]{}));
		System.out.println("합계 = "+method.sumOne(new int[]{10, 20}));
		System.out.println("합계 = "+method.sumOne(new int[]{10, 20, 30, 40, 50}));
		System.out.println("==============================================================");
		//메소드 호출시 모든 전달값이 매개변수에 전달되어 저장
		System.out.println("합계 = "+method.sumTwo(10, 20, 30));
		System.out.println("합계 = "+method.sumTwo());
		System.out.println("합계 = "+method.sumTwo(10, 20));
		System.out.println("합계 = "+method.sumTwo(10, 20, 30, 40, 50));
		System.out.println("==============================================================");
	}
}
