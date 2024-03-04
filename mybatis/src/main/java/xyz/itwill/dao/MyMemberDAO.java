package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.MyMember;

public class MyMemberDAO {
	private static MyMemberDAO _dao;
	
	private MyMemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyMemberDAO();
	}
	
	public static MyMemberDAO getDAO() {
		return _dao;		
	}
	
	private SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis-config.xml";
		
		InputStream in=null;
		try {
			in=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블의 행으로 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertMember(MyMember member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		try {
			//SqlSession.insert(String elementId[, Object parameterValue]) : 매퍼에 등록된
			//insert 엘리먼트의 SQL 명령(INSERT)을 제공받아 DBMS 서버에 전달하여 실행하고
			//삽입행의 갯수를 반환하는 메소드
			// => elementId : 매퍼의 식별자와 엘리먼트의 식별자를 이용한 문자열을 전달
			// => parameterValue : SQL 명령 작성에 필요한 값(객체)를 전달 - 엘리먼트의 
			//parameterType 속성값으로 전달받아 SQL 명령에서 사용
			// => SQL 명령 작성에 필요한 값이 없는 경우 parameterValue 매개변수 생략 가능
			int rows=sqlSession.insert("MyMemberXMLMapper.insertMember", member);
			
			//mybatis 프레임워크는 AutoCommit 기능을 비활성화 처리한 후 SQL 명령을 전달하여 실행
			// => DBMS 서버에 DML 명령을 전달하여 실행한 경우 반드시 커밋 또는 롤백 처리
			if(rows > 0) {
				//SqlSession.commit() : 트렌젝션 적용 명령(COMMIT)을 DBMS 서버에 전달하여 실행하는 메소드 - 커밋 처리
				sqlSession.commit();
			} else {
				//SqlSession.rollback() : 트렌젝션 취소 명령(ROLLBACK)을 DBMS 서버에 전달하여 실행하는 메소드 - 롤백 처리
				sqlSession.rollback();
			}
			
			return rows;
		} finally {
			sqlSession.close();
		}
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블에 저장된 행을 변경하고 변경행의 갯수를 반환하는 메소드

	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 행을 삭제하고 삭제행의 갯수를 반환하는 메소드

	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 행을 검색하여 회원정보로 반환하는 메소드
	
	
	//MYMEMBER 테이블에 저장된 모든 행을 검색하여 회원목록으로 반환하는 메소드
	
}












