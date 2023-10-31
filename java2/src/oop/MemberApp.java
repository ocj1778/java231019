package oop;

public class MemberApp {
	public static void main(String[] args) {
		//new 연산자로 Member 클래스의 매개변수가 없는 기본 생성자를 호출하여 객체 생성
		// => 생성된 객체 필드에는 기본값이 초기값으로 자동 저장
		Member member1=new Member();
		
		//필드의 Getter 메소드를 호출하여 Member 객체의 필드값을 반환받아 출력
		System.out.println("아이디 = "+member1.getId());
		System.out.println("이름 = "+member1.getName());
		System.out.println("이메일 = "+member1.getEmail());
		System.out.println("==============================================================");
		//필드의 Setter 메소드를 호출하여 Member 객체의 필드값 변경
		member1.setId("abc123");
		member1.setName("홍길동");
		member1.setEmail("abc@itwill.xyz");
		
		/*
		System.out.println("아이디 = "+member1.getId());
		System.out.println("이름 = "+member1.getName());
		System.out.println("이메일 = "+member1.getEmail());
		*/
		member1.display();
		System.out.println("==============================================================");
		//new 연산자로 Member 클래스의 매개변수가 있는 생성자를 호출하여 객체 생성
		// => 매개변수로 전달된 값의 객체 필드에 초기값으로 저장
		Member member2=new Member("def456");
		member2.display();
		System.out.println("==============================================================");
		Member member3=new Member("ghi789", "임꺽정");
		member3.display();
		System.out.println("==============================================================");
		Member member4=new Member("xyz789", "전우치", "xyz@itwill.xyz");
		member4.display();
		System.out.println("==============================================================");
	}
}
