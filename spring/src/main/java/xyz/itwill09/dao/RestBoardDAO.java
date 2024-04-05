package xyz.itwill09.dao;

import java.util.List;
import java.util.Map;

import xyz.itwill09.dto.RestBoard;

public interface RestBoardDAO {
	int insertRestBoard(RestBoard restBoard);
	int updateRestBoard(RestBoard restBoard);
	int deleteRestBoard(int idx);
	RestBoard selectRestBoard(int idx);
	int selectRestBoardCount();
	List<RestBoard> selectRestBoardList(Map<String, Object> map);
}
