package xyz.itwill.spring;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill09.dto.PointBoard;
import xyz.itwill09.dto.PointUser;
import xyz.itwill09.service.PointBoardService;

//Spring 프레임워크에서 TranscationManager 객체를 사용하여 트렌젝션 처리하는 방법
//1.spring-tx 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
// => spring-jdbc 라이브러리를 빌드 처리하면 라이브러리 의존 관계에 의해 자동으로 빌드 처리
//2.Spring Bean Configuration File(root-context.xml)에 TranscationManager 관련 클래스를 Spring Bean으로 등록
//3.Spring Bean Configuration File(servlet-context.xml)에 트렌젝션 처리를 위한 AOP 설정
// => 트렌젝션 처리를 위한 AOP 설정 대신 @Transactional 어노테이션을 사용하여 트렌젝션 처리 가능

//트렌젝션 처리 기능을 제공받기 위한 메소드에 @Transactional 어노테이션을 사용하면 메소드의
//명령 실행시 예외가 발생될 경우 TranscationManager 객체에 의해 롤백 처리 가능
// => @Transactional 어노테이션을 사용하기 위해서는 Spring Bean Configuration File(root-context.xml)에
//tx 네임스페이스를 추가하여 spring-tx.xsd 파일의 annotation-driven 엘리먼트를 제공받아 설정
// => Service 클래스의 메소드에 @Transactional 어노테이션을 사용하면 예외 발생시 롤백 처리
// => Test 클래스의 테스트 메소드에 @Transactional 어노테이션을 사용하면 테스트 종료 후 롤백 처리

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
public class PointBoardServiceTest {
	@Autowired
	private PointBoardService pointBoardService;

	@Transactional
	@Test
	public void test1() {
		//PointBoard board=PointBoard.builder().writer("abc123").content("테스트").build();
		PointBoard board=PointBoard.builder().writer("xyz789").content("테스트").build();
	
		//PointBoardService 객체로 addPointBoard() 메소드를 호출하여 POINT_BOARD 테이블에 행 삽입 처리
		// => POINT_USER 테이블의 행에서 게시글 작성자에 대한 POINT 컬럼값이 증가되도록 변경 처리
		// => POINT_USER 테이블에서 게시글 작성자에 대한 행을 검색하여 PointUserDTO 객체로 반환
		// => 매개변수로 전달받은 게시글에서 게시글 작성자가 POINT_USER 테이블에 저장된 회원이 아닌 경우 예외 발생
		//문제점)예외 발생전에 실행된 게시글 삽입에 대한 SQL 명령은 이미 DBMS 서버에 전달되어
		//실행된 상태이므로 POINT_BOARD 테이블에는 비정상적인 행 삽입 처리
		// => POINT_BOARD 테이블에 게시글 작성자가 없는 게시글 저장 - 게시글을 검색하여 출력할 경우 비정상적인 결과 발생
		//해결법)예외가 발생되기 전에 실행된 SQL 명령(INSERT, UPDATE, DELETE)에 대한 모두 롤백 처리되도록 설정
		// => Spring 프레임워크에서는 TranscationManager 객체를 사용하여 일관성 있는 트렌젝션 
		//관리 기능 제공하여 트렌젝션 처리
		PointUser user=pointBoardService.addPointBoard(board);
		
		log.info(user.toString());
		
		log.info(pointBoardService.getPointBoardList().toString());
	}
	
	/*
	@Transactional
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
