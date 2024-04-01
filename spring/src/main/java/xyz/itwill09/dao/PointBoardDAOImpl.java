package xyz.itwill09.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.PointBoard;
import xyz.itwill09.mapper.PointBoardMapper;

@Repository
@RequiredArgsConstructor
public class PointBoardDAOImpl implements PointBoardDAO {
	private final SqlSession sqlSession;

	@Override
	public int insertPointBoard(PointBoard board) {
		return sqlSession.getMapper(PointBoardMapper.class).insertPointBoard(board);
	}

	@Override
	public int deletePointBoard(int idx) {
		return sqlSession.getMapper(PointBoardMapper.class).deletePointBoard(idx);
	}

	@Override
	public PointBoard selectPointBoard(int idx) {
		return sqlSession.getMapper(PointBoardMapper.class).selectPointBoard(idx);
	}

	@Override
	public List<PointBoard> selectPointBoardList() {
		return sqlSession.getMapper(PointBoardMapper.class).selectPointBoardList();
	}

}
