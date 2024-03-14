package xyz.itwill05.di;

//학생정보를 저장하기 위한 클래스 - VO 클래스, DTO 클래스 : POJO(Plain Old Java Object)
// => 학생정보 관련 값을 필드에 저장하여 사용
public class Student {
	private int num;
	private String name;
	private String email;
	
	public Student() {
		System.out.println("### Student 클래스의 기본 생성자 호출 ###");
	}

	public Student(int num) {
		super();
		this.num = num;
		System.out.println("### Student 클래스의 매개변수(학번)가 선언된 생성자 호출 ###");
	}

	public Student(String name) {
		super();
		this.name = name;
		System.out.println("### Student 클래스의 매개변수(이름)가 선언된 생성자 호출 ###");
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
		System.out.println("### Student 클래스의 매개변수(학번, 이름)가 선언된 생성자 호출 ###");
	}

	public Student(int num, String name, String email) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		System.out.println("### Student 클래스의 매개변수(학번, 이름, 이메일)가 선언된 생성자 호출 ###");
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		System.out.println("*** Student 클래스의 setNum(int num) 메소드 호출 ***");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("*** Student 클래스의 setName(String name) 메소드 호출 ***");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println("*** Student 클래스의 setEmail(String email) 메소드 호출 ***");
	}
	
	@Override
	public String toString() {
		return "학번 = "+num+", 이름 = "+name+", 이메일 = "+email;
	}
}
