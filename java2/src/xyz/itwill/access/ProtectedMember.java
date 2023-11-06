package xyz.itwill.access;

//protected : 필드, 생성자, 메소드 작성시 사용 가능한 접근 제한자
// => 필드, 생성자, 메소드를 같은 패키지의 클래스에서만 사용 가능하도록 설정하는 접근 제한자
// => 필드, 생성자, 메소드를 다른 패키지의 클래스에서 사용할 경우 에러가 발생하지만 클래스를
//상속받을 경우 사용 가능
public class ProtectedMember {
	protected int number;
	
	protected void display() {
		System.out.println("number = "+number);
	}
}
