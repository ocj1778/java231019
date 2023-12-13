package xyz.itwill.student;

import java.util.List;

//DAO(Data Access Object) 클래스 : 저장매체에 행을 삽입,변경,삭제,검색하는 기능을 제공하는 클래스
// => 저장매체 : 정보를 행단위로 저장하기 위한 하드웨어 또는 소프트웨어 - Database
// => 인터페이스를 상속받아 작성하는 것을 권장 - 메소드의 작성규칙을 제공받아 DAO 클래스 작성  
// => 인터페이스를 상속받아 DAO 클래스를 작성하는 이유는 DAO 클래스가 변경돼도 DAO 클래스를  
//사용한 클래스에 영향을 최소화 하여 유지보수의 효율성 증가를 위해 사용
// => 싱글톤 디자인 패턴을 적용하여 작성하는 것을 권장 - 프로그램에 하나의 객체만 제공

//STUDENT 테이블에 행을 삽입,변경,삭제,검색하는 기능의 메소드를 작성하기 위한 DAO 클래스
// => DAO 클래스의 메소드는 SQL 명령에 필요한 값(객체)을 매개변수로 전달받아 하나의 SQL 명령을
//DBMS 서버에 전달하여 실행하고 실행결과를 Java 객체(값)으로 매핑하여 반환

public class StudentDAOImpl implements StudentDAO {
	private static StudentDAOImpl _dao;
	
	private StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAOImpl();
	}
	
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	public static StudentDAOImpl getDAO() {
		return _dao;
	}

	@Override
	public int insertStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		return 0;
	}

	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	@Override
	public int updateStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		return 0;
	}

	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	@Override
	public int deleteStudent(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 반환하는 메소드
	@Override
	public StudentDTO selectStudentByNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	//이름을 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 반환하는 메소드
	// => 다중행을 검색하는 DAO 클래스의 메소드는 List 객체 반환
	@Override
	public List<StudentDTO> selectStudentByName(String name) {
		return null;
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	@Override
	public List<StudentDTO> selectStudentList() {
		// TODO Auto-generated method stub
		return null;
	}
}
