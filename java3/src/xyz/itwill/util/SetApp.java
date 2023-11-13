package xyz.itwill.util;

import java.util.HashSet;

//콜렉션 클래스(Collection Class) : 자료구조(Data Structure)를 사용하여 다수의 객체(값)를 
//효율적으로 관리(추가, 변경, 삭제, 검색)하기 위한 기능을 제공하는 객체 수집 클래스를 
//포괄적으로 표현한 이름

//Set 인터페이스를 상속받은 콜렉션 클래스 - HashSet 클래스, TreeSet 클래스 등
// => 객체의 저장 순서가 없으며 메모리 주소(HashCode)와 객체에 저장된 값(Value)이 같은 객체가  
//중복 저장되지 않도록 하는 기능을 제공 
public class SetApp {
	public static void main(String[] args) {
		//new 연산자로 HashSet 클래스의 기본 생성자를 호출하여 객체 생성
		// => 제네릭을 사용하지 않고 HashSet 객체 생성 - 비권장
		
		HashSet set=new HashSet();

	}
}
