package xyz.itwill.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xyz.itwill.dto.MyUser;
import xyz.itwill.mapper.MyUserMapper;

public class MyUserDAO extends AbstractSession {
	private static MyUserDAO _dao;
	
	private MyUserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyUserDAO();
	}
	
	public static MyUserDAO getDAO() {
		return _dao;
	}
	 
	public int insertUser(MyUser user) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyUserMapper.class).insertUser(user);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyUser> selectUserList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyUserMapper.class).selectUserList();
		} finally {
			sqlSession.close();
		}
	}
}
