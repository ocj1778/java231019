package xyz.itwill09.mapper;

import java.util.List;
import java.util.Map;

import xyz.itwill09.dto.FileBoard;

public interface FileBoardMapper {
	int insertFileBoard(FileBoard fileBoard);
	int deleteFileBoard(int idx);
	FileBoard selectFileBoard(int idx);
	int selectFileBoardCount();
	List<FileBoard> selectFileBoardList(Map<String, Object> map);
}
