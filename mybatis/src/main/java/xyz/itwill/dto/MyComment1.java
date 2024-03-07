package xyz.itwill.dto;

import java.io.Serializable;

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
//XML 기반의 매퍼 파일에서 cache 엘리먼트를 사용한 경우 SELECT 명령으로 생성되는 객체의 클래스는
//반드시 객체 직렬화 클래스로 선언해야만 객체 단위로 입출력 가능
//객체 직렬화 클래스 : 객체 단위로 입력 또는 출력 처리되도록 작성된 클래스
// => Serializable 인터페이스를 상속받아 작성
// => serialVersionUID 이름의 static final 필드를 선언하는 것을 권장
public class MyComment1 implements Serializable {
	private static final long serialVersionUID = -7534009978055893003L;

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
