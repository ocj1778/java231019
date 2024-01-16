package xyz.itwill.dto;

//게시글을 저장하기 위한 GUEST 테이블 생성 
//create table guest(num number primary key, writer varchar2(50), subject varchar2(200)
//	    , content varchar2(1000), regdate date);

//게시글의 글번호를 제공하기 위한 시퀀스 생성 
//create sequence guest_seq;

/*
이름      널?       유형             
------- -------- -------------- 
NUM     NOT NULL NUMBER         - 게시글(방명록) 번호 : 시퀸스로 제공되는 숫자값 저장         
WRITER           VARCHAR2(50)   - 게시글(방명록) 작성자 : 사용자 입력값을 전달받아 저장   
SUBJECT          VARCHAR2(200)  - 게시글(방명록) 제목 : 사용자 입력값을 전달받아 저장
CONTENT          VARCHAR2(1000) - 게시글(방명록) 내용 : 사용자 입력값을 전달받아 저장
REGDATE          DATE           - 게시글(방명록) 작성날짜 : DBMS 서버의 현재 날짜와 시간을 제공받아 저장
*/

//GUEST 테이블의 행(게시글)을 표현하기 위한 DTO 클래스
public class GuestDTO {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String regdate;
	
	public GuestDTO() {
		// TODO Auto-generated constructor stub
	}

	public GuestDTO(int num, String writer, String subject, String content, String regdate) {
		super();
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
