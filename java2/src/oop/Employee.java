package oop;

//제한자(Modified) : 클래스, 필드, 생성자, 메소드 작성시 특별한 제한을 목적으로 사용하는 키워드
// => Access Modified(private, package, protected, public), static, final, abstract

//abstract : 클래스 또는 메소드 작성시 사용할 수 있는 제한자
// => 클래스 작성시 abstract 제한자를 사용하여 추상클래스로 선언
// => 메소드 작성시 abstract 제한자를 사용하여 추상메소드로 선언

//추상클래스(Abstract Class) : 객체 생성이 목적이 아닌 상속이 목적인 클래스를 작성하기 위해 선언하는 클래스 
//형식) public abstract class 클래스 { }
//=> new 연산자로 생성자를 호출하여 객체를 만들 수 없는 클래스

//final 제한자 : 클래스, 필드, 메소드 작성시 사용할 수 있는 제한자
// => 필드 작성시 final 제한자를 사용하여 final 필드로 선언 
// => 메소드 작성시 final 제한자를 사용하여 final 메소드로 선언 
// => 클래스 작성시 final 제한자를 사용하여 final 클래스로 선언 

//final 필드 : 필드에 저장된 값을 변경할 수 없도록 제한하는 필드
//형식) 접근제한자 final 자료형 필드명=값; 
// => final 필드 선언시 반드시 필드에 저장될 초기값 설정
// => final 필드에 저장된 초기값을 변경할 경우 에러 발생

//final 메소드 : 자식클래스에서 오버라이드 선언하지 못하도록 제한하는 메소드
//형식) 접근제한자 final 반환형 메소드명(자료형 변수명,...) { 명령; ... } 
// => final 메소드를 자식클래스에서 오버라이드 선언하면 에러 발생

//final 클래스 : 상속을 허용하지 않도록 제한하는 클래스
//형식) public final class 클래스명 { }

//사원정보(사원번호, 사원이름)를 저장하기 위한 클래스
// => 고용형태에 따른 모든 사원 관련 클래스가 반드시 상속받아야 되는 부모클래스
// => 객체 생성이 목적이 아닌 상속을 목적으로 작성된 클래스 - 추상클래스로 선언하는 것을 권장
public abstract class Employee {
	private int empNo;
	private String empName;

	//상수필드(Constant Field) : 프로그램 작성시 리터럴(값) 대신 사용하기 위해 의미있는
	//단어를 사용하여 만든 필드(값) - 유지보수의 효율성 증가
	//형식) public static final 자료형 필드명 = 초기값;
	// => 상수필드의 이름은 대문자로만 작성하므로 스네이크 표기법을 사용하여 작성하는 것을 권장
	public static final double INCENTIVE_RATE=1.5; 
	
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
	// => 자식클래스에서 메소드 오버라이드 선언하기 위해 작성된 메소드
	// => 자식클래스에서 반드시 오버라이드 선언하지 않아도 에러 미발생
	public int computePay() {
		return 0;
	}
	*/
	
	//추상메소드(Abstract Method) : abstract 제한자를 사용하여 작성된 메소드
	//형식) 접근제한자 abstract 반환형 메소드명(자료형 변수명, ...);
	// => 메소드의 머릿부만 작성하고 몸체부가 없는 메소드(명령이 존재하지 않는 메소드) - 미완성된 메소드
	// => 자식클래스에서 반드시 오버라이드 선언해야만 하는 메소드를 작성할 때 선언하는 메소드
	// => 추상메소드를 자식클래스에서 오버라이드 선언하지 않으면 에러 발생
	// => 추상메소드가 하나라도 선언된 클래스는 반드시 추상클래스로 작성
	public abstract int computePay();
	
	//성과급을 계산하여 반환하는 메소드
	// => 모든 사원에게 사원급여의 150%를 성과급으로 계산하여 반환
	//문제점)자식클래스에서 메소드를 오버라이드 선언할 경우 자식클래스의 메소드가 호출되어 비정상적인 결과 발생
	//해결법)자식클래스에서 메소드를 오버라이드 선언하지 못하도록 final 메소드로 선언하는 것을 권장 
	public final int computeIncetive() {
		//자식클래스의 메소드에서 추상메소드를 호출하면 묵시적 객체 형변환에 의해 자식 객체를
		//참조하여 자식메소드 호출
		//return (int)(computePay()*1.5);
		
		//리터럴(프로그램에서 표현되는 값) 대신에 상수를 사용하는 것을 권장
		// => 유지보수의 효율성 증가
		return (int)(computePay()*INCENTIVE_RATE);
	}
}
