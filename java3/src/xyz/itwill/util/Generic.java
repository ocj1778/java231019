package xyz.itwill.util;

//제네릭(Generic) : 필드의 자료형이 부정확한 경우 Java 자료형 대신 사용될 식별자 - 미지정 자료형
// => Java 자료형(클래스, 인터페이스) 선언시 < > 기호에 제네릭 타입(식별자) 선언
//형식) public class 클래스명<제네릭, 제네릭, ...> { }
// => Java 자료형(클래스, 인터페이스) 선언시 < > 기호 안에 , 기호를 사용하여 다수의 제네릭 타입 선언 가능
// => 제네릭 타입의 식별자는 대문자로 작성하는 것을 권장

//제네릭을 사용하여 선언된 클래스 - 제네릭 클래스(Generic Class)
// => 제네릭 타입으로 전달될 Java 자료형을 상속 기능을 사용하여 제한 가능
//형식) public class 클래스명<제네릭 extends 부모클래스, ...> { }
// => 제네릭 타입으로 전달될 Java 자료형에는 부모클래스를 상속받은 자식클래스만 전달받아 사용 가능

//public class Generic<T> {
public class Generic<T extends Number> {
	private T field;
	
	public Generic() {
		// TODO Auto-generated constructor stub
	}

	public Generic(T field) {
		super();
		this.field = field;
	}

	public T getField() {
		return field;
	}

	public void setField(T field) {
		this.field = field;
	}
}
