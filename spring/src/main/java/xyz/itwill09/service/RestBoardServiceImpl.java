package xyz.itwill09.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.RestBoardDAO;
import xyz.itwill09.dto.RestBoard;
import xyz.itwill09.util.Pager;

@Service
@RequiredArgsConstructor
public class RestBoardServiceImpl implements RestBoardService {
	private final RestBoardDAO restBoardDAO;
	
	@Override
	public void addRestBoard(RestBoard restBoard) {
		restBoardDAO.insertRestBoard(restBoard);
	}

	@Override
	public void modifyRestBoard(RestBoard restBoard) {
		restBoardDAO.updateRestBoard(restBoard);
	}

	@Override
	public void removeRestBoard(int idx) {
		restBoardDAO.deleteRestBoard(idx);
	}

	@Override
	public RestBoard getRestBoard(int idx) {
		return restBoardDAO.selectRestBoard(idx);
	}

	@Override
	public Map<String, Object> getRestBoardList(int pageNum) {
		int totalSize=restBoardDAO.selectRestBoardCount();
		
		Pager pager=new Pager(pageNum, totalSize, 5, 5);
		
		Map<String, Object> pageMap=new HashMap<String, Object>();
		pageMap.put("startRow", pager.getStartRow());
		pageMap.put("endRow", pager.getEndRow());
		
		List<RestBoard> restBoardList=restBoardDAO.selectRestBoardList(pageMap);
		
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("pager", pager);
		resultMap.put("restBoardList", restBoardList);
		
		return resultMap;
	}

}
