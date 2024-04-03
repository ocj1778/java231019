package xyz.itwill09.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.FileBoardDAO;
import xyz.itwill09.dto.FileBoard;
import xyz.itwill09.util.Pager;

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

	//메소드의 매개변수로 요청 페이지 번호를 전달받아 게시글 목록을 검색하여 게시글 목록과
	//페이징 처리 관련 정보를 Map 객체의 엔트리로 추가하여 반환하는 메소드 
	@Override
	public Map<String, Object> getFileBoardList(int pageNum) {
		//FILE_BOARD 테이블에 저장된 모든 행(게시글)의 갯수를 반환받아 저장
		int totalSize=fileBoardDAO.selectFileBoardCount();
		int pageSize=5;//하나의 페이지에 출력될 게시글의 갯수를 저장
		int blockSize=5;//하나의 블럭에 출력될 페이지 번호의 갯수를 저장

		Pager pager=new Pager(pageNum, totalSize, pageSize, blockSize);

		//FileBoardDAO 클래스의 selectFileBoardList() 메소드를 호출하기 위해 매개변수에 전달될 Map 객체 생성
		Map<String, Object> pageMap=new HashMap<String, Object>();
		pageMap.put("startRow", pager.getStartRow());
		pageMap.put("endRow", pager.getEndRow());
		List<FileBoard> fileBoardList=fileBoardDAO.selectFileBoardList(pageMap);
		
		//요청 처리 메소드에게 반환될 처리결과가 저장된 Map 객체 생성
		// => 요청 처리 메소드는 반환받은 Map 객체를 뷰에게 제공하여 출력 처리
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("pager", pager);
		resultMap.put("fileBoardList", fileBoardList);
		
		return resultMap;
	}
}
