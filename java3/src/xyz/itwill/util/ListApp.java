package xyz.itwill.util;

import java.util.ArrayList;
import java.util.List;

//List 인터페이스를 상속받은 콜레션 클래스 - ArrayList 클래스, Vector 클래스, LinkedList 클래스 등
// => 요소의 순서가 존재하며 요소에 메모리 주소와 필드값이 같은 객체(값) 저장 가능
// => List 객체의 요소는 첨자를 사용하여 구분
// => List 객체에 저장된 요소값이 많은 경우 검색하는 속도가 느려진다는 단점이 존재
public class ListApp {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		//List.add(E element) : List 객체의 요소에 객체(값)을 추가하여 저장하는 메소드
		// => List 객체의 요소에 차례대로 저장
		list.add("홍길동");
		list.add("임꺽정");
		list.add("전우치");
		list.add("일지매");
		
		//List.toString() : List 객체의 모든 요소값을 문자열로 변환하여 반환하는 메소드
		// => 참조변수를 출력할 경우 자동으로 toString() 메소드 호출
		System.out.println("list = "+list);
		System.out.println("==============================================================");
		//List 객체의 요소에는 동일한 객체 저장 가능
		list.add("임꺽정");
		System.out.println("list = "+list);
		System.out.println("==============================================================");
		//List.size() : List 객체에 저장된 모든 요소값의 갯수를 반환하는 메소드
		System.out.println("list.size() = "+list.size());
		System.out.println("==============================================================");
		//List.get(int index) : List 객체에 저장된 요소값 중 매개변수로 전달받은 첨자 위치의
		//요소값을 반환하는 메소드
		// => 매개변수로 전달받은 첨자가 범위를 벗어난 경우 IndexOutOfBoundsException 발생
		System.out.println("list.get(2) = "+list.get(2));
		//System.out.println("list.get(10) = "+list.get(10));
		System.out.println("==============================================================");
		
		
	}
}













