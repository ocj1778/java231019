package xyz.itwill.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
		// => HashSet 객체의 모든 요소의 자료형이 Object 클래스로 선언되어 모든 클래스의 객체를
		//전달받아 저장 가능
		// => HashSet 객체의 요소에 저장된 객체를 반환받아 사용할 경우 반드시 명시적 객체 형변환 이용
		//HashSet set=new HashSet();
		
		//new 연산자로 HashSet 클래스의 기본 생성자를 호출하여 객체 생성
		// => 제네릭에 Java 자료형을 전달하여 HashSet 객체 생성 - 권장
		// => HashSet 객체의 모든 요소의 자료형이 제네릭 대신 사용될 클래스로 선언되어 클래스의
		//객체만 전달받아 저장 가능
		// => HashSet 객체의 요소에 저장된 객체를 반환받아 명시적 객체 형변환 없이 사용 가능
		//HashSet<String> set=new HashSet<String>();
		
		//참조변수는 자식클래스가 상속받은 클래스 또는 인터페이스를 이용하여 선언하는 것을 권장
		// => 부모 참조변수에는 모든 자식클래스의 객체 저장 가능
		// => 클래스간의 결합도를 낮추어 유지보수의 효율성 증가
		Set<String> set=new HashSet<String>();
		
		//Set.add(E element) : Set 객체에 요소값을 추가하여 저장하는 메소드 - 저장 순서 미제공
		//요소(Element) : 콜렉션 클래스의 객체에 제네릭 타입 대신 전달되어 저장된 클래스의 객체
		set.add("홍길동");
		//set.add(12.34);//제네릭 대신 사용될 클래스의 객체가 아닌 다른 객체를 전달할 경우 에러 발생
		set.add("임꺽정");
		set.add("전우치");
		
		//Set.toString() : Set 객체에 저장된 모든 요소값(객체)을 문자열로 변환하여 반환하는 메소드
		//System.out.println("set.toString() = "+set.toString());
		System.out.println("set = "+set);
		System.out.println("==============================================================");
		//Set 객체의 요소에는 객체의 메모리 주소(HashCode)와 필드값(Value)이 같은 동일한 객체
		//중복 저장 미허용
		set.add("홍길동");
		System.out.println("set = "+set);
		System.out.println("==============================================================");
		//Set.toString() : Set 객체에 값(객체)가 저장된 요소의 갯수를 반환하는 메소드 
		System.out.println("set.size() = "+set.size());
		System.out.println("==============================================================");
		//Set.remove(E Element) : 매개변수로 전달받은 객체와 동일한 요소값(객체)을 Set 
		//객체에서 삭제하는 메소드 
		set.remove("임꺽정");
		System.out.println("set = "+set);
		System.out.println("==============================================================");
		//Set.iterator() : Set 객체에 저장된 요소값을 반복 처리할 수 있는 Iterator 객체를 반환하는 메소드
		//Iterator 객체 : 콜렉션 클래스의 객체에 저장된 요소를 반복 처리하기 위한 기능을 제공하는 객체
		// => 반복 지시자 : 내부의 커서(Cursor)를 사용하여 콜렉션 객체의 요소 반복 처리
		// => 제네릭에 Java 자료형을 전달하여 Iterator 객체 생성
		Iterator<String> iterator=set.iterator();
		
		//Iterator 객체를 사용하여 Set 객체에 저장된 모든 요소값(객체)에 대한 일괄 처리
		//Iterator.hasNext() : Iterator 객체로 처리 가능한 요소값의 존재 유무를 반환하는 메소드
		// => false : 처리할 요소값 미존재, true : 처리할 요소값 존재
		while (iterator.hasNext()) {//Iterator 객체가 처리할 요소값이 있는 경우 반복 처리 
			//Iterator.next() : Iterator 객체가 처리할 요소값(객체)를 반환하는 메소드
			// => 제네릭을 사용했으므로 명시적 객체 형변환 불필요
			String str = iterator.next();
			System.out.println(str);
		}
		System.out.println("==============================================================");
		//향상된 for 구문을 사용하면 Set 객체에 저장된 모든 요소값(객체)을 차례대로 제공받아
		//참조변수에 저장하여 일괄처리 가능
		// => 향상된 for 구문을 사용하여 내부적으로 Iterator 객체를 사용하여 반복 처리
		for(String str :  set) {
			System.out.println(str);
		}
		System.out.println("==============================================================");
	}
}
