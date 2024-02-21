package xyz.itwill.mvc;

//뷰(View) 관련 정보를 저장하기 위한 클래스
public class ActionForward {
	// => false : 리다이렉트 이동, true : 포워드 이동
	//리다이렉트 이동 : 클라이언트에게 URL 주소(/XXX.do)를 전달하여 재요청해 응답되도록 처리
	// => 클라이언트 브라우저의 요청 URL 주소 변경
	//포워드 이동 : 서블릿(컨트롤러)의 스레드를 JSP(뷰)로 이동하여 응답되도록 처리
	// => 클라이언트 브라우저의 요청 URL 주소 미변경
	private boolean forward;
	
	//페이지 이동에 대한 웹프로그램의 URL 주소를 저장하기 위한 필드
	// => 리다이렉트 이동 : /XXX.do, 포워드 이동 : /XXX.jsp
	private String path;
	
	public ActionForward() {
		// TODO Auto-generated constructor stub
	}

	public boolean isForward() {
		return forward;
	}

	public void setForward(boolean forward) {
		this.forward = forward;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
