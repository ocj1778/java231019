package xyz.itwill09.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.PointUser;
import xyz.itwill09.mapper.PointUserMapper;

@Repository
@RequiredArgsConstructor
public class PointUserDAOImpl implements PointUserDAO {
	private final SqlSession sqlSession;	

	@Override
	public int insertPointUser(PointUser user) {
		return sqlSession.getMapper(PointUserMapper.class).insertPointUser(user);
	}

	@Override
	public int updatePlusPointUser(String id) {
		return sqlSession.getMapper(PointUserMapper.class).updatePlusPointUser(id);
	}

	@Override
	public int updateMinusPointUser(String id) {
		return sqlSession.getMapper(PointUserMapper.class).updateMinusPointUser(id);
	}

	@Override
	public List<PointUser> selectPointUser(String id) {
		return sqlSession.getMapper(PointUserMapper.class).selectPointUser(id);
	}
}
