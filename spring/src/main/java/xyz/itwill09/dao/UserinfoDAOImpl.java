package xyz.itwill09.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.Userinfo;
import xyz.itwill09.mapper.UserinfoMapper;

@Repository
@RequiredArgsConstructor
public class UserinfoDAOImpl implements UserinfoDAO {
	private final SqlSession sqlSession;
	
	@Override
	public int insertUserinfo(Userinfo userinfo) {
		return sqlSession.getMapper(UserinfoMapper.class).insertUserinfo(userinfo);
	}

	@Override
	public int updateUserinfo(Userinfo userinfo) {
		return sqlSession.getMapper(UserinfoMapper.class).updateUserinfo(userinfo);
	}

	@Override
	public int deleteUserinfo(String userid) {
		return sqlSession.getMapper(UserinfoMapper.class).deleteUserinfo(userid);
	}

	@Override
	public Userinfo selectUserinfo(String userid) {
		return sqlSession.getMapper(UserinfoMapper.class).selectUserinfo(userid);
	}

	@Override
	public List<Userinfo> selectUserinfoList() {
		return sqlSession.getMapper(UserinfoMapper.class).selectUserinfoList();
	}

}
