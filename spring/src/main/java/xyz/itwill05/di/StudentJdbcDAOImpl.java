package xyz.itwill05.di;

import java.util.List;

//DAO 클래스 : 저장매체(File, DBMS 등)의 행에 대한 삽입,변경,삭제,검색 기능을 제공하는 클래스
// => 저장매체의 종류 또는 방법에 따라 DAO 클래스 교체 가능
// => DAO 클래스가 교체돼도 DAO 클래스를 사용하는 클래스(Service 클래스)에 영향을 최소화하기
//위해 반드시 인터페이스를 상속받아 작성 - 결합도를 낮춰 유지보수의 효율성 증가
public class StudentJdbcDAOImpl implements StudentDAO {
	public StudentJdbcDAOImpl() {
		System.out.println("### StudentJdbcDAOImpl 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAOImpl 클래스의 insertStudent(Student student) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** StudentJdbcDAOImpl 클래스의 updateStudent(Student student) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** StudentJdbcDAOImpl 클래스의 deleteStudent(int num) 메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAOImpl 클래스의 selectStudent(int num) 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentJdbcDAOImpl 클래스의 selectStudentList() 메소드 호출 ***");
		return null;
	}
}
