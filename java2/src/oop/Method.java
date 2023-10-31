package oop;

//메소드(Method) : 클래스 내부에 선언한 함수 - 멤버함수
// => 필드(멤버변수)를 사용하여 필요한 기능을 제공하기 위한 명령의 모임 
// => 메소드 내부에서만 Java 명령을 작성하여 실행

//함수(Function) : 매개변수로 값을 제공받아 연산 처리하여 결과를 반환하는 명령의 모임

//메소드 선언 방법
//형식) 반환형 메소드명(자료형 변수명, 자료형 변수명,...) {
//             명령;
//             ...
//      }
// => 메소드를 호출(Invoke)해야 메소드 내부에 작성된 명령 실행 - 기능 구현

//반환형(ReturnType) : 메소드를 호출하여 얻을 수 있는 결과값에 대한 자료형 
// => void 자료형(무반환형) : 메소드를 호출하여 얻을 수 있는 결과값이 없는 경우에 사용하는 자료형 

//메소드명은 식별자로 카멜 표기법을 사용하여 작성

//메소드의 () 기호 안에는 변수를 , 기호로 나열 선언 - 매개변수(Parameter - Argument)
// => 메소드 내부에 작성된 명령을 실행하기 위해 필요한 값을 메소드 호출시 전달받아 저장하기 위한 변수
// => 메소드 내부에 작성된 명령을 실행하기 위한 값이 필요없는 경우 매개변수 작성 생략

//메소드 호출(Invoke) : 메소드에 작성된 명령을 실행하여 필요한 기능 구현
//형식) 객체.메소드명(값, 값, ...);
// => 참조변수로 객체를 참조하여 객체의 메소드 호출
// => 메소드 호출시 매개변수에 차례대로 값을 전달하여 저장해야만 메소드 호출
// => 매개변수에 값이 정상적으로 전달되지 않은 경우 메소드 호출 불가능 - 에러 발생

//return : 메소드를 강제로 종료하여 프로그램의 흐름(스레드)을 메소드를 호출한 위치로 되돌리는 키워드
// => 일반적으로 if 구문과 같이 사용
//형식) if(조건식) return;  => 메소드의 반환형을 [void]로 작성
//return 키워드를 사용하여 메소드의 처리 결과값을 메소드를 호출한 위치로 반환하는 기능 제공
//형식) return 반환값; => 메소드의 반환형은 반환되는 값의 자료형으로 작성

//객체 생성을 목적으로 작성된 클래스
public class Method {
	void displayOne() {
		System.out.println("Method 클래스에 선언된 displayOne() 메소드 호출");
	}
	
	void displayTwo() {
		System.out.println("Method 클래스에 선언된 displayTwo() 메소드 호출");
	}
	
	void printOne() {
		int total=0;
		for(int i=1;i<=100;i++) {
			total+=i;	
		}
		System.out.println("1~100 범위의 정수들의 합계 = "+total);
	}
	
	void printTwo(int number) {
		//매개변수에 저장된 값에 대한 검증
		if(number <= 0) {
			System.out.println("[에러]매개변수에는 0보다 큰 값이 저장되어야 됩니다.");
			return;//메소드 강제 종료
		}
		
		int total=0;
		for(int i=1;i<=number;i++) {
			total+=i;	
		}
		System.out.println("1~"+number+" 범위의 정수들의 합계 = "+total);
	}
	
	void printThree(int start, int end) {
		if(start > end) {
			int temp=start;
			start=end;
			end=temp;
		}
		 
		int total=0;
		for(int i=start;i<=end;i++) {
			total+=i;	
		}
		System.out.println(start+"~"+end+" 범위의 정수들의 합계 = "+total);
	}
	
	int returnTotal(int start, int end) {
		if(start > end) {
			int temp=start;
			start=end;
			end=temp;
		}
		 
		int total=0;
		for(int i=start;i<=end;i++) {
			total+=i;	
		}
		
		return total;
	}
	
	//매개변수로 전달받은 정수값을 홀수와 짝수로 구분하여 반환하는 메소드
	// => false 반환 : 홀수, true 반환 : 짝수
	boolean isOddEven(int number) {
		if(number % 2 != 0) {
			return false;
		} else {
			return true;
		}
	}
	
	//배열을 반환하는 메소드
	int[] returnArray() {
		/*
		int[] array={10, 20, 30, 40, 50};
		return array;//참조변수에 저장된 배열의 메모리 주소 반환 - 배열 반환
		*/
		
		//배열을 참조변수에 저장하지 않고 배열을 생성하여 반환
		//return {10, 20, 30, 40, 50};//에러 발생
		return new int[]{10, 20, 30, 40, 50};
	}
	
	//매개변수로 배열을 전달받아 모든 배열 요소값의 합계를 계산하여 반환하는 메소드
	int sumOne(int[] array) {//배열의 메모리 주소를 전달받아 매개변수(참조변수)에 저장
		int total=0;
		for(int su : array) {
			total += su;
		}
		return total;
	}
	
	//매개변수 생략 기호(...)를 이용해 매개변수를 작성하여 0개 이상의 값을 전달받아 합계를
	//계산하여 반환하는 메소드
	// => 0개 이상의 값을 전달받아 저장한 매개변수는 메소드 내부에서는 배열과 동일하게 처리
	int sumTwo(int... number) {
		int total=0;
		for(int su : number) {
			total += su;
		}
		return total;
	}
	
}
