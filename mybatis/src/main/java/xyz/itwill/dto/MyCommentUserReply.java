package xyz.itwill.dto;

import java.util.List;

//MYCOMMENT 테이블과 MYSUER 테이블에 저장된 행을 1:1 관계로 결합하고 MYCOMMENT 테이블과
//MYREPLY 테이블(MYUSER 테이블)을 1:N 관계로 결합하여 검색한 결과값을 저장하기 위한 클래스
public class MyCommentUserReply {
	//MYCOMMENT 테이블의 검색행(게시글정보)에 컬럼값을 저장하기 위한 필드
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;
	
	//MYUSER 테이블의 검색행(회원정보 - 게시글) 1개를 객체로 제공받아 저장하기 위한 필드
	private MyUser user;
	
	//MYREPLY 테이블의 검색행(댓글정보) 0개 이상을 객체로 제공받아 저장하기 위한 필드
	// => List 객체의 요소에는 MYREPLY 테이블과 MYUSER 테이블에 저장된 행을 1:1 관계로 결합하여
	//검색된 결과값을 저장할 수 있는 클래스를 사용하여 작성
	private List<MyReplyUser> replyUserList;
	
	public MyCommentUserReply() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public List<MyReplyUser> getReplyUserList() {
		return replyUserList;
	}

	public void setReplyUserList(List<MyReplyUser> replyUserList) {
		this.replyUserList = replyUserList;
	}
}
