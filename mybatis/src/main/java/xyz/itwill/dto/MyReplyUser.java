package xyz.itwill.dto;

//MYREPLY 테이블과 MYUSER 테이블에 저장된 행을 1:1 관계로 결합하여 검색 결과값을 저장하기 위한 클래스
public class MyReplyUser {
	//MYREPLY 테이블의 검색행(댓글정보) 1개를 객체로 제공받아 저장하기 위한 필드
	private MyReply reply;
	
	//MYUSER 테이블의 검색행(회원정보) 1개를 객체로 제공받아 저장하기 위한 필드
	private MyUser user;
	
	public MyReplyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyReply getReply() {
		return reply;
	}

	public void setReply(MyReply reply) {
		this.reply = reply;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
}
