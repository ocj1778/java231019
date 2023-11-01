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
		
		/*
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
		// => 명령 실행시 예외가 발생된 경우 실행된 명령 위치에서 프로그램 강제 종료
		for(int i=0;i<students.length;i++) {
			//참조변수에 저장된 값이 [null]이 아닌 경우 참조변수로 객체를 참조하여 메소드 호출
			// => NullPointerException 발생을 방지할 수 있는 선택문
			if(students[i] != null) {//배열 요소로 객체를 참조할 수 있는 경우 - 객체가 존재할 경우
				students[i].display();
			}
		}
		System.out.println("==============================================================");
		*/
		
		//모든 학생들의 총점 합계를 저장하기 위한 변수
		//int total=0;
		
		Student[] students = {new Student(1000, "홍길동", 90, 90)
				, new Student(2000, "임꺽정", 94, 98),  new Student(3000, "전우치", 91, 80)
				, new Student(4000, "일지매", 76, 82), new Student(5000, "장길산", 84, 86)};
		
		//향상된 for 구문을 사용해 배열 요소에 저장된 객체의 메모리 주소를 차례대로 제공받아 
		//참조변수에 저장하여 일괄적으로 메소드 호출 가능 
		for(Student student : students) {
			student.display();

			//학생의 총점을 반환받아 총점 합계 변수에 누적하여 저장
			//total+=student.getTot();
			
			//정적 필드는 클래스를 이용하여 사용 가능
			//Student.total+=student.getTot();
			
			//정적 메소드는 클래스를 이용하여 호출 가능 - 메소드 호출 용이
			// => 정적 필드(total)에 학생 총점(tot)를 반환받아 합한 결과값으로 정적 필드(total) 변경
			Student.setTotal(Student.getTotal()+student.getTot());
		}
		System.out.println("==============================================================");
		//모든 학생들의 총점 합계를 계산하여 출력
		//System.out.println("총합계 = "+total);
		//System.out.println("총합계 = "+Student.total);
		System.out.println("총합계 = "+Student.getTotal());
		System.out.println("==============================================================");
	}
}
