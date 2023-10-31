package oop;

//회원정보(아이디, 이름, 이메일)를 저장하기 위한 클래스
// => VO(Value Object) 클래스 : 특정 대상의 값을 저장할 목적의 객체를 생성하기 위한 클래스
public class Member {
	//필드(Field) : 객체의 속성값을 저장하기 위한 클래스의 요소
	private String id;
	private String name;
	private String email;
		
	//생성자(Constructor) : 객체를 생성하기 위한 특별한 메소드
	// => 생성자를 작성하지 않으면 매개변수가 없는 기본 생성자를 자동으로 생성하여 제공
	// => 생성자를 작성하면 매개변수가 없는 기본 생성자는 미제공
	
	//메소드(Method) : 명령을 실행하여 객체의 기능을 구현하기 위한 클래스의 요소
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}













