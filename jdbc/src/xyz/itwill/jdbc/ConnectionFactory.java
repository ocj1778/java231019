package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Connection 객체를 생성하여 반환하거나 JDBC 객체를 매개변수로 전달받아 제거하는 기능을 
//제공하는 클래스
// => JDBC 프로그램 작성에 필요한 공통적인 기능을 메소드로 제공하기 위한 클래스
// => 코드의 중복성을 최소화 하여 프로그램의 생산성을 높이고 유지보수의 효율성 증가
public class ConnectionFactory {
	//Connection 객체를 생성하여 반환하는 정적 메소드
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {//모든 예외를 처리하기 구문
			System.out.println("[에러]Connection 객체를 생성할 수 없습니다.");
		}
		
		return con;
	}
	
	//매개변수로 전달받은 JDBC 관련 객체를 삭제하는 정적 메소드
	public static void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con, Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}








