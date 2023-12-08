package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC(Java DataBase Connectivity) : Java 프로그램을 사용하여 DBMS 서버에 접속해 SQL 명령을
//전달하여 실행하기 위한 기능을 제공하는 Java API(인터페이스 또는 클래스)

//java.sql : JDBC 프로그램을 작성하기 위한 Java 자료형이 선언된 패키지
// => java.sql 패키지에는 JDBC 기능을 구현하기 위한 인터페이스 제공
// => DBMS 종류가 다양하여 JDK 라이브러리(jrt-fs.jar)에서 JDBC 관련 클래스를 제공 불가능
// => DBMS 서버 프로그램을 개발하여 관리하는 그룹에서 JDBC 기능의 클래스(JDBC Driver)를
//만들어 배포하므로 JDBC Driver 관련 라이브러리를 다운로드 받아 프로젝트에 빌드 처리

//Oracle DBMS 서버에 접속하기 위한 JDBC 프로그램을 작성하기 위해 Oracle JDBC Driver 관련 
//라이브러리를 빌드 처리하는 방법
//1.https://www.oracle.com 사이트에서 Oracle JDBC Driver 관련 라이브러리 파일을 다운로드
// => Oracle JDBC Driver 관련 라이브러리 파일 : ojdbc11.jar - JDK 버전 참고
//2.Oracle JDBC Driver 관련 라이브러리 파일(ojdbc11.jar)을 프로젝트 폴더에 복사하여 붙여넣기
//3.프로젝트 폴더에 저장된 라이브러리 파일을 프로젝트에 연결하여 프로그램 작성할 때 사용할 수 
//있도록 빌드(Build) 처리 
// => 라이브러리 파일에 작성된 인터페이스 또는 클래스를 프로젝트의 클래스에서 사용할 수 있도록 설정
// => 프로젝트 >> 마우스 오른쪽 버튼 >> Properties >> Java Build Path >> Libraries >>
//    classpath >> Add Jars >> 프로젝트 폴더의 Jar 파일을 선택 >> Apply And Close

//STUDENT 테이블 : 학생정보를 저장하기 위핸 테이블 
// => 학번(숫자형-PRIMARY KEY),이름(문자형),전화번호(문자형),주소(문자형),생년월일(문자형)
//CREATE TABLE STUDENT(NO NUMBER(4) PRIMARY KEY,NAME VARCHAR2(50), PHONE VARCHAR2(20)
//	,ADDRESS VARCHAR2(100),BIRTHDAY DATE);

