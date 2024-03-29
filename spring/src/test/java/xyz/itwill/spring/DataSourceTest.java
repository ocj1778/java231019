package xyz.itwill.spring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;

//SpringTest 기능을 사용하여 모듈(단위 프로그램 - 컴퍼넌트)을 검사하는 테스트 프로그램 작성하는 방법
// => SpringMVC 프로그램에서 사용하는 모듈 : DAO 클래스, Service 클래스, Controller 클래스 등
//1.junit 라이브러리와 spring-test 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
//2.테스트 프로그램에서 사용될 로그 구현체에 대한 환경설정파일 변경
// => [src/test/resources] 패키지 폴더의 [log4j.xml] 파일의 내용 변경
//3.[src/test/java] 패키지 폴더의 패키지에 테스트 클래스(테스트 프로그램) 작성
// => junit 라이브러리와 spring-test 라이브러리의 scope 속성을 주석 처리 후 테스트 클래스를 
//작성하여 실행하고 테스트 종료 후 scope 속성에 설정된 주석 삭제
//4.JUnit 프로그램을 사용하여 테스트 프로그램 실행 - 테스트 클래스의 테스트 메소드 자동 호출 

//@RunWith : 테스트 클래스를 실행하기 위한 실행 클래스를 설정하기 위한 어노테이션
// => 테스트 클래스로 객체를 생성하여 테스트 메소드를 호출하여 테스트 명령 실행
//value 속성 : 테스트 클래스를 실행하기 위한 클래스(Class 객체)를 속성값으로 설정
// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
//SpringJUnit4ClassRunner 클래스를 사용하여 테스트 클래스에 스프링 컨테이너(ApplicationContext 객체)를 생성하여 제공
// => 스프링 컨테이너는 테스트 클래스에서 사용될 객체를 Spring Bean으로 제공
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration : 스프링 컨테이너의 환경설정파일(Spring Bean Configuration File)을 
//제공하기 위한 어노테이션
//locations 속성 : Spring Bean Configuration File의 경로를 요소로 저장한 배열을 속성값으로 설정
// => Spring Bean Configuration File의 경로는 file 접두사를 사용해 파일 시스템 경로로 표현하여 제공
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//@WebAppConfiguration : SpringJUnit4ClassRunner 클래스에게 제공할 스프링 컨테이너를
//ApplicationContext 객체가 아닌 WebApplicationContext 객체로 제공하기 위한 어노테이션
@WebAppConfiguration
@Slf4j
public class DataSourceTest {
	//테스트 클래스의 메소드에서 사용될 객체를 저장하기 위한 필드 작성
	// => @Autowired 어노테이션을 사용하여 필드에 객체(Spring Bean)가 저장되도록 의존성 주입
	// => 필드 레벨의 의존성 주입만 가능 - 생성자 레벨의 의존성 주입시 에러 발생 
	@Autowired
	private DataSource dataSource;

	//@Test : 테스트 메소드로 설정하기 위한 어노테이션 - 모듈 테스트 명령 작성
	// => SpringJUnit4ClassRunner 클래스에 의해 테스트 클래스가 객체로 생성된 후 객체로 자동 호출
	@Test
	public void testDataSource() throws SQLException {
		log.info("DataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		log.info("Connection = "+connection);
		connection.close();
	}
}
