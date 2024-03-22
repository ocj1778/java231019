package xyz.itwill07.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.Setter;

//SpringDAO 기능을 사용하여 DAO 클래스 작성 - spring-jdbc 라이브러리를 프로젝트에 빌드 처리
// => Template Method Pattern이 적용된 JdbcTemplate 객체의 메소드를 호출하여 DAO 클래스의 메소드 작성 
//Template Method Pattern : 메소드에 필요한 명령들을 미리 제공하여 쉽게 기능 구현을 제공하는 디자인 패턴 
// => 템플릿 메소드의 매개변수에 필요한 값(객체)을 전달하여 JDBC 기능 구현 

public class StudentDAOImpl implements StudentDAO {
	//JdbcTemplate 객체를 저장하기 위한 필드 선언
	// => Spring Bean Configuration File에서 StudentDAOImpl 클래스를 Spring Bean으로 등록할 때
	//스프링 컨테이너로부터 JdbcTemplate 객체를 제공받아 의존성 주입 - Setter Injection
	@Setter
	private JdbcTemplate jdbcTemplate;  
	
	//학생정보를 전달받아 STUDENT 테이블에 행으로 삽입하고 삽입행의 갯수를 반환하는 메소드
	@Override
	public int insertStudent(Student student) {
		String sql="insert into student values(?,?,?,?,?)";
		//JdbcTemplate.update(String sql, Object ... args) : SQL 명령(INSERT, UPDATE, DELETE)을
		//DBMS 서버에 전달하여 실행하는 메소드 - 조작행의 갯수(int) 반환
		// => 메소드 매개변수에는 실행될 SQL 명령과 InParameter(?)에 전달되어 사용될 값을
		//차례대로 나열하여 제공
		// => SQL 명령의 InParameter(?) 갯수만큼 반드시 args 매개변수에 값을 전달 
		return jdbcTemplate.update(sql, student.getNo(), student.getName()
				, student.getPhone(), student.getAddress(), student.getBirthday());
	}

	//학생정보를 전달받아 STUDENT 테이블에 저장된 행을 변경하고 변경행의 갯수를 반환하는 메소드
	@Override
	public int updateStudent(Student student) {
		String sql="update student set name=?, phone=?, address=?, birthday=? where no=?";
		return jdbcTemplate.update(sql, student.getName(), student.getPhone()
				, student.getAddress(), student.getBirthday(), student.getNo());
	}

	//학생번호를 전달받아 STUDENT 테이블에 저장된 행을 삭제하고 삭제행의 갯수를 반환하는 메소드
	@Override
	public int deleteStudent(int no) {
		return jdbcTemplate.update("delete from student where no=?", no);
	}

	//학생번호를 전달받아 STUDENT 테이블에 저장된 행을 검색하여 Java 객체(DTO)로 반환하는 메소드
	@Override
	public Student selectStudent(int no) {
		try {
			String sql="select no, name, phone, address, birthday from student where no=?";
			//jdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object ... args)
			// => SQL 명령(SELECT)을 DBMS 서버에 전달하여 실행하는 메소드
			// => 단일행의 검색결과를 DTO 객체(Wrapper 또는 String)로 반환하기 위해 사용하는 메소드
			// => 매개변수에서 실행될 SQL 명령과 검색행을 Java 객체로 변환하기 위한 정보를 제공하는
			//RowMapper 객체, InParameter(?)에 전달되어 사용될 값을 차례대로 나열하여 제공
			
			//RowMapper 객체 : RowMapper 인터페이스를 상속받은 자식클래스로 생성된 객체
			// => 검색행을 Java 객체로 변환하는 기능을 제공하는 객체
			// => 검색행의 컬럼값을 DTO 객체의 필드에 저장하기 위한 매핑정보를 반드시 설정
			//RowMapper 인터페이스를 상속받은 익명의 내부클래스를 사용하여 RowMapper 객체 생성하여 사용 
			// => 인터페이스 제네릭에는 검색행으로 생성될 DTO 객체의 자료형(클래스)를 설정
			// => RowMapper 인터페이스의 추상메소드를 오버라이드 선언하여 매핑정보 작성
			/*
			return jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					//검색행의 컬럼값을 DTO 객체의 필드에 저장되도록 매핑 설정
					return Student.builder()
							.no(rs.getInt("no"))
							.name(rs.getString("name"))
							.phone(rs.getString("phone"))
							.address(rs.getString("address"))
							.birthday(rs.getString("birthday"))
							.build();
				}
			}, no);
			*/
			//RowMapper 인터페이스를 상속받은 내부클래스로 RowMapper 객체 생성하여 사용 - 재활용 
			return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), no);
		} catch (EmptyResultDataAccessException e) {
			//EmptyResultDataAccessException : queryForObject() 메소드로 전달될어 실행된
			//SELECT 명령에 대한 검색행이 없는 경우 발생되는 예외
			return null;
		}	
	}

	//STUDENT 테이블에 저장된 모든 행을 검색하여 Java 객체(List)로 반환하는 메소드
	@Override
	public List<Student> selectStudentList() {
		String sql="select no, name, phone, address, birthday from student order by no";
		//jdbcTemplate.query(String sql, RowMapper<T> rowMapper, Object ... args)
		// => SQL 명령(SELECT)을 DBMS 서버에 전달하여 실행하는 메소드
		// => 다수행의 검색결과를 List 객체로 반환하기 위해 사용하는 메소드 
		// => RowMapper 객체로 하나의 검색행을 DTO 객체로 생성하여 List 객체의 요소로 추가
		/*
		return jdbcTemplate.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Student.builder()
						.no(rs.getInt("no"))
						.name(rs.getString("name"))
						.phone(rs.getString("phone"))
						.address(rs.getString("address"))
						.birthday(rs.getString("birthday"))
						.build();
			}
		});
		*/
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}
	
	private class StudentRowMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Student.builder()
					.no(rs.getInt("no"))
					.name(rs.getString("name"))
					.phone(rs.getString("phone"))
					.address(rs.getString("address"))
					.birthday(rs.getString("birthday"))
					.build();
		}
	}
}
