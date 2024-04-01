package xyz.itwill.spring;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill09.dto.PointBoard;
import xyz.itwill09.dto.PointUser;
import xyz.itwill09.service.PointBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
public class PointBoardServiceTest {
	@Autowired
	private PointBoardService pointBoardService;
	
	@Test
	public void test1() {
		PointBoard board=PointBoard.builder().writer("abc123").content("테스트").build();
	
		//PointBoardService 객체로 addPointBoard() 메소드를 호출하여 POINT_BOARD 테이블에 행 삽입 처리
		// => POINT_USER 테이블의 행에서 게시글 작성자에 대한 POINT 컬럼값이 증가되도록 변경 처리
		// => POINT_USER 테이블에서 게시글 작성자에 대한 행을 검색하여 PointUserDTO 객체로 반환
		PointUser user=pointBoardService.addPointBoard(board);
		
		log.info(user.toString());
		
		log.info(pointBoardService.getPointBoardList().toString());
	}
	
	/*
	@Test
	public void test2() {
		//PointBoardService 객체로 removePointBoard() 메소드를 호출하여 POINT_BOARD 테이블에 행 삭제 처리
		// => POINT_USER 테이블의 행에서 게시글 작성자에 대한 POINT 컬럼값이 감소되도록 변경 처리
		// => POINT_USER 테이블에서 게시글 작성자에 대한 행을 검색하여 PointUserDTO 객체로 반환
		PointUser user=pointBoardService.removePointBoard(1);
		
		log.info(user.toString());
		
		log.info(pointBoardService.getPointBoardList().toString());
	}
	*/
}














