package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//PreparedStatement 객체 : 현재 접속중인 DBMS 서버에 SQL 명령을 전달하여 실행하기 위한 기능을 제공하는 객체
//장점 : InParameter를 사용하여 SQL 명령에 Java 변수값을 문자값으로 포함하여 사용 가능
// => InParameter를 사용하여 가독성이 향상되고 유지보수의 효율성 증가
// => InParameter로 전달받은 값은 SQL 명령에서 무조건 문자값으로 처리되므로 InSQL 해킹 기술을 무효화 처리 
//단점 : 하나의 PreparedStatement 객체로 하나의 SQL 명령만 전달하여 실행 가능
public class PreparedStatementApp {
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		/*
		//키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하고 STUDENT 테이블에 저장된 모든 학생정보를
		//학생정보를 검색하여 출력하는 JDBC 프로그램 작성
		
		//키보드로 학생정보를 입력받기 위한 입력스트림을 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//키보드로 학생정보를 입력받아 저장
		System.out.println("<<학생정보 입력>>");
		System.out.print("학번 입력 >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.print("이름 입력 >> ");
		String name=in.readLine();
		System.out.print("전화번호 입력 >> ");
		String phone=in.readLine();
		System.out.print("주소 입력 >> ");
		String address=in.readLine();
		System.out.print("생년월일 입력 >> ");
		String birthday=in.readLine();
		System.out.println("===============================================================");
		//키보드로 입력받은 학생정보를 STUDENT 테이블에 삽입 처리
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.prepareStatement(String sql) : Connection 객체로부터 DBMS 서버에 전달하여
		//실행될 SQL 명령이 저장된 PreparedStatement 객체를 반환하는 메소드
		// => PreparedStatement 객체에 저장되는 SQL 명령에서는 ?(InParameter) 기호 사용
		//InParameter : Java 변수값을 제공받아 SQL 명령에 문자값으로 포함하기 위한 기호 
		String sql1="insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql1);//미완성된 SQL 명령이 저장
		
		//PreparedStatement.setXXX(int parameterIndex, XXX value) 
		// => PreparedStatement 객체에 저장된 SQL 명령의 InParameter에 Java 변수값을 전달하는 메소드
		// => XXX : InParameter에 전달하기 위한 Java 변수의 Java 자료형
		// => parameterIndex : InParameter의 위치값(첨자 - 1부터 1씩 증가되는 정수값)
		// => 반드시 모든 InParameter에 Java 변수값을 전달해야만 완전한 SQL 명령을 완성하여
		//DBMS 서버에 전달하여 실행 가능 - 미완성된 SQL 명령을 전달할 경우 예외 발생
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		//PreparedStatement.executeUpdate() : PreparedStatement 객체에 저장된 DML 명령을
		//DBMS 서버에 전달하여 실행하고 조작행의 갯수를 정수값(int)으로 반환하는 메소드
		int rows=pstmt.executeUpdate();
		
		System.out.println(rows+"명의 학생정보를 삽입 하였습니다.");
		System.out.println("===============================================================");
		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력 처리
		String sql2="select * from student order by no";
		pstmt=con.prepareStatement(sql2);
		
		//PreparedStatement.executeQuery() : PreparedStatement 객체에 저장된 DQL 명령을
		//DBMS 서버에 전달하여 실행하고 검색행이 저장된 ResultSet 객체를 반환하는 메소드
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("<<학생정보 출력>>");
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name")
				+", 전화번호 = "+rs.getString("phone")+", 주소 = "+rs.getString("address")
				+", 생년월일 = "+rs.getString("birthday").substring(0, 10));
		}
		System.out.println("===============================================================");
		ConnectionFactory.close(con, pstmt, rs);
		*/
		
		//키보드로 이름을 입력받아 STUDENT 테이블에 저장된 학생정보 중 해당 이름의 학생정보를
		//검색하여 출력하는 JDBC 프로그램 작성

		//키보드로 학생정보를 입력받기 위한 입력스트림을 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//키보드로 이름을 입력받아 저장
		System.out.println("<<학생정보 검색>>");
		System.out.print("이름 입력 >> ");
		String name=in.readLine();
		System.out.println("===============================================================");
		//STUDENT 테이블에 저장된 학생정보 중 해당 이름의 학생정보를 검색하여 출력
		Connection con=ConnectionFactory.getConnection();
		
		String sql="select * from student where name=? order by no";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("<<검색결과>>");
		if(rs.next()) {
			do {
				System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name")
					+", 전화번호 = "+rs.getString("phone")+", 주소 = "+rs.getString("address")
					+", 생년월일 = "+rs.getString("birthday").substring(0, 10));
			} while(rs.next());
		} else {
			System.out.println("검색된 학생정보가 없습니다.");
		}
		System.out.println("===============================================================");
 		ConnectionFactory.close(con, pstmt, rs);		
	}
}
