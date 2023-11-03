package oop;

//제한자(Modified) : 클래스, 필드, 생성자, 메소드 작성시 특별한 제한을 목적으로 사용하는 키워드
// => Access Modified(private, package, protected, public), static, final, abstract

//abstract : 클래스 또는 메소드 작성시 사용할 수 있는 제한자
// => 클래스 작성시 abstract 제한자를 사용하여 추상클래스로 선언 가능

//추상클래스(Abstract Class) : 객체 생성이 목적이 아닌 상속이 목적인 클래스를 작성하기 위해 선언하는 클래스 
//형식) public abstract class 클래스 { }
// => new 연산자로 생성자를 호출하여 객체를 만들 수 없는 클래스


//사원정보(사원번호, 사원이름)를 저장하기 위한 클래스
// => 고용형태에 따른 모든 사원 관련 클래스가 반드시 상속받아야 되는 부모클래스
// => 객체 생성이 목적이 아닌 상속을 목적으로 작성된 클래스 - 추상클래스로 선언하는 것을 권장
public abstract class Employee {
	private int empNo;
	private String empName;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	/*
	//사원의 급여를 계산하여 반환하는 메소드
	public int computePay() {
		return 0;
	}
	*/
}
