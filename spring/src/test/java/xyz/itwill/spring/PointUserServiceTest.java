package xyz.itwill.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill09.dto.PointUser;
import xyz.itwill09.service.PointUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
public class PointUserServiceTest {
	@Autowired
	private PointUserService pointUserService;
	
	//예외가 발생되지 않아도 @Transactional 어노테이션에 의해 롤백 처리
	@Transactional
	@Test
	public void testAddPointUser() {
		//PointUser user=PointUser.builder().id("abc123").name("홍길동").build();
		PointUser user=PointUser.builder().id("xyz789").name("임꺽정").build();
		
		PointUser addUser=pointUserService.addPointUser(user);
		
		log.info(addUser.toString());
	}
}










