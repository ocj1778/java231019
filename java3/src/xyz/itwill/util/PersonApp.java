package xyz.itwill.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PersonApp {
	//메소드의 반환형 또는 매개변수에 제네릭을 사용하여 작성한 경우 메소드 반환형에 앞에 사용할 
	//제네릭을 작성하여 메소드 선언
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		//List 객체의 요소값을 차례대로 제공받아 변수에 저장하여 반복 처리
		for(T t : list) {
			c.accept(t);
		}
		System.out.println();
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		List<T> result=new ArrayList<T>();
		
		for(T t : list) {
			if(predicate.test(t)) {
				result.add(t);
			}
		}
		
		return result;
	}
 	
	public static void main(String[] args) {
		forEach(Arrays.asList("홍길동","임꺽정","전우치"), str -> System.out.println(str+" "));

		//List.of(E... element) : 매개변수로 전달받은 0개 이상의 객체가 저장된 List 객체를
		//반환하는 정적메소드
		forEach(List.of(100, 200, 300), num -> System.out.print(num+" "));
		System.out.println("==============================================================");
		List<Person> personList=new ArrayList<Person>();
		personList.add(new Person("홍길동", 29));
		personList.add(new Person("임꺽정", 35));
		personList.add(new Person("전우치", 50));
		
		System.out.println(personList);
		System.out.println("==============================================================");
		List<Person> thirtyList=filter(personList, person -> person.getAge() >= 30);
		
		System.out.println(thirtyList);
		System.out.println("==============================================================");
	}
}
