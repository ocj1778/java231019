package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트가 [/error.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => [user_error.jsp] 문서로 포워드 이동하기 위한 정보가 저장된 AcrionForward 객체 반환
public class ErrorModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(true);
		actionForward.setPath("/model_two/user_error.jsp");
		return actionForward;
	}

}
