package xyz.itwill09.service;

import java.util.List;

import xyz.itwill09.dto.PointBoard;
import xyz.itwill09.dto.PointUser;

public interface PointBoardService {
	PointUser addPointBoard(PointBoard board);
	PointUser removePointBoard(int idx);
	List<PointBoard> getPointBoardList();
}
