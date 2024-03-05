package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.MyMember;

//XML 기반의 매퍼 파일과 바인딩될 Interface 기반의 매퍼 파일 - 인터페이스
public interface MyMemberMapper {
	int insertMember(MyMember member);
	int updateMember(MyMember member);
	int deleteMember(String id);
	MyMember selectMember(String id);
	List<MyMember> selectMemberList();
}
