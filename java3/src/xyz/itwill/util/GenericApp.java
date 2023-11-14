package xyz.itwill.util;

//제네릭 타입으로 필드가 선언된 클래스로 객체를 생성해 사용
// => 제네릭 타입 대신 사용될 Java 자료형의 객체만 필드에 저장 가능 - 제한적인 객체 저장
// => 명시적 객체 형변환 없이 필드값(객체)을 반환받아 사용 가능
public class GenericApp {
	public static void main(String[] args) {
		//제네릭 타입 대신 사용될 Java 자료형을 전달해야만 제네릭 클래스 사용 가능
		// => 제네릭 타입 대신 사용될 Java 자료형으로 필드 또는 메소드 완성
		//Generic<Integer> generic1=new Generic<Integer>();//필드의 자료형 : Integer
		Generic<Integer> generic1=new Generic<>();//생성자의 제네릭 타입의 자료형 생략 가능
		
		//Integer 클래스의 매개변수에 Integer 객체를 전달하여 Generic 객체의 필드값 변경
		generic1.setField(100);
		//제네릭 타입 대신 사용될 Java 자료형과 다른 자료형의 객체를 사용할 경우 에러 발생
		//generic1.setField(12.34);

		//Integer 클래스의 매개변수에 저장된 Integer 객체를 반환받아 저장 - 명시적 객체 형변환 불필요
		Integer returnObject1=generic1.getField();
		
		//System.out.println("필드값 = "+returnObject1.intValue());
		System.out.println("필드값 = "+returnObject1);
		System.out.println("==============================================================");
		Generic<Double> generic2=new Generic<Double>();//필드의 자료형 : Double
		
		//Double 클래스의 매개변수에 Double 객체를 전달하여 Generic 객체의 필드값 변경
		generic2.setField(12.34);
		
		Double returnObject2=generic2.getField();
		
		System.out.println("필드값 = "+returnObject2);
		System.out.println("==============================================================");
		//String 클래스는 Number 클래스를 상속받지 않아 제네릭 타입으로 전달 불가능
		/*
		Generic<String> generic3=new Generic<String>();//필드의 자료형 : String
		
		//String 클래스의 매개변수에 String 객체를 전달하여 Generic 객체의 필드값 변경
		generic3.setField("홍길동");
		
		String returnObject3=generic3.getField();
		
		System.out.println("필드값 = "+returnObject3);
		*/
		System.out.println("==============================================================");
	}
}