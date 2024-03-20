package xyz.itwill07.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//DataSource 객체 : 다수의 Connection 객체를 미리 생성하여 저장한 객체 - DBCP(DataBase Connection Pool)
// => Spring Bean Configuration File에서 DataSource 인터페이스를 상속받은 자식클래스를
//Spring Bean으로 등록하여 필요시 스프링 컨테이너에게 제공받아 사용
//DataSource 인터페이스를 상속받은 자식클래스는 spring-jdbc 라이브러리를 빌드 처리하면 사용 가능 - 메이블 사용 : pom.xml
// => DataSource 관련 라이브러리외에 Driver 관련 라이브러리(ojdbc 라이브러리)도 프로젝트에 빌드 처리

//스프링 컨테이너로부터 DataSource 객체를 제공받아 DataSource 객체에 저장된 Connection 객체를 출력하는 프로그램 
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("07_dao.xml");
		System.out.println("==============================================================");
		DataSource dataSource=context.getBean("dataSource", DataSource.class);
		System.out.println("dataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		System.out.println("connection = "+connection);
		connection.close();
		System.out.println("==============================================================");
		((ClassPathXmlApplicationContext)context).close();	
	}
}









