package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.MyReply;

public interface MyReplyMapper {
	int insertReply(MyReply reply);
	List<MyReply> selectReplyList();
}
