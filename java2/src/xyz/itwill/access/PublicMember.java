package xyz.itwill.access;

//public : 클래스, 필드, 생성자, 메소드 작성시 사용 가능한 접근 제한자
// => 클래스, 필드, 생성자, 메소드를 같은 패키지 및 다른 패키지의 클래스에서 사용 가능
//하도록 설정하는 접근 제한자

//소스파일에는 다수의 Java 자료형(클래스, 인터페이스, 열거형) 선언 가능 - 비권장
// => 소스파일에는 public 제한자를 사용한 Java 자료형을 하나만 선언 가능
// => public 제한자를 사용한 Java 자료형의 이름으로 소스파일명을 저장
public class PublicMember {
	public int number;
	
	public void display() {
		System.out.println("number = "+number);
	}
}