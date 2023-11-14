package xyz.itwill.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Map 인터페이스를 상속받은 콜렉션 클래스 - HashMap 클래스, Hashtable 클래스, Properties 클래스 등
// => 이름(Key - 고유값)과 값(Value - 객체)을 하나로 그룹으로 묶어 Map 객체에 저장하여 관리
// => 엔트리(Entry) : 이름과 값을 하나의 그룹으로 묶어 처리하기 위한 단위
// => 이름(Key)을 이용하여 값(Value)을 빠르게 검색하여 제공하기 위한 콜렉션 클래스
public class MapApp {
	public static void main(String[] args) {
		//이름(K)과 값(V)에 대한 제네릭에 Java 자료형을 전달하여 객체 생성
		Map<Integer, String> map=new HashMap<Integer, String>();
		
		//Map.put(K key, V value) : 매개변수로 전달받은 이름과 값이 저장된 엔트리를 Map 객체에 추가하는 메소드
		// => Map 객체에 저장되는 엔트리의 이름(Key)은 Set 객체 형태로 저장되므로 동일한
		//이름(객체)의 엔트리는 중복 저장 불가
		map.put(1000, "홍길동");
		map.put(2000, "임꺽정");
		map.put(3000, "전우치");
		map.put(4000, "일지매");
		map.put(5000, "장길산");
		
		//Map.toString() : Map 객체에 저장된 모든 엔트리를 문자열로 변환하여 반환하는 메소드
		System.out.println("map = "+map);
		System.out.println("===============================================================");
		//Map 객체로 put() 메소드를 호출하여 엔트리를 추가할 때 매개변수로 전달받은 이름이
		//기존 엔트리의 이름과 동일한 경우 매개변수로 전달받은 값으로 엔트리의 값을 변경 처리
		map.put(2000, "임걱정");
		System.out.println("map = "+map);
		System.out.println("===============================================================");
		//Map.remove(K key) : 매개변수로 전달받은 이름의 엔트리를 Map 객체에서 삭제하는 메소드
		map.remove(4000);
		System.out.println("map = "+map);
		System.out.println("===============================================================");
		//Map.get(K key) : Map 객체에서 매개변수로 전달받은 이름의 엔트리를 검색하여 엔트리의
		//값(객체)를 반환하는 메소드
		// => 매개변수로 전달받은 이름의 엔트리가 Map 객체에 없는 경우 null 반환
		String name=map.get(1000);
		System.out.println("name = "+name);
		System.out.println("===============================================================");
		//Map.keySet() : Map 객체에 저장된 모든 엔트리의 이름(Key)이 저장된 Set 객체를 반환하는 메소드
		Iterator<Integer> iteratorKey=map.keySet().iterator();
		
		while (iteratorKey.hasNext()) {
			Integer key = iteratorKey.next();
			String value = map.get(key);
			System.out.println(key+" = "+value);
		}
		System.out.println("===============================================================");
		for(Integer key : map.keySet()) {
			System.out.println(key+" = "+map.get(key));
		}
		System.out.println("===============================================================");
		//Map.values() : Map 객체에 저장된 모든 엔트리의 값(Value)이 저장된 Collection 객체
		//(List 객체)를 반환하는 메소드
		Iterator<String> iteratorValue=map.values().iterator();
		while (iteratorValue.hasNext()) {
			String value = iteratorValue.next();
			System.out.println(value);
		}
		System.out.println("===============================================================");
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("===============================================================");	
	}
}
