package xyz.itwill.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//List 인터페이스를 상속받은 콜레션 클래스 - ArrayList 클래스, Vector 클래스, LinkedList 클래스 등
// => 요소의 순서가 존재하며 요소에 메모리 주소와 필드값이 같은 동일한 객체(값) 저장 가능
// => List 객체의 요소는 첨자를 사용하여 구분
// => List 객체에 저장된 요소값이 많은 경우 검색하는 속도가 느려진다는 단점이 존재
public class ListApp {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		//List.add(E element) : List 객체의 요소에 객체(값)을 추가하여 저장하는 메소드
		// => List 객체의 요소에 차례대로 객체(값) 저장
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
		//List.add(int index, E element) : List 객체에서 index 위치의 요소에 객체(값)을 삽입
		//하여 저장하는 메소드
		list.add(4, "장길산");
		System.out.println("list = "+list);
		System.out.println("==============================================================");
		//List.remove(E element) : 매개변수로 전달받은 객체와 동일한 객체가 저장된 요소를
		//List 객체에서 삭제하는 메소드
		// => 동일한 객체가 List 객체에 여러개 저장되어 있는 경우 첫번째 요소 삭제
		//list.remove("임꺽정");
		
		//List.remove(int index) : 매개변수로 전달받은 첨자 위치의 요소를 List 객체에서 삭제하는 메소드
		list.remove(5);
		System.out.println("list = "+list);
		System.out.println("==============================================================");
		//List.set(int index, E element) :  List 객체에서 index 위치의 요소에 저장된 객체(값)을
		//변경하는 메소드
		list.set(1, "임걱정");
		System.out.println("list = "+list);
		System.out.println("==============================================================");
		//List 객체의 모든 요소에 대한 일괄처리 - 일반 for 구문 사용
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println("==============================================================");
		//List.iterator() : List 객체의 모든 요소를 반복 처리할 수 있는 Iterator 객체를 반환하는 메소드 
		Iterator<String> iterator=list.iterator();

		//List 객체의 모든 요소에 대한 일괄처리 - Iterator 객체 사용
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		System.out.println("==============================================================");
		//List 객체의 모든 요소에 대한 일괄처리 - 향상된 for 구문 사용
		for(String str : list) {
			System.out.print(str+" ");
		}
		System.out.println();
		System.out.println("==============================================================");
		//Collections 클래스 : 콜렉션 객체의 요소를 처리하기 위한 기능을 메소드로 제공하는 클래스
		//Collections.sort(List list) : 매개변수로 전달받은 List 객체에 저장된 모든 요소값을
		//비교하여 오름차순 정렬하기 위한 정적메소드
		// => List 객체에 저장된 요소값(객체)를 정렬하기 위해 객체의 클래스는 반드시 Comparable
		//인터페이스를 상속받아 compareTo() 메소드를 오버라이드 선언하여 객체 필드값을 비교해 
		//정렬될 수 있도록 처리
		Collections.sort(list);
		System.out.println("list = "+list);
		System.out.println("==============================================================");
		//List.clear() : List 객체에 저장된 모든 요소값을 삭제하는 메소드
		list.clear();
		//System.out.println("list = "+list);
		
		//List.isEmpty() : List 객체에 저장된 요소값이 있는 경우 [flase]를 반환하고 요소값이
		//하나도 없는 경우 [true]를 반환하는 메소드
		if(list.isEmpty()) {//if(list.size() == 0) 명령과 동일
			System.out.println("List 객체에 저장된 요소값이 하나도 없습니다.");
		}
		System.out.println("==============================================================");
		//Arrays.asList(E ... element) : 매개변수로 0개 이상의 객체를 전달받아 List 객체의
		//요소값으로 저장하여 반환하는 메소드 - 배열(Array) >> List 객체
		List<Integer> numberList=Arrays.asList(10, 20, 30, 40, 50);
		System.out.println("numberList = "+numberList);		
		System.out.println("==============================================================");
	}
}