//STUDENT 테이블에 행(학생정보)를 삽입하는 JDBC 프로그램 작성
public class InsertStudentApp {
	public static void main(String[] args) {
		//JDBC 관련 객체를 저장하기 위한 참조변수는 try 영역 외부에서 선언
		// => try 영역을 포함한 모든 영역에서 참조변수를 이용해 객체를 참조하여 사용 가능
		Connection con=null;
		Statement stmt=null;
		try {
			//1.OracleDriver 클래스를 객체로 생성하여 DriverManager 클래스에 JDBC Driver 객체로 등록
			// => OracleDriver 클래스를 읽어 메모리에 저장하면 자동으로 OracleDriver 객체가
			//생성되어 DriverManager 클래스에 JDBC Driver 객체로 등록 처리 
			
			//DriverManager 클래스 : Driver 객체를 관리하기 위한 기능을 제공하는 클래스
			// => DriverManager 클래스에 Driver 객체를 JDBC Driver 객체로 등록해야 DBMS 서버에 접속 가능 
			//Driver 객체 : DBMS 서버에 접속할 수 있는 기능을 제공하는 객체
			//DriverManager.registerDriver(Driver driver) : 매개변수로 Driver 객체를 전달받아
			//DriverManager 클래스가 관리할 수 있는 JDBC Driver 객체로 등록하는 정적 메소드
			// => 동일한 클래스로 생성된 Driver 객체가 DriverManager 클래스에 여러개 등록 가능
			// => 불필요한 JDBC Driver 객체가 존재해 성능의 저하 발생 가능 
			//DriverManager.registerDriver(new OracleDriver());
			
			//Class.forName(String className) 메소드를 호출하여 ClassLoader 프로그램을 사용해
			//OracleDriver 클래스를 읽어 메모리에 저장
			// => OracleDriver 클래스의 정적영역에서 OracleDriver 클래스로 객체를 생성하여
			//DriverManager 클래스의 JDBC Driver 객체로 등록 처리
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.DriverManager 클래스에 등록된 JDBC Driver 객체를 사용하여 DBMS 접속하여
			//Connection 객체를 반환받아 저장
			//Connection 객체 : DBMS 서버에 접속된 정보를 저장한 객체
			//DriverManager.getConnection(String url, String username, String password)
			// => DriverManager 클래스에 등록된 JDBC Driver 객체를 사용하여 DBMS 서버에 접속하는 정적 메소드
			// => DBMS 서버에 정상적으로 접속된 경우 접속 정보가 저장된 Connection 객체 반환
			// => 접속을 위한 URL 주소의 프로토콜을 사용하여 원하는 DBMS 서버 접속
			//URL(Uniform Resource Location) : 인터넷에 존재하는 자원의 위치를 표현하는 주소
			//형식) Protocol:ServerName:Port:Resource >> https://www.itwill.xyz:80/test/index.html
			//Oracle DBMS 서버에 접속하여 데이타베이스에 접근하기 위한 URL 주소
			//형식) jdbc:oracle:thin:@ServierName:Port:SID
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott";
			String password="tiger";
			//JDBC 관련 클래스의 메소드를 호출한 경우 반드시 SQLException 발생 - 일반 예외
			con=DriverManager.getConnection(url, username, password);
			
			//3.Connection 객체로부터 SQL 명령을 DBMS 서버에 전달할 수 있는 Statement 객체를 반환받아 저장
			//Connection.createStatement() : SQL 명령을 DBMS 서버에 전달할 수 있는 Statement 
			//객체를 반환하는 메소드
			stmt=con.createStatement();
			
			//4.Statement 객체의 메소드를 호출하여 SQL 명령(INSERT,UPDATE,DELETE,SELECT 등)을
			//DBMS 서버에 전달하여 실행하고 실행결과를 반환받아 저장
			//Statement.executeUpdate(String sql) : DML 명령(INSERT,UPDATE,DELETE)을 전달하여 실행하는 메소드
			// => DML 명령의 실행결과로 조작행의 갯수를 정수값으로 반환
			//Statement.executeQuery(String sql) : DQL 명령(SELECT)을 전달하여 실행하는 메소드
			// => DQL 명령의 실행결과로 검색행이 저장된 ResultSet 객체로 반환
			//String sql="insert into student values(1000,'홍길동','010-1234-5678','서울시 강남구','01/01/01')";
			//String sql="insert into student values(2000,'임꺽정','010-7894-5612','수원시 월정구','02/05/08')";
			String sql="insert into student values(3000,'전우치','010-1478-2589','인천시 상당구','1998-12-11')";
			int rows=stmt.executeUpdate(sql);
			
			//5.반환받은 SQL 명령의 실행결과를 사용자에게 제공
			System.out.println("[메세지]"+rows+"명의 학생정보를 삽입 하였습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
		} finally {
			//6.JDBC 관련 객체를 모두 삭제 처리 - 객체가 생성된 순서의 반대로 삭제
			// => Connection 객체를 삭제하여 DBMS 서버의 접속 종료
			try {
				//Statement.close() : Statement 객체를 삭제하는 메소드
				// => NullPointerException 발생 가능 - if 명령을 사용하여 예외 발생 방지
				//NullPointerException : 참조변수에 NULL이 저장된 상태에서 메소드를 호출한 경우 발생되는 예외
				if(stmt!=null) stmt.close();
				//Connection.close() : Connection 객체를 삭제하는 메소드 - 접속 종료
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
