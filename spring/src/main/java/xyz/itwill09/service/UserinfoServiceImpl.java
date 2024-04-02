package xyz.itwill09.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.UserinfoDAO;
import xyz.itwill09.dto.Userinfo;
import xyz.itwill09.exception.ExistsUserinfoException;
import xyz.itwill09.exception.LoginAuthFailException;
import xyz.itwill09.exception.UserinfoNotFoundException;

//사용자로부터 입력받아 전달된 문자열(비밀번호)을 암호화 처리하는 방법
//1.jbcrypt 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
//2.BCrypt.hashpw(String password, String salt) 메소드를 호출하여 문자열(비밀번호)을 암호화 처리
// => 매개변수에 암호화 처리할 문자열과 첨가물을 전달받아 암호화 처리 - 첨자물에 의해 비빌번호가 다르게 암호화 처리
// => BCrypt.gensalt(int log_bounds) : 매개변수에 첨가물의 길이를 전달하여 첨가물을 생성해 반환하는 정적메소드
// - 매개변수가 없는 메소드를 호출하면 첨가물의 길이는 자동으로 [10]으로 설정
//3.BCrypt.checkpw(String plainText, String hashed) 메소드로 암호화된 문자열을 일반 문자열과
//비교하여 다른 경우 [false]를 반환하고 같은 [true]를 반환받아 처리

@Service
@RequiredArgsConstructor
public class UserinfoServiceImpl implements UserinfoService {
	private final UserinfoDAO userinfoDAO;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addUserinfo(Userinfo userinfo) {
		if(userinfoDAO.selectUserinfo(userinfo.getUserid()) != null) {
			//예외를 명확히 구분하여 예외처리시 필요한 값을 제공받기 위해 예외클래스를 작성하여
			//인위적 예외 발생
			throw new ExistsUserinfoException("이미 사용중인 아이디를 입력 하였습니다.", userinfo);
		}
		
		//매개변수로 전달받은 회원정보의 비밀번호를 암호화 처리하여 필드값으로 변경 처리
		String hashedPasword=BCrypt.hashpw(userinfo.getPassword(),BCrypt.gensalt());
		userinfo.setPassword(hashedPasword);
		
		userinfoDAO.insertUserinfo(userinfo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void modifyUserinfo(Userinfo userinfo) {
		if(userinfoDAO.selectUserinfo(userinfo.getUserid()) == null) {
			throw new UserinfoNotFoundException("아이디의 회원정보를 찾을 수 없습니다.");
		}
		
		if(userinfo.getPassword() !=null && !userinfo.getPassword().equals("")) {
			String hashedPasword=BCrypt.hashpw(userinfo.getPassword(),BCrypt.gensalt());
			userinfo.setPassword(hashedPasword);
		}
		
		userinfoDAO.updateUserinfo(userinfo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void removeUserinfo(String userid) {
		if(userinfoDAO.selectUserinfo(userid) == null) {
			throw new UserinfoNotFoundException("아이디의 회원정보를 찾을 수 없습니다.");
		}
		
		userinfoDAO.deleteUserinfo(userid);
	}

	@Override
	public Userinfo getUserinfo(String userid) {
		Userinfo userinfo=userinfoDAO.selectUserinfo(userid);
		if(userinfo == null) {
			throw new UserinfoNotFoundException("아이디의 회원정보를 찾을 수 없습니다.");
		}
		return userinfo;
	}

	@Override
	public List<Userinfo> getUserinfoList() {
		return userinfoDAO.selectUserinfoList();
	}

	@Override
	public Userinfo loginAuth(Userinfo userinfo) {
		Userinfo authUserinfo=userinfoDAO.selectUserinfo(userinfo.getUserid());

		if(authUserinfo ==null) {//아이디 인증 실패
			throw new LoginAuthFailException("아이디의 회원정보가 존재하지 않습니다.", userinfo.getUserid());
		}
		
		if(!BCrypt.checkpw(userinfo.getPassword(), authUserinfo.getPassword())) {//비밀번호 인증 실패
			throw new LoginAuthFailException("아이디가 없거나 비밀번호가 맞지 않습니다.", userinfo.getUserid());
		}
		
		return authUserinfo;
	}
}
