package xyz.itwill09.dao;

import java.util.List;

import xyz.itwill09.dto.PointBoard;

public interface PointBoardDAO {
	int insertPointBoard(PointBoard board);
	int deletePointBoard(int idx);
	PointBoard selectPointBoard(int idx);
	List<PointBoard> selectPointBoardList();
}
