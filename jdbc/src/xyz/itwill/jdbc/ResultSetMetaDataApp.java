package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		
		//String sql="select * from student order by no";
		String sql="select no,name from student order by no";
		//ResultSet 객체 : SELECT 명령을 전달하여 실행된 검색결과(검색행)를 저장한 객체
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		System.out.println("==============================================================");
		//ResultSet.getMetaData() : 검색행(ResultSet 객체)의 대한 부가적인 정보(검색대상)가
		//저장된 ResultSetMetaData 객체를 반환하는 메소드
		ResultSetMetaData rsmd=rs.getMetaData();
		
		//ResultSetMetaData.getColumnCount() : 검색행(ResultSet 객체)의 컬럼 갯수를 반환하는 메소드
		int columnCount=rsmd.getColumnCount();
		System.out.println("검색행의 컬럼 갯수 = "+columnCount);
		System.out.println("==============================================================");
		ConnectionFactory.close(con, stmt, rs);
	}
}














