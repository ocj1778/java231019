package xyz.itwill09.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.FileBoard;
import xyz.itwill09.mapper.FileBoardMapper;

@Repository
@RequiredArgsConstructor
public class FileBoardDAOImpl implements FileBoardDAO {
	private final SqlSession sqlSession;

	@Override
	public int insertFileBoard(FileBoard fileBoard) {
		return sqlSession.getMapper(FileBoardMapper.class).insertFileBoard(fileBoard);
	}

	@Override
	public int deleteFileBoard(int idx) {
		return sqlSession.getMapper(FileBoardMapper.class).deleteFileBoard(idx);
	}

	@Override
	public FileBoard selectFileBoard(int idx) {
		return sqlSession.getMapper(FileBoardMapper.class).selectFileBoard(idx);
	}

	@Override
	public int selectFileBoardCount() {
		return sqlSession.getMapper(FileBoardMapper.class).selectFileBoardCount();
	}

	@Override
	public List<FileBoard> selectFileBoardList(Map<String, Object> map) {
		return sqlSession.getMapper(FileBoardMapper.class).selectFileBoardList(map);
	}
}
