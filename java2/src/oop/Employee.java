package oop;

//사원정보(사원번호, 사원이름)를 저장하기 위한 클래스
// => 고용형태에 따른 모든 사원 관련 클래스가 반드시 상속받아야 되는 부모클래스
public class Employee {
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
