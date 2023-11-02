package inheritance;

//사람정보(번호, 이름)를 저장하기 위한 클래스
// => 학생, 강사, 직원에 대한 공통적인 속성과 행위를 구현하기 위해 선언된 클래스
// => 학생, 강사, 직원 관련 클래스가 상속받아야 되는 부모클래스
public class AcademyPerson {
	private int number;
	private String name;
	
	public AcademyPerson() {
		// TODO Auto-generated constructor stub
	}

	public AcademyPerson(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void display() {
		System.out.println("번호 = "+number);
		System.out.println("이름 = "+name);
	}
}
