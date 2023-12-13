package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO(Data Access Object) 클래스 : 저장매체에 행을 삽입,변경,삭제,검색하는 기능을 제공하는 클래스
// => 저장매체 : 정보를 행단위로 저장하기 위한 하드웨어 또는 소프트웨어 - Database
// => 인터페이스를 상속받아 작성하는 것을 권장 - 메소드의 작성규칙을 제공받아 DAO 클래스 작성  
// => 인터페이스를 상속받아 DAO 클래스를 작성하는 이유는 DAO 클래스가 변경돼도 DAO 클래스를  
//사용한 클래스에 영향을 최소화 하여 유지보수의 효율성 증가를 위해 사용
// => 싱글톤 디자인 패턴을 적용하여 작성하는 것을 권장 - 프로그램에 하나의 객체만 제공

//STUDENT 테이블에 행을 삽입,변경,삭제,검색하는 기능의 메소드를 작성하기 위한 DAO 클래스
// => DAO 클래스의 메소드는 SQL 명령에 필요한 값(객체)을 매개변수로 전달받아 하나의 SQL 명령을
//DBMS 서버에 전달하여 실행하고 실행결과를 Java 객체(값)로 매핑(검색행의 컬럼값을 객체 필드에 저장)하여 반환
// => JdbcDAO 클래스를 상속받아 DAO 클래스의 메소드에서 JdbcDAO 클래스의 메소드 호출 가능
public class StudentDAOImpl extends JdbcDAO implements StudentDAO {
	private static StudentDAOImpl _dao;
	
	private StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAOImpl();
	}
	
	public static StudentDAOImpl getDAO() {
		return _dao;
	}

	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	@Override
	public int insertStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;//SQL 명령의 실행결과를 저장하기 위한 변수 - 메소드의 반환값
		try {
			con=getConnection();
			
			String sql="insert into student values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			//PreparedStatement 객체에 저장된 SQL 명령의 InParameter에는 메소드의 매개변수로
			//전달받은 값을 제공하여 SQL 명령에 포함되도록 처리
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

	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	@Override
	public int updateStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
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
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StudentDTO student=null;
		try {
			con=getConnection();
			
			String sql="select no,name,phone,address,birthday from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
			//검색행이 하나인 경우에는 선택문 사용하여 처리
			// => 검색행이 있는 경우 선택문의 명령으로 검색결과를 Java 객체로 변환되도록 처리
			
			//ResultSet 커서를 다음행으로 이동하여 처리될 행이 있는 경우 선택문의 명령 실행
			if(rs.next()) {
				//검색행을 Java 객체로 변환되도록 매핑 처리
				// => 검색행의 컬럼값을 DTO 객체의 필드값으로 저장되도록 처리
				student=new StudentDTO();//DTO 객체 생성 - DTO 객체의 필드에는 기본값 저장
				//ResultSet 커서가 위치한 처리행의 컬럼값을 반환받아 객체의 필드값 변경
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectStudentByNo() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return student;
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
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		try {
			con=getConnection();
			
			String sql="select no,name,phone,address,birthday from student order by no";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			//검색행이 여러개인 경우에는 반복문 사용하여 처리
			// => 검색행이 있는 경우 반복문의 명령으로 검색결과를 Java 객체로 변환하여
			//List 객체의 요소로 추가되도록 처리
			
			//ResultSet 커서를 다음행으로 이동하여 처리될 행이 있는 경우 반복문의 명령 실행
			while(rs.next()) {
				//검색행을 Java 객체로 변환되도록 매핑 처리
				// => ResultSet 커서가 위치한 처리행의 컬럼값을 반환받아 객체의 필드값 변경
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				
				//Java 객체를 List 객체의 요소값으로 저장되도록 추가
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
