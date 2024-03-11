package xyz.itwill.dao;

import java.util.List;
import java.util.Map;

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
	
	public String selectDtoHewonId(MyHewon hewon) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectDtoHewonId(hewon);
		} finally {
			sqlSession.close();
		}
	}
	
	public String selectMapHewonId(Map<String, Object> map) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectMapHewonId(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertMapHewon(Map<String, Object> map) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).insertMapHewon(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Map<String, Object>> selectMapHewonList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectMapHewonList();
		} finally {
			sqlSession.close();
		}
	}
	
	public String selectParamHewonId(String name, String email) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectParamHewonId(name, email);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectSearchHewonList(Map<String, Object> map) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectSearchHewonList(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectDynamicNameHewonList(String name) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectDynamicNameHewonList(name);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectDynamicIdNameHewonList(Map<String, Object> map) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectDynamicIdNameHewonList(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateHewon(MyHewon hewon) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).updateHewon(hewon);
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateDynamicHewon(MyHewon hewon) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).updateDynamicHewon(hewon);
		} finally {
			sqlSession.close();
		}
	}
}




