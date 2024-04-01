package xyz.itwill09.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.PointBoardDAO;
import xyz.itwill09.dao.PointUserDAO;
import xyz.itwill09.dto.PointBoard;
import xyz.itwill09.dto.PointUser;

@Service
@RequiredArgsConstructor
public class PointBoardServiceImpl implements PointBoardService {
	private final PointUserDAO pointUserDAO;
	private final PointBoardDAO pointBoardDAO;

	//매개변수로 게시글을 전달받아 POINT_BOARD 테이블에 행으로 삽입하고 게시글 작성자에 대한
	//회원정보를 POINT_USER 테이블에서 검색하여 PointUserDTO 객체로 반환하는 메소드
	// => POINT_USER 테이블에서 게시글 작성자에 대한 행의 POINT 컬럼값이 증가되도록 변경 처리 
	@Override
	public PointUser addPointBoard(PointBoard board) {
		pointBoardDAO.insertPointBoard(board);
		
		//게시글 작성자에 대한 회원정보가 없는 경우 인위적 예외 발생
		// => 예외가 발생된 경우 예외 발생 명령 아래에 작성된 명령은 실행되지 않고 메소드 강제 종료
		if(pointUserDAO.selectPointUser(board.getWriter()) == null) {
			throw new RuntimeException("게시글 작성자가 존재하지 않습니다.");
		}
		
		pointUserDAO.updatePlusPointUser(board.getWriter());
		
		return pointUserDAO.selectPointUser(board.getWriter());
	}

	//매개변수로 글번호을 전달받아 POINT_BOARD 테이블에 저장된 행을 삭제하고 게시글 작성자에
	//대한 회원정보를 POINT_USER 테이블에서 검색하여 PointUserDTO 객체로 반환하는 메소드
	// => POINT_USER 테이블에서 게시글 작성자에 대한 행의 POINT 컬럼값이 감소되도록 변경 처리 
	@Override
	public PointUser removePointBoard(int idx) {
		PointBoard board=pointBoardDAO.selectPointBoard(idx);
		
		if(board == null) {
			throw new RuntimeException("게시글이 존재하지 않습니다.");
		}
		
		pointBoardDAO.deletePointBoard(idx);
		
		//게시글 작성자에 대한 회원정보가 없는 경우 인위적 예외 발생
		// => 예외가 발생된 경우 예외 발생 명령 아래에 작성된 명령은 실행되지 않고 메소드 강제 종료
		if(pointUserDAO.selectPointUser(board.getWriter()) == null) {
			throw new RuntimeException("게시글 작성자가 존재하지 않습니다.");
		}
		
		pointUserDAO.updateMinusPointUser(board.getWriter());
		
		return pointUserDAO.selectPointUser(board.getWriter());
	}

	//POINT_BOARD 테이블에 저장된 모든 행을 검색하여 List 객체로 반환하는 메소드
	@Override
	public List<PointBoard> getPointBoardList() {
		return pointBoardDAO.selectPointBoardList();
	}

}
