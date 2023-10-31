package oop;

public class StudentApp {
	public static void main(String[] args) {
		/*
		Student student1=new Student(1000, "홍길동", 90, 90);
		Student student2=new Student(2000, "임꺽정", 94, 98);
		Student student3=new Student(3000, "전우치", 91, 80);
		Student student4=new Student(4000, "일지매", 76, 82);
		Student student5=new Student(5000, "장길산", 84, 86);
		
		student1.display();
		student2.display();
		student3.display();
		student4.display();
		student5.display();
		System.out.println("==============================================================");
		student1.setKor(100);
		student1.calcTot();
		student1.display();
		System.out.println("==============================================================");
		*/
		
		//객체를 저장할 수 있는 요소가 5개인 배열을 생성하여 참조변수에 저장
		// => 모든 배열 요소에는 기본적으로 [null] 저장
		Student[] students=new Student[5];
		
		//객체를 생성하여 배열 요소에 객체의 메모리 주소 저장 - 객체 배열
		students[0]=new Student(1000, "홍길동", 90, 90);
		students[1]=new Student(2000, "임꺽정", 94, 98);
		students[2]=new Student(3000, "전우치", 91, 80);
		students[3]=new Student(4000, "일지매", 76, 82);
		students[4]=new Student(5000, "장길산", 84, 86);
		
		//반복문을 사용하여 배열 요소에 저장된 모든 객체를 참조하여 메소드 호출 가능 - 일괄처리
		//참조변수에 [null]이 저장된 상태에서 참조변수로 메소드를 호출할 경우 참조변수에 의해
		//참조될 객체가 없으므로 실행시 NullPointerException 발생
		// => 예외가 발생시 명령에서 프로그램 강제 종료
		for(int i=0;i<students.length;i++) {
			//참조변수에 저장된 값이 [null]이 아닌 경우 참조변수로 객체를 참조하여 메소드 호출
			// => NullPointerException 발생을 방지할 수 있는 선택문
			if(students[i] != null) {
				students[i].display();
			}
		}
		System.out.println("==============================================================");
	}
}











