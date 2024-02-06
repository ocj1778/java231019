package xyz.itwill.dto;

//create table ajax_comment(num number primary key, writer varchar2(50)
//	    , content varchar2(500), regdate date);

//create sequence ajax_comment_seq;
  
public class AjaxCommentDTO {
	private int num;
	private String writer;
	private String content;
	private String regdate;
	
	public AjaxCommentDTO() {
		// TODO Auto-generated constructor stub
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
