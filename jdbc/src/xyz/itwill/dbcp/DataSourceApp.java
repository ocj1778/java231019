package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

//DataSource 인터페이스 : DBCP 클래스를 작성하기 위해 상속받기 위한 인터페이스
// => 모든 DBCP 클래스가 동일한 메소드로 작성되도록 메소드 작성 규칙 제공
// => 클래스의 결합도를 낮춰 유지보수의 효율성 증가

//Oracle 그룹에서 배포한 UCP(Universal Connection Pool) 라이브러리의 DBCP 클래스를 이용한 JDBC 프로그램 작성
// => https://www.oracle.com 사이트에서 UCP 라이브러리 파일(ucp.jar)을 다운로드 받아 프로젝트에 빌드 처리
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		//PoolDataSource 객체(DBCP 기능을 제공하는 객체)를 반환받아 저장
		//PoolDataSourceFactory.getPoolDataSource() : PoolDataSource 객체를 반환하는 정적메소드
		PoolDataSource pds=PoolDataSourceFactory.getPoolDataSource();
		
		//PoolDataSource 객체에 저장될 Connection 객체를 생성하기 위한 메소드 호출 - 필수
		//PoolDataSource.setConnectionFactoryClassName(String driver) 
		// => Connection 객체를 생성하기 위한 JDBC Driver 클래스를 변경하는 메소드
		pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
   
		//PoolDataSource.setURL(String driver) 
		// => Connection 객체를 생성하기 위한 URL 주소를 변경하는 메소드
		pds.setURL("jdbc:oracle:thin:@localhost:1521:xe");

		//PoolDataSource.setUser(String user) 
		// => Connection 객체를 생성하기 위한 사용자 이름을 변경하는 메소드
		pds.setUser("scott");

		//PoolDataSource.setPassword(String password) 
		// => Connection 객체를 생성하기 위한 비밀번호를 변경하는 메소드
		pds.setPassword("tiger");

		//PoolDataSource 객체에 저장될 Connection 객체를 갯수를 제한하기 위한 메소드 - 선택
		// => 메소드 호출을 생략한 경우 기본값을 사용하여 Connection 객체의 갯수 제한
		//PoolDataSource.setInitialPoolSize(int size) 
		// => 최초 생성되는 Connection 객체의 갯수를 변경하는 메소드
		pds.setInitialPoolSize(2);
		//PoolDataSource.setInitialPoolSize(int size) 
		// => 최대 생성 가능한 Connection 객체의 갯수를 변경하는 메소드
		pds.setMaxPoolSize(3);
		
		//PoolDataSource.getConnection() : PoolDataSource 객체에 저장된 Connection 객체 중
		//하나를 반환하는 메소드
		Connection con1=pds.getConnection();
		System.out.println("con1 = "+con1);
		//Connection 객체로 close() 메소드를 호출하면 PoolDataSource 객체에 동일한 Connection 
		//객체를 생성하여 저장 
		//con1.close();
		
		Connection con2=pds.getConnection();
		System.out.println("con2 = "+con2);
		//con2.close();

		Connection con3=pds.getConnection();
		System.out.println("con3 = "+con3);
		//con3.close();
		
		Connection con4=pds.getConnection();
		System.out.println("con4 = "+con4);
		con4.close();
		
	}
}
