package xyz.itwill.util;

import java.util.HashSet;
import java.util.Set;

public class UserVOApp {
	public static void main(String[] args) {
		Set<UserVO> set=new HashSet<UserVO>();
		
		set.add(new UserVO("abc123", "홍길동", "abc@itwill.xyz"));
		set.add(new UserVO("opq456", "임꺽정", "opq@itwill.xyz"));
		set.add(new UserVO("xyz789", "전우치", "xyz@itwill.xyz"));
		
		System.out.println("set = "+set);
		
		//UserVO 클래스에 equals() 메소드와 hashCode() 메소드를 오버라이드 하지 않은 경우
		//객체의 필드값은 같아도 객체가 다르므로 Set 객체의 요소값으로 저장 가능
		// => UserVO 클래스에 equals() 메소드와 hashCode() 메소드를 오버라이드 선언하면
		//Set 객체의 메소드 호출시 equals() 메소드와 hashCode() 메소드가 자동 호출되어
		//필드값과 메모리 주소(HashCode)가 같은 객체를 Set 객체의 요소값으로 저장 불가
		set.add(new UserVO("abc123", "홍길동", "abc@itwill.xyz"));

		System.out.println("set = "+set);
	}
}
