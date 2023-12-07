package xyz.itwill.jdbc;

//JDBC(Java DataBase Connectivity) : Java 프로그램을 사용하여 DBMS 서버에 접속해 SQL 명령을
//전달하여 실행하기 위한 기능을 제공하는 Java API(인터페이스 또는 클래스)

//java.sql : JDBC 기능을 프로그램을 작성하기 위한 Java 자료형이 선언된 패키지
// => java.sql 패키지에는 JDBC 기능을 구현하기 위한 인터페이스 제공
// => DBMS 종류가 다양하여 클래스 제공 불가능
// => DBMS 서버 프로그램을 개발하여 관리하는 그룹에서 JDBC 기능을 제공하는 클래스(JDBC Driver)를
//만들어 배포하므로 JDBC Driver 관련 라이브러리를 다운로드 받아 프로젝트에 빌드 처리

//Oracle DBMS 서버를 사용한 JDBC 프로그램을 작성하기 위해 Oracle JDBC Driver 관련 라이브러리를
//빌드 처리하는 방법
//1.https://www.oracle.com 사이트에서 Oracle JDBC Driver 관련 라이브러리 파일을 다운로드
// => Oracle JDBC Driver 관련 라이브러리 파일 : ojdbc11.jar - JDK 버전 참고
//2.Oracle JDBC Driver 관련 라이브러리 파일(ojdbc11.jar)을 프로젝트 폴더에 복사하여 붙여넣기
//3.프로젝트 폴더에 저장된 라이브러리 파일을 프로젝트의 클래스에서 사용할 수 있도록 연결 - 빌드(Build) 
// => 라이브러리 파일에 선언된 인터페이스 또는 클래스를 프로젝트의 클래스에서 사용할 수 있도록 설정
// => 프로젝트 >> 마우스 오른쪽 버튼 >> Properties >> Java Build Path >> Libraries >>
//    classpath >> Add Jars >> 프로젝트 폴더의 Jar 파일을 선택 >> Apply And Close

//STUDENT 테이블 : 학번(숫자형-PRIMARY KEY),이름(문자형),전화번호(문자형),주소(문자형),생년월일(문자형)
//CREATE TABLE STUDENT(NO NUMBER(4) PRIMARY KEY,NAME VARCHAR2(50), PHONE VARCHAR2(20)
//	,ADDRESS VARCHAR2(100),BIRTHDAY DATE);

//STUDENT 테이블에 행(학생정보)를 삽입하는 JDBC 프로그램 작성
public class InsertStudentApp {
	public static void main(String[] args) {
		try {
			//1.OracleDriver 클래스를 객체로 생성하여 DriverManager 클래스에 JDBC Driver 객체로 등록
			
			//DriverManager 클래스 : Driver 객체를 관리하기 위한 기능을 제공하는 클래스
			// => DriverManager 클래스에 Driver 객체를 JDBC Driver 객체로 등록해야 DBMS 서버에 접속 가능 
			//Driver 객체 : DBMS 서버에 접속할 수 있는 기능을 제공하는 객체
			//DriverManager.registerDriver(Driver driver) : 매개변수로 Driver 객체를 전달받아
			//DriverManager 클래스가 관리할 수 있는 JDBC Driver 객체로 등록하는 메소드
			// => 동일한 클래스로 생성된 Driver 객체가 DriverManager 클래스에 여러개 등록 가능
			// => 불필요한 JDBC Driver 객체가 존재해 성능의 저하 발생 가능 
			//DriverManager.registerDriver(new OracleDriver());
			
			//Class.forName(String className) 메소드를 호출하여 ClassLoader 프로그램을 사용해
			//OracleDriver 클래스를 읽어 메모리에 저장
			// => OracleDriver 클래스의 정적영역에서 OracleDriver 클래스로 객체를 생성하여
			//DriverManager 클래스의 DBC Driver 객체로 등록 처리
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver 클래스를 찾을 수 없습니다.");
		}
	}
}












