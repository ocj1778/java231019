package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetCursorApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.createStatement() : 현재 접속중인 DBMS 서버에 SQL 명령을 전달하여 실행
		//하기 위한 Statement 객체를 반환하는 메소드
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		//Statement.executeQuery(String sql) : SELECT 명령을 전달하여 실행하고 검색된 행이
		//저장한 ResultSet 객체를 반환하는 메소드
		// => ResultSet 객체에 저장된 검색행은 행단위로 처리하기 위해 커서(Cursor) 사용
		// => ResultSet 커서는 다음행으로만 이동 가능하며 커서 위치의 처리행 대한 조작 불가능
		ResultSet rs=stmt.executeQuery(sql);
		//System.out.println(rs);
		
		//ResultSet.next() : ResultSet 객체의 커서를 다음행으로 이동하는 메소드
		// => 이동된 커서 위치에 처리행이 없는 경우 [false]를 반환하고 처리행이 있는 경우 [true] 반환
		while(rs.next()) {
			//ResultSet.getRow() : ResultSet 커서가 위치한 처리행의 행번호(RowIndex)를 반환하는 메소드
			//ResultSet.getXXX(String columnLabel) : ResultSet 커서가 위치한 처리행의 컬럼값을 반환하는 메소드
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		
		System.out.println("==============================================================");
		
		ConnectionFactory.close(con, stmt, rs);
	}
}











