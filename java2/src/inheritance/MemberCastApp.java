package inheritance;

//상속관계의 클래스에서 참조변수와 객체와의 관계
public class MemberCastApp {
	public static void main(String[] args) {
		//부모클래스 참조변수=new 부모클래스();
		// => 부모클래스의 생성자로 객체를 생성하여 부모클래스의 참조변수에 저장 - 가능
		Member member1=new Member();
		
		//참조변수에 저장된 부모 객체를 사용하여 부모클래스의 메소드 호출
		member1.setId("abc123");
		member1.setName("홍길동");
		
		member1.display();
		System.out.println("==============================================================");
	}
}
