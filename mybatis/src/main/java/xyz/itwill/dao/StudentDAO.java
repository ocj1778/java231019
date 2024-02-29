package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.Student;

public class StudentDAO {
	private static StudentDAO _dao;
	
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return _dao;
	}
	
	//SqlSessionFactory 객체를 생성하여 반환하기 위한 메소드
	// => SqlSessionFactory 객체 : SqlSession 객체를 생성하여 제공하기 위한 객체
	// => SqlSessionFactory 객체를 생성하기 위해서는 mybatis 환경설정파일(mybati-config.xml) 필요
	private SqlSessionFactory getSqlSessionFactory() {
		//mybatis 환경설정파일을 패키지 내부에 작성한 경우 파일 시스템 경로로 표현하여 사용 
		//String resource="xyz/itwill/config/mybatis-config.xml";
		String resource="mybatis-config.xml";
		
		InputStream in=null;
		try {
			//mybatis 환경설정파일을 읽기 위한 입력스트림을 반환받아 저장
			//Resources.getResourceAsStream(STring resource) : 매개변수로 mybatis 환경설정파일의
			//경로를 제공받아 파일 입력스트림을 생성하여 반환하는 정적 메소드
			in=Resources.getResourceAsStream(resource);
		} catch (IOException e) {//mybatis 환경설정파일이 없는 경우 예외 발생
			throw new IllegalArgumentException(e);
		}
		
		//SqlSessionFactoryBuilder 객체 : SqlSessionFactory 객체를 생성하는 기능을 제공하는 객체
		//SqlSessionFactoryBuilder.build(InputStream inputStream) : 매개변수로 mybatis 환경설정파일을
		//읽을 수 있는 입력스트림을 제공받아 SqlSessionFactory 객체를 생성하여 반환하는 메소드
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	//STUDENT 테이블에 저장된 모든 행을 검색하여 학생목록을 반환하는 메소드
	// => SqlSession 객체의 메소드를 호출하여 매퍼를 이용하여 SQL 명령을 전달하여 실행하고
	//실행결과를 Java 객체로 반환받아 사용
	public List<Student> selectStudentList() {
		//SqlSessionFactory.openSession() : SqlSession 객체를 생성하여 반환하는 메소드
		// => SqlSession 객체 : 매퍼에 저장된 정보를 사용하여 SQL 명령을 제공받아 실행하고 
		//실행결과를 Java 객체로 매핑 처리하여 반환하는 기능을 제공하는 객체
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		try {
			//SqlSession.selectList(String elementId) : 매퍼에 등록된 SELECT 명령을 제공받아 DBMS 서버에
			//전달하여 실행하고 실행결과를 List 객체로 반환하는 메소드
			// => elementId 매개변수에는 매퍼 식별자(mapper 엘리먼트의 namespace 속성값)와  
			//select 엘리먼트의 식별자(id 속성값)를 이용한 문자열을 전달받아 SQL 명령을 
			//제공받아 DBMS 서버에 전달하여 실행
			return sqlSession.selectList("xyz.itwill.mapper.StudnetMapper.selectStudentList");
		} finally {
			sqlSession.close();
		}
	}
}
