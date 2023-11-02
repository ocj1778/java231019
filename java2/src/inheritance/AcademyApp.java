package inheritance;

//학원인적자원(학생, 강사, 직원) 관리 프로그램
public class AcademyApp {
	public static void main(String[] args) {
		/*
		//학생정보(AcademyStudent 객체)를 저장하기 위한 요소들이 존재하는 배열 생성
		AcademyStudent[] students=new AcademyStudent[300];
		
		//강사정보(AcademyInstructor 객체)를 저장하기 위한 요소들이 존재하는 배열 생성
		AcademyInstructor[] instructors=new AcademyInstructor[50];
		
		//직원정보(AcademyStaff 객체)를 저장하기 위한 요소들이 존재하는 배열 생성
		AcademyStaff[] staffs=new AcademyStaff[100];
		*/
		
		//사람정보(AcademyPerson 객체)를 저장하기 위한 요소들이 존재하는 배열 생성
		// => 배열의 요소에는 학생정보(AcademyStudent 객체), 강사정보(AcademyInstructor 객체)
		//, 직원정보(AcademyStaff 객체) 저장 가능
		AcademyPerson[] persons=new AcademyPerson[5];
		
		//자식클래스의 생성자를 이용하여 부모 객체를 먼저 생성하고 자식 객체를 생성해 부모
		//클래스의 배열 요소(참조변수)에 부모 객체 저장
		// => 배열 요소에는 부모 객체가 저장되어 있으므로 부모클래스의 메소드 호출
		// => 객체 형변환을 이용하면 배열 요소에 일시적으로 자식 객체를 저장하여 자식클래스의 메소드 호출 가능
		persons[0]=new AcademyStudent(1000,"홍길동","웹개발자 과정");
		persons[1]=new AcademyInstructor(2000, "임꺽정", "Java 과목");
		persons[2]=new AcademyStaff(3000, "전우치", "운영관리팀");
		persons[3]=new AcademyStudent(4000, "일지매", "웹디자인 과정");
		persons[4]=new AcademyStaff(5000, "장길산", "경영회계팀");
		
		//배열 요소에 저장된 부모 객체를 하나씩 제공받아 참조변수에 저장하여 메소드를 일괄적으로 호출
		for(AcademyPerson person : persons) {
			//오버라이드 선언된 자식클래스의 메소드는 묵시적 객체 형변환에 의해 부모클래스의 
			//참조변수가 일시적으로 자식클래스로 변경되어 자식 객체를 참조해 자식클래스의 메소드 호출
			// => 오버라이드에 의한 다형성 : 묵시적 객체 형변환에 의해 참조변수의 자료형이
			//자식클래스로 변환되어 저장된 자식 객체에 따라 다른 클래스의 메소드를 선택 호출
			person.display();
			System.out.println("==========================================================");
		}
		
	}
}















