package xyz.itwill09.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.RestBoard;
import xyz.itwill09.mapper.RestBoardMapper;

@Repository
@RequiredArgsConstructor
public class RestBoardDAOImpl implements RestBoardDAO {
	private final SqlSession sqlSession; 
	
	@Override
	public int insertRestBoard(RestBoard board) {
		return sqlSession.getMapper(RestBoardMapper.class).insertRestBoard(board);
	}
	
	@Override
	public int updateRestBoard(RestBoard board) {
		return sqlSession.getMapper(RestBoardMapper.class).updateRestBoard(board);
	}

	@Override
	public int deleteRestBoard(int idx) {
		return sqlSession.getMapper(RestBoardMapper.class).deleteRestBoard(idx);
	}

	@Override
	public RestBoard selectRestBoard(int idx) {
		return sqlSession.getMapper(RestBoardMapper.class).selectRestBoard(idx);
	}

	@Override
	public int selectRestBoardCount() {
		return sqlSession.getMapper(RestBoardMapper.class).selectRestBoardCount();
	}

	@Override
	public List<RestBoard> selectRestBoardList() {
		return sqlSession.getMapper(RestBoardMapper.class).selectRestBoardList();
	}

}
