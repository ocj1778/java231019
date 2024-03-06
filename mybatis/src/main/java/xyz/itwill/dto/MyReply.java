package xyz.itwill.dto;

/*
MYREPLY 테이블 : 게시글에 대한 댓글을 저장하기 위한 테이블
create table myreply(reply_no number primary key, reply_id varchar2(50)
    , reply_content varchar2(100), reply_date date, reply_comment_no number);
    
MYREPLY_SEQ 시퀸스 : MYREPLY 테이블의 REPLY_NO 컬럼값으로 저장될 자동 증가값을 제공하는 시퀸스  
create sequence myreply_seq;  

이름               널?       유형            
---------------- -------- ------------- 
REPLY_NO         NOT NULL NUMBER        - 댓글 번호  
REPLY_ID                  VARCHAR2(50)  - 댓글 작성자
REPLY_CONTENT             VARCHAR2(100) - 댓글 내용
REPLY_DATE                DATE          - 댓글 작성일
REPLY_COMMENT_NO          NUMBER        - 게시글 번호 
*/

public class MyReply {
	private int replyNo;
	private String replyId;
	private String replyContent;
	private String replyDate;
	private int replyCommentNo;
	
	public MyReply() {
		// TODO Auto-generated constructor stub
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public int getReplyCommentNo() {
		return replyCommentNo;
	}

	public void setReplyCommentNo(int replyCommentNo) {
		this.replyCommentNo = replyCommentNo;
	}
}
