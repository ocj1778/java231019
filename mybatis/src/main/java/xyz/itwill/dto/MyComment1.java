package xyz.itwill.dto;

/*
MYCOMMENT 테이블 : 게시글을 저장하기 위한 테이블
create table mycomment(comment_no number primary key, comment_id varchar2(50)
    , comment_content varchar2(100), comment_date date);
    
MYCOMMENT_SEQ 시퀸스 : MYCOMMENT 테이블의 COMMENT_NO 컬럼에 저장될 자동 증가값을 제공하는 시퀸스  
create sequence mycomment_seq;    

이름              널?       유형            
--------------- -------- ------------- 
COMMENT_NO      NOT NULL NUMBER        - 게시글 번호
COMMENT_ID               VARCHAR2(50)  - 게시글 작성자(아이디)
COMMENT_CONTENT          VARCHAR2(100) - 게시글 내용
COMMENT_DATE             DATE          - 게시글 작성일
*/

//테이블의 컬럼명과 같은 이름으로 클래스의 필드명을 작성 - 자동 매핑
// => 스네이크 표기법으로 작성된 컬럼명은 카멜 표기법으로 자동 변경되므로 필드명은 카멜 표기법으로 작성
public class MyComment1 {
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;
	
	public MyComment1() {
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
}
