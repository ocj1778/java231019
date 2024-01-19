package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import xyz.itwill.dto.StudentDTO;

//STUDENT 테이블의 행 삽입, 변경, 삭제, 검색 기능을 제공하는 클래스
public class StudentDAO extends JdbcDAO {
	private static StudentDAO _dao;
	
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return _dao;
	}
	
	//학생정보(StudentDTO 객체)를 전달받아 STUDENT 테이블의 행으로 삽입하고 삽입행의 갯수(int)를 반환하는 메소드
	public int insertStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into student valeus(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//학생정보(StudentDTO 객체)를 전달받아 STUDENT 테이블에 저장된 행을 변경하고 변경행의 갯수(int)를 반환하는 메소드
	public int updateStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="";
			pstmt=con.prepareStatement(sql);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//학번(int)을 전달받아 STUDENT 테이블에 저장된 행을 삭제하고 삭제행의 갯수(int)를 반환하는 메소드
	public int deleteStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="";
			pstmt=con.prepareStatement(sql);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//학번(int)을 전달받아 STUDENT 테이블에 저장된 행을 검색하여 학생정보(StudentDTO 객체)로 반환하는 메소드
	
	
	//STUDENT 테이블의 저장된 모든 행을 검색하여 학생정보목록(List 객체 - 요소 : StudentDTO 객체)을 반환하는 메소드
	
	
}












