package xyz.itwill09.service;

import java.util.Map;

import xyz.itwill09.dto.RestBoard;

public interface RestBoardService {
	void addRestBoard(RestBoard restBoard);
	void modifyRestBoard(RestBoard restBoard);
	void removeRestBoard(int idx);
	RestBoard getRestBoard(int idx);
	Map<String, Object> getRestBoardList(int pageNum);
}
