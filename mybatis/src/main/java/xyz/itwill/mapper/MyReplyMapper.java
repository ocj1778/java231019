package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.MyReply;
import xyz.itwill.dto.MyReplyUser;

public interface MyReplyMapper {
	int insertReply(MyReply reply);
	List<MyReply> selectReplyList();
	List<MyReply> selectCountReplyList();
	List<MyReplyUser> selectReplyUserList1();
	List<MyReplyUser> selectReplyUserList2();
}
