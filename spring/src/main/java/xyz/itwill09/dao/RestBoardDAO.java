package xyz.itwill09.dao;

import java.util.List;

import xyz.itwill09.dto.RestBoard;

public interface RestBoardDAO {
	int insertRestBoard(RestBoard board);
	int updateRestBoard(RestBoard board);
	int deleteRestBoard(int idx);
	RestBoard selectRestBoard(int idx);
	int selectRestBoardCount();
	List<RestBoard> selectRestBoardList();
}
