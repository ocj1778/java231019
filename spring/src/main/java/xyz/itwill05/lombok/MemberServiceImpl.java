package xyz.itwill05.lombok;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberServiceImpl implements MemberService {
	@Override
	public void addMember(Member member) {
		log.info("*** MemberServiceImpl 클래스의 addMember(Member member) 메소드 호출 ***");
		
	}

	@Override
	public void modifyMember(Member member) {
		log.info("*** MemberServiceImpl 클래스의 modifyMember(Member member) 메소드 호출 ***");
		
	}

	@Override
	public void removeMember(String id) {
		log.info("*** MemberServiceImpl 클래스의 removeMember(String id) 메소드 호출 ***");
		
	}

	@Override
	public Member getMember(String id) {
		log.info("*** MemberServiceImpl 클래스의 getMember(String id) 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Member> getMemberList() {
		log.info("*** MemberServiceImpl 클래스의 getMemberList() 메소드 호출 ***");
		return null;
	}

}
