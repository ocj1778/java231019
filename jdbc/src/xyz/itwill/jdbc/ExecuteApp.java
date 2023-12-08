package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteApp {
	public static void main(String[] args) throws SQLException {
		/*
		Connection con=ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		
		String sql1="update student set address='수원시 팔달구' where no=2000";
		int rows=stmt.executeUpdate(sql1);
		
		System.out.println("[메세지]"+rows+"명의 학생정보를 변경 하였습니다.");
		System.out.println("==============================================================");
		String sql2="select no,address from student order by no";
		ResultSet rs=stmt.executeQuery(sql2);
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 주소 = "+rs.getString("address"));
		}
		System.out.println("==============================================================");
		ConnectionFactory.close(con, stmt, rs);
		*/
		
		Connection con=ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		
		//String sql="update student set address='수원시 팔달구' where no=2000";
		String sql="select no,address from student order by no";

		//Statement.execute(String sql) : SQL 명령을 전달하여 실행하는 메소드 - 논리값 반환
		// => false 반환 : DML 명령 또는 DDL 명령을 전달하여 실행한 경우의 반환값 
		// => true 반환 : DQL 명령(SELECT)을 전달하여 실행한 경우의 반환값 
		// => DBMS 서버에 전달되어 실행될 SQL 명령이 명확하지 않은 경우 사용하는 메소드
		boolean result=stmt.execute(sql);
		
		if(result) {//SELECT 명령이 전달되어 실행된 경우
			//Statement.getUpdateCount() : Statement 객체로 전달되어 실행된 SELECT 명령의
			//실행결과(검색행)가 저장된 ResultSet 객체를 반환하는 메소드
			ResultSet rs=stmt.getResultSet();			
			
			while(rs.next()) {
				System.out.println("학번 = "+rs.getInt("no")+", 주소 = "+rs.getString("address"));
			}
			
			ConnectionFactory.close(con, stmt, rs);
		} else {//SELECT 명령외의 SQL 명령이 전달되어 실행된 경우
			//Statement.getUpdateCount() : Statement 객체로 전달되어 실행된 DML 명령 또는
			//DDL 명령의 처리결과를 정수값(int)로 반환하는 메소드
			int rows=stmt.getUpdateCount();
			
			System.out.println("[메세지]"+rows+"명의 학생정보를 변경 하였습니다.");

			ConnectionFactory.close(con, stmt);
		}
		System.out.println("==============================================================");
	}
}
