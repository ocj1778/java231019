package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.MyComment1;

public interface MyCommentMapper {
	int insertCopmment1(MyComment1 comment);
	List<MyComment1> selectCommentList1();
}
