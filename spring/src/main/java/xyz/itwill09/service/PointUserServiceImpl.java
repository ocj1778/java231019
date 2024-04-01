package xyz.itwill09.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.PointUserDAO;
import xyz.itwill09.dto.PointUser;

@Service
@RequiredArgsConstructor
public class PointUserServiceImpl implements PointUserService {
	private final PointUserDAO pointUserDAO;
	
	//매개변수로 회원정보를 전달받아 POINT_USER 테이블에 행으로 삽입하고 삽입된 행(회원정보)을
	//검색하여 DTO 객체로 반환하는 메소드
	@Override
	public PointUser addPointUser(PointUser user) {
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
	}

}
