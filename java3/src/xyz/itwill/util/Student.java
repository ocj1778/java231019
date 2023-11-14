package xyz.itwill.util;

//Comparable 인터페이스 : 값을 비교하여 결과를 반환하는 compareTo() 추상메소드가 선언
// => compareTo() 메소드를 오버라이드 선언하여 자식클래스의 객체 필드값을 매개변수로 전달받은
//객체의 필드값과 비교하여 양수, 음수, 0 중 하나를 반환
// => 객체를 비교하기 위해 사용하는 인터페이스 - 정렬 처리할 때 반드시 필요

//학생정보(학번, 이름)를 저장하기 위한 클래스
public class Student implements Comparable<Student> {
	private int num;
	private String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "{학번 = "+num+", 이름 = "+name+"}";
	}

	@Override
	public int compareTo(Student o) {
		//return this.num-o.num;//학번을 비교하여 결과값(양수,음수,0) 반환 - 오름차순 정렬
		//return o.num-this.num;//학번을 비교하여 결과값(양수,음수,0) 반환 - 내림차순 정렬
		//문자열은 String 클래스의 compareTo() 메소드를 호출하여 비교하여 반환값으로 처리
		//return this.name.compareTo(o.name);//이름을 비교하여 결과값(양수,음수,0) 반환 - 오름차순 정렬
		return o.name.compareTo(this.name);//이름을 비교하여 결과값(양수,음수,0) 반환 - 내림차순 정렬
		
	}
}











