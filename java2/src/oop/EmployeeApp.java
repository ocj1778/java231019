package oop;

//사원 급여 관리 프로그램
public class EmployeeApp {
	public static void main(String[] args) {
		/*
		//추상클래스를 사용하여 객체를 생성할 경우 에러 발생 
		Employee employee=new Employee(1000, "홍길동");
		
		System.out.println("사원번호 = "+employee.getEmpNo());
		System.out.println("사원이름 = "+employee.getEmpName());
		*/
		
		/*
		//추상클래스로 참조변수를 생성하여 자식클래스의 생성자로 만들어진 객체 저장 가능
		// => 자식클래스의 생성자에 의해 추상클래스의 생성자를 사용해 부모 객체 생성 가능
		Employee employee1=new EmployeeRegular();
		Employee employee2=new EmployeeTime();
		Employee employee3=new EmployeeContract();
		*/
		
		//다수의 객체를 저장하기 위한 배열 선언
		Employee[] empArray=new Employee[5];
		
		//배열 요소에는 EmployeeRegular 객체, EmployeeTime 객체, EmployeeContract 객체 저장 가능
		empArray[0]=new EmployeeRegular(1000, "홍길동", 96000000);
		empArray[1]=new EmployeeTime(2000, "임꺽정", 50000, 150);
		empArray[2]=new EmployeeContract(3000, "전우치", 7000000);
		empArray[3]=new EmployeeTime(4000, "일지매", 20000, 100);
		empArray[4]=new EmployeeRegular(5000, "장길산", 60000000);
		
		//반복문을 사용하여 모든 사원정보가 출력되도록 일괄 처리
		for(Employee employee : empArray) {
			System.out.println("사원번호 = "+employee.getEmpNo());
			System.out.println("사원이름 = "+employee.getEmpName());
			
			/*
			//급여를 계산하여 반환하는 메소드를 호출해 급여를 반환받아 출력
			// => 참조변수는 부모 객체를 이용하여 부모클래스의 메소드만 호출되므로 자식클래스의 메소드 호출 불가능
			// => 명시적 객체 형변환을 사용하여 참조변수를 자식클래스로 변경하여 참조변수에
			//자식 객체가 저장되도록 만들어 자식클래스의 메소드 호출
			// => instanceof 연산자를 사용하여 자식클래스를 구분하여 명시적 객체 형변환 - ClassCastException 방지
			if(employee instanceof EmployeeRegular) {
				System.out.println("사원급여 = "+((EmployeeRegular)employee).computeSalary());
			} else if(employee instanceof EmployeeTime) {
				System.out.println("사원급여 = "+((EmployeeTime)employee).computeTimePay());
			} else if(employee instanceof EmployeeContract) {
				System.out.println("사원급여 = "+((EmployeeContract)employee).computeContract());
			}
			*/
			
			//부모클래스의 메소드를 오버라이드 선언한 경우 부모클래스의 참조변수로 호출하면
			//묵시적 객체 형변환이 발생하여 참조변수가 자식클래스로 변환되어 자식객체를 참조해
			//자식클래스의 메소드 호출
			// => 참조변수가 참조할 수 있는 자식 객체에 따라 다른 자식클래스의 메소드 호출 - 메소드 오버라이딩 의한 다형성
			//문제점)자식클래스에서 부모클래스의 메소드를 오버라이드 선언하지 않으면 부모클래스의 메소드 호출
			// => 비정상적인 결과 발생(실행 오류) - 오버라이드 선언에 대한 강제성 미제공
			//해결법)부모클래스의 메소드를 추상메소드로 선언하면 자식클래스는 부모클래스의
			//추상메소드를 반드시 오버라이드 선언 - 오버라이드 선언에 대한 강제성 제공
			System.out.println("사원급여 = "+employee.computePay());
			
			//성과급을 계산하여 반환하는 메소드를 호출해 성과급을 반환받아 출력
			System.out.println("성과급 = "+employee.computeIncetive());
			System.out.println("==========================================================");
		}
		
	}
}
