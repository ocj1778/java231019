package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.StudentDTO;

//DAO(Data Access Object) 클래스 : 테이블에 행 삽입,삭제,변경,검색하는 SQL 명령을 전달하여 
//실행하고 실행결과를 Java 객체(값)으로 매핑하여 반환하는 기능을 제공하는 클래스
// => 싱글톤 클래스(프로그램에 객체를 하나만 생성하여 제공하는 클래스)로 작성하는 것을 권장

//STUDENT 테이블에 학생정보(행)을 삽입,삭제,변경,검색하는 기능을 제공하는 클래스
// => DBMS 서버에 하나의 SQL 명령을 전달하여 실행하고 실행결과를 Java 객체로 매핑하여 반환하는 메소드 작성  
public class StudentDAO extends JdbcDAO {
	private static StudentDAO _dao;
	
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}

	/*
	static {
		_dao=new StudentDAO();
	}
	*/
	
	public static StudentDAO getDAO() {
		if(_dao == null) {
			_dao=new StudentDAO();
		}
		return _dao;
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 List 객체로 반환하는 메소드
	public List<StudentDTO> selectStudentList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		try {
			con=getConnection();
			
			String sql="select no,name,phone,address,birthday from student order by no";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			//검색결과를 Java 객체(List 객체)로 매핑 처리
			while(rs.next()) {
				//DTO 객체를 생성하여 처리행의 컬럼값을 객체 필드에 저장
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				
				//List 객체의 요소에 DTO 객체 추가
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectStudentList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}
}
