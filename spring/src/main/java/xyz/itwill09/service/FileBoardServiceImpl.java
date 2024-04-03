package xyz.itwill09.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.FileBoardDAO;
import xyz.itwill09.dto.FileBoard;

@Service
@RequiredArgsConstructor
public class FileBoardServiceImpl implements FileBoardService {
	private final FileBoardDAO fileBoardDAO;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addFileBoard(FileBoard fileBoard) {
		fileBoardDAO.insertFileBoard(fileBoard);
	}

	@Transactional
	@Override
	public void removeFileBoard(int idx) {
		if(fileBoardDAO.selectFileBoard(idx) == null) {
			throw new RuntimeException("게시글을 찾을 수 없습니다.");
		}
		
		fileBoardDAO.deleteFileBoard(idx);
	}

	@Override
	public FileBoard getFileBoard(int idx) {
		FileBoard fileBoard=fileBoardDAO.selectFileBoard(idx);
		if(fileBoard == null) {
			throw new RuntimeException("게시글을 찾을 수 없습니다.");
		}
		return fileBoard;
	}

	//메소드의 매개변수로 요청 페이지 번호를 전달받아 사용
	@Override
	public Map<String, Object> getFileBoardList(int pageNum) {
		//FILE_BOARD 테이블에 저장된 모든 행(게시글)의 갯수를 반환받아 저장
		int titalBoard=fileBoardDAO.selectFileBoardCount();
		int pageSize=5;//하나의 페이지에 출력될 게시글의 갯수를 저장
		int blockSize=5;//하나의 블럭에 출력될 페이지 번호의 갯수를 저장

		
		
		return null;
	}

}















