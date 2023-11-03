package oop;

//계약직 사원정보(사원번호, 사원이름, 계약급여)를 저장하기 위한 클래스
// => Employee 클래스를 상속받아 작성
public class EmployeeContract extends Employee {
	private int contractPay;
	
	public EmployeeContract() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeContract(int empNo, String empName, int contractPay) {
		super(empNo, empName);
		this.contractPay = contractPay;
	}

	public int getContractPay() {
		return contractPay;
	}

	public void setContractPay(int contractPay) {
		this.contractPay = contractPay;
	}
	
	//급여를 계산하여 반환하는 메소드
	public int computeContract() {
		return contractPay;
	}
}
