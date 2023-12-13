package xyz.itwill.student;

import java.util.List;

//DAO 클래스가 상속받기 위한 인터페이스
// => 인터페이스에 추상메소드를 작성하여 인터페이스를 상속받은 모든 자식클래스(DAO 클래스)에
//동일한 메소드를 작성할 수 있도록 메소드의 작성 규칙 제공
// => 프로그램에서 사용하는 DAO 클래스가 변경돼도 프로그램에 영향을 최소화 하기 위해 인터페이스 선언
public interface StudentDAO {
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	// => 학생정보를 매개변수로 하나씩 전달받아 처리 - 미권장 
	//int insertStudent(int no, String name, String phone, String address, String birthday);
	// => 학생정보를 매개변수로 한번에 전달받아 처리 - 권장 
	int insertStudent(StudentDTO student);
	
	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	int updateStudent(StudentDTO student);
	
	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	int deleteStudent(int no);
	
	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 반환하는 메소드
	// => 단일행을 검색하는 DAO 클래스의 메소드는 값(하나의 컬럼값) 또는 DTO 객체(다수의 컬럼값) 반환
	StudentDTO selectStudentByNo(int no);
	
	//이름을 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 반환하는 메소드
	// => 다중행을 검색하는 DAO 클래스의 메소드는 List 객체 반환
	List<StudentDTO> selectStudentByName(String name);
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	List<StudentDTO> selectStudentList();
}









