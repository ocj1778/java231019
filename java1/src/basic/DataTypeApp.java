package basic;

//기본형(PrimitiveType) : 기본값을 표현하거나 변수를 선언하기 위한 자료형(키워드)
// => 숫자형(정수형, 실수형, 문자형), 논리형
public class DataTypeApp {
	public static void main(String[] args) {
		//정수형(IntegerType) 리터럴 - 소숫점이 없는 숫자값
		// => Java 프로그램에 정수형 리터럴은 기본적으로 4Byte(-2147483648~2147483647)로 표현
		System.out.println("<<정수형(IntegerType)>>");
		System.out.println("정수값(10진수 100) = "+100);//숫자값 - 10진수 정수형 리터럴
		//println() 메소드는 정수값을 무조건 10진수로 변환하여 출력
		System.out.println("정수값(8진수 100) = "+0100);//0숫자값 - 8진수 정수형 리터럴
		System.out.println("정수값(16진수 100) = "+0x100);//0x숫자값 - 16진수 정수형 리터럴
		System.out.println("정수값(10진수 100) = "+100L);//숫자값L - 10진수 정수형 리터럴(8Byte - LongType)
		
		System.out.println("정수값 = "+2147483647);
		//4Byte로 불가능한 정수값을 사용할 경우 에러 발생
		//System.out.println("정수값 = "+2147483648);
		//4Byte로 불가능한 정수값을 사용할 경우 LongType의 정수형 리터럴로 표현하여 사용
		System.out.println("정수값 = "+2147483648L);
		
		//정수값을 표현하기 위한 자료형(키워드)
		// => byte(1Byte), short(2Byte), int(4Byte), long(8Byte)
		byte a1=127;//1Byte : -128~127
		short a2=32767;//2Byte : -32768~32767
		int a3=2147483647;//4Byte : -2147483648~2147483647
		long a4=2147483648L;//8Byte
		
		System.out.println("a1 = "+a1);
		System.out.println("a2 = "+a2);
		System.out.println("a3 = "+a3);
		System.out.println("a4 = "+a4);
		
		//int a5=100L;//값에 대한 손실이 발생할 수 있으므로 에러 발생
		long a5=100;//자료형이 큰 변수에는 자료형이 작은 리터럴 저장 가능
		System.out.println("a5 = "+a5);
		System.out.println("==============================================================");
	}
}
