package xyz.itwill05.lombok;

public class MemberApp {
	public static void main(String[] args) {
		Member member1=new Member("abc123", "홍길동", "abc@itwill.xyz");
		
		System.out.println("아이디 = "+member1.getId());
		System.out.println("이름 = "+member1.getName());
		System.out.println("이메일 = "+member1.getEmail());
		System.out.println("==============================================================");
		//Member 객체가 저장된 참조변수를 출력할 경우 자동으로 Member 클래스의 toString() 메소드 호출
		// => Lombok 라이브러리에 의해 제공된 toString() 메소드는 모든 필드값을 문자열로 결합하여 반환
		System.out.println(member1);
		System.out.println("==============================================================");
		//클래스.builder() : 클래스 내부에 선언된 Builder 클래스(내부 정적 클래스)를 객체로 
		//생성하여 반환하는 정적 메소드
		// => Builder 클래스의 필드명과 같은 이름의 메소드를 Builder 객체로 호출하여 필드값이
		//변경된 Builder 객체 반환
		//Builder.build() : 외부 클래스의 객체를 생성하여 Builder 객체에 저장된 필드값으로
		//필드 초기화 처리된 외부 클래스의 객체를 반환하는 메소드
		Member member2=Member.builder()
				.id("xyz789")
				.name("임꺽정")
				.email("xyz@itwill.xyz")
				.build();
		
		System.out.println(member2);
		System.out.println("==============================================================");
	}
}










