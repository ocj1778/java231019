package xyz.itwill05.lombok;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOImpl implements MemberDAO {
	public MemberDAOImpl() {
		log.info("### MemberDAOImpl 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertMember(Member member) {
		log.info("*** MemberDAOImpl 클래스의 insertMember(Member member) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int updateMember(Member member) {
		log.info("*** MemberDAOImpl 클래스의 updateMember(Member member) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		log.info("*** MemberDAOImpl 클래스의 deleteMember(String id) 메소드 호출 ***");
		return 0;
	}

	@Override
	public Member selectMember(String id) {
		log.info("*** MemberDAOImpl 클래스의 selectMember(String id) 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Member> selectMemberList() {
		log.info("*** MemberDAOImpl 클래스의 selectMemberList() 메소드 호출 ***");
		return null;
	}

}
