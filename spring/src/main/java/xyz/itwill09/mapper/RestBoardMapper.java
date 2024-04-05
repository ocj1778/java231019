package xyz.itwill09.mapper;

import java.util.List;

import xyz.itwill09.dto.RestBoard;

public interface RestBoardMapper {
	int insertRestBoard(RestBoard board);
	int updateRestBoard(RestBoard board);
	int deleteRestBoard(int idx);
	RestBoard selectRestBoard(int idx);
	int selectRestBoardCount();
	List<RestBoard> selectRestBoardList();
}
