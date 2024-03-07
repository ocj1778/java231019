package xyz.itwill.dto;

import java.util.List;

//MYCOMMENT 테이블과 MYREPLY 테이블에 저장된 행을 1:N 관계로 결합하여 검색 결과값을 저장하기 위한 클래스
public class MyCommentReply {
	private int commentNo;
	
	//MYCOMMENT 테이블의 검색행(게시글정보) 1개를 객체로 제공받아 저장하기 위한 필드
	private MyComment1 comment;  

	//MYREPLY 테이블의 검색행(댓글정보) 0개 이상을 객체로 제공받아 저장하기 위한 필드
	private List<MyReply> replyList;
	
	public MyCommentReply() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public MyComment1 getComment() {
		return comment;
	}

	public void setComment(MyComment1 comment) {
		this.comment = comment;
	}

	public List<MyReply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<MyReply> replyList) {
		this.replyList = replyList;
	}
}
