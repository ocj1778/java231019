package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//키보드로 SQL 명령을 입력받아 DBMS 서버에 전달하여 실행하고 실행결과를 출력하는 JDBC 프로그램 작성
// => 키보드로 INSERT,UPDATE,DELETE,SELECT 명령만 입력받아 실행되도록 작성
// => SQL 명령은 [exit] 명령을 입력하기 전까지 반복적으로 실행되도록 작성 - 대소문자 미구분
// => 입력받은 SQL 명령이 잘못된 경우 에러 메세지를 제공받아 출력 처리되도록 작성
public class SqlMinusApp {
	public static void main(String[] args) throws SQLException, IOException {
		//키보드로 SQL 명령을 입력받기 위한 입력스트림 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		Connection con=ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=null;
		
		System.out.println("[메세지]SQLMinus 프로그램을 실행합니다.(종료 : exit)");
		
		//키보드로 SQL 명령을 입력받아 DBMS 서버에 전달하여 실행하고 실행결과를 제공받아
		//출력 처리하기 위한 반복문
		while(true) {
			//키보드로 SQL 명령을 입력받아 변수에 저장
			System.out.print("SQL> ");
			//키보드로 입력받은 문자열의 앞과 뒤에 존재하는 모든 공백을 제공한 후 변수에 저장
			String sql=in.readLine().trim();
			
			//키보드 입력값이 없는 경우 반복문을 처음부터 다시 실행
			if(sql==null || sql.equals("")) continue;
			
			//키보드 입력값이 [exit]인 경우 반복문 종료
			if(sql.equalsIgnoreCase("exit")) break;
				
			try {
				//if 구문의 조건식 대신 Statement 객체의 execute() 메소드를 호출하여 DBMS 서버에 SQL 
				//명령을 전달하여 실행하고 실행된 명령을 구분하여 원하는 기능을 제공하기 위한 선택문
				if(stmt.execute(sql)) {//SELECT 명령을 전달하여 실행한 경우
					rs=stmt.getResultSet();
					
					if(rs.next()) {//검색행이 있는 경우
						//검색행의 컬럼정보가 저장된 ResultSetMetaData 객체를 반환받아 저장
						ResultSetMetaData rsmd=rs.getMetaData();
						
						//검색행의 컬럼 갯수를 반환받아 저장
						int columnCount=rsmd.getColumnCount();
						
						System.out.println("====================================================================================");
						//검색행의 컬럼명을 반환받아 출력하기 위한 반복문
						for(int i=1;i<=columnCount;i++) {
							System.out.print(rsmd.getColumnLabel(i)+"\t");
						}
						System.out.println();
						System.out.println("====================================================================================");
						
						
						//ResultSet 객체에 저장된 검색행을 차례대로 제공받아 처리하는 반복문
						do {
							//ResultSet 커서 위치의 처리행에 모든 컬럼값을 문자열로 반환받아
							//저장하기 위한 반복문
							for(int i=1;i<=columnCount;i++) {
								String columnValue=rs.getString(i);
								
								//컬럼의 자료형이 날짜형인 경우
								if(rsmd.getColumnTypeName(i).equals("DATE")) {
									//[yyyy-MM-dd] 패턴의 문자열로 분리하여 저장
									columnValue=columnValue.substring(0, 10);
								}
								
								if(columnValue==null) {//컬럼값이 없는 경우
									columnValue="";
								}
								System.out.print(columnValue+"\t");
							}
							System.out.println();
						} while(rs.next());
					} else {//검색행이 없는 경우
						System.out.println("검색된 결과(행)가 없습니다.");
					}
				} else {//INSERT,UPDATE,DELETE 명령을 전달하여 실행한 경우
					int rows=stmt.getUpdateCount();
					System.out.println(rows+"개의 행을 "+sql.substring(0, 6).toUpperCase()+" 하였습니다.");
				}
			} catch (SQLException e) {
				//키보드로 입력받아 DBMS 서버에 전달되어 실행된 SQL 명령이 잘못된 경우에
				//발생된 SQLException에 대한 예외 처리 명령 작성
				System.out.println("SQL 오류 = "+e.getMessage());
			}
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("[메세지]SQLMinus 프로그램을 종료합니다.");
	}
}
