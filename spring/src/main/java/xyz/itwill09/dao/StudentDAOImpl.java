package xyz.itwill09.dao;

import java.util.List;

import xyz.itwill07.dao.Student;

//DAO 클래스(Repository 클래스) : DBMS 서버 테이블의 행에 대한 삽입, 변경, 삭제, 검색 기능을
//제공하기 위한 클래스
// => DAO 클래스의 메소드는 DBMS 서버에 접속하여 하나의 SQL 명령을 전달하여 실행하고 실행결과를
//Java 객체(값)로 반환되도록 작성 - JDBC
// => DAO 클래스가 교체돼도 의존관계로 설정된 Service 클래스에 영향을 최소화 하기 위해 
//인터페이스를 상속받아 작성하는 것을 권장

//SpringMVC 프레임워크로 웹프로그램 작성시 Mybatis 프레임워크를 사용하여 DAO 클래스를 작성하는 방법
//1.DataSource 관련 라이브러리와 Mybatis 관련 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
// => ojdbc, spring-jdbc(spring-tx), mybatis, mybatis-spring
//2.Mybatis 프레임워크의 환경설정파일(mybatis-config.xml - settings 엘리먼트)을 작성
// => [src/main/webapp] 폴더에 작성해야만 스프링 컨테이너(WebApplication 객체)가 Mybatis 
//프레임워크의 환경설정파일을 읽어 SqlSessionFactory 객체 생성 가능
//3.DataSource 관련 클래스, SqlSessionFactory 관련 클래스, SqlSession 관련 클래스를 Spring Bean으로 등록
// => SpringMVC 프레임워크에서 스프링 컨테이너를 초기화 처리하기 위한 Spring Bean Configuration
//File에서 bean 엘리먼트로 클래스를 Spring Bean으로 등록 - root-context.xml 또는 servlet-context.xml

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> selectStudentList() {
		// TODO Auto-generated method stub
		return null;
	}

}
