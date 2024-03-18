package xyz.itwill05.lombok;

import java.util.List;

public interface MemberService {
	void addMember(Member member);
	void modifyMember(Member member);
	void removeMember(String id);
	Member getMember(String id);
	List<Member> getMemberList();
}
