package xyz.itwill.lang;

//Wrapper 클래스 : 원시값을 보호하기 위한 클래스를 포괄적으로 표현하기 위한 이름
// => Byte, Short, Integer, Long, Character, Float, Double, Boolean
// => 원시형 대신 Wrapper 클래스로 객체를 생성하여 프로그램 작성

public class WrapperApp {
	public static void main(String[] args) {
		/*
		int num1=100, num2=200;
		int num3=num1+num2;
		System.out.println("합계 = "+num3);
		*/
		
		/*
		//Integer 클래스 : 정수값(int)을 저장하기 위한 클래스
		//Integer.valueOf(Object i) : 매개변수로 전달받은 값이 저장된 Integer 객체를 생성하여 반환하는 정적메소드 
		Integer num1=Integer.valueOf(100);
		//매개변수에 문자열을 전달해도 정수값으로 변환되어 Integer 객체에 저장
		Integer num2=Integer.valueOf("200");
		
		//Integer.intValue() : Integer 객체에 저장된 정수값을 반환하는 메소드
		Integer num3=Integer.valueOf(num1.intValue()+num2.intValue());
		
		System.out.println("합계 = "+num3.intValue());
		*/
		
		//Wrapper 클래스는 오토박싱과 오토언박싱을 이용하여 자동으로 객체를 생성하거나 객체에
		//저장된 값을 자동으로 반환받아 사용할 수 있는 기능 제공
		//오토박싱(AutoBoxing) : 원시값을 자동으로 Wrapper 클래스의 객체로 생성하여 제공하는 기능
		//오토언박싱(AutoUnBoxing) : Wrapper 클래스의 객체에 저장된 원시값을 자동으로 제공하는 기능
		Integer num1=100, num2=200;
		Integer num3=num1+num2;
		System.out.println("합계 = "+num3);
		System.out.println("==============================================================");
		//Integer.valueOf(String s, int radix) : 매개변수로 전달받은 문자열을 원하는 진수의
		//정수값으로 처리하여 Integer 객체에 저장해 반환하는 정적메소드
		// => 매개변수에 진수를 전달하지 않을 경우 문자열을 10진수로 변환하여 처리
		// => 원하는 진수로 표현 불가능한 문자열이 전달된 경우 NumberFormatException 발생
		Integer num=Integer.valueOf("ABC",16);//int num=0xABC;
		System.out.println("num = "+num);
		System.out.println("==============================================================");
		Integer su=50;
		
		System.out.println("su(10진수) = "+su);
		//Integer.toOctalString(int i) : 매개변수로 전달받은 정수값을 8진수 형태의 문자열로 변환하여 반환하는 정적메소드
		System.out.println("su(8진수) = "+Integer.toOctalString(su));
		//Integer.toHexString(int i) : 매개변수로 전달받은 정수값을 16진수 형태의 문자열로 변환하여 반환하는 정적메소드
		System.out.println("su(16진수) = "+Integer.toHexString(su));
		//Integer.toBinaryString(int i) : 매개변수로 전달받은 정수값을 2진수 형태의 문자열로 변환하여 반환하는 정적메소드
		System.out.println("su(2진수) = "+Integer.toBinaryString(su));
		
		su=-50;
		System.out.println("su(2진수) = "+Integer.toBinaryString(su));
		System.out.println("==============================================================");
		String str1="100", str2="200";
		System.out.println("합계 = "+(str1+str2));
		
		//Integer.parseInt(String s) : 매개변수로 전달받은 문자열을 정수값으로 변환하여 반환하는 정적메소드
		// => 매개변수로 전달받은 문자열이 정수값으로 변환할 수 없는 문자열인 경우 NumberFormatException 발생
		System.out.println("합계 = "+(Integer.parseInt(str1)+Integer.parseInt(str2)));
		System.out.println("==============================================================");
	}
}
