package xyz.itwill.access;

//package(default) : 클래스, 필드, 생성자, 메소드 작성시 사용 가능한 접근 제한자
// => 클래스, 필드, 생성자, 메소드 작성시 접근 제한자 관련 키워드를 사용하지 않으면 자동으로
//package 접근 제한자로 처리
// => 클래스, 필드, 생성자, 메소드를 같은 패키지의 클래스에서만 사용 가능하도록 설정하는 접근 제한자
// => 클래스, 필드, 생성자, 메소드를 다른 패키지의 클래스에서 사용할 경우 에러 발생
public class PackageMember {
	int number;
	
	void display() {
		System.out.println("number = "+number);
	}
}