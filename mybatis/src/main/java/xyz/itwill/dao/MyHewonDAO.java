package xyz.itwill.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xyz.itwill.dto.MyHewon;
import xyz.itwill.mapper.MyHewonMapper;

public class MyHewonDAO extends AbstractSession {
	private static MyHewonDAO _dao;
	
	private MyHewonDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyHewonDAO();
	}
	
	public static MyHewonDAO getDAO() {
		return _dao;
	}
	
	public int insertHewon(MyHewon hewon) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).insertHewon(hewon);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectHewonList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectHewonList();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectDiscriminatorHewonList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectDiscriminatorHewonList();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectStatusHewonList(int status) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectStatusHewonList(status);
		} finally {
			sqlSession.close();
		}
	}
}




