package xyz.itwill09.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.UserinfoDAO;
import xyz.itwill09.dto.Userinfo;

@Service
@RequiredArgsConstructor
public class UserinfoServiceImpl implements UserinfoService {
	private final UserinfoDAO userinfoDAO;

	@Override
	public void addUserinfo(Userinfo userinfo) {
		if(userinfoDAO.selectUserinfo(userinfo.getUserid()) != null) {
			//예외를 명확히 구분하여 예외처리시 필요한 값을 제공받기 위해 예외클래스를 작성하여
			//인위적 예외 발생
		}
	}

	@Override
	public void modifyUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUserinfo(String userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Userinfo getUserinfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Userinfo> getUserinfoList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Userinfo loginAuth(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
