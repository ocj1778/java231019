package xyz.itwill08.mvc;

//응답 처리하기 위한 뷰정보를 제공하는 기능의 클래스
public class ViewResolver {
	//매개변수로 전달받은 뷰이름으로 응답 처리할 JSP 문서의 경로를 생성하여 반환하는 메소드
	public String getView(String viewName) {
		return "/WEB-INF/mvc/"+viewName+".jsp";
	}
}
