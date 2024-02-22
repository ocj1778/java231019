package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/list.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => USERINFO 테이블에 저장된 모든 행을 검색하여 request 객체의 속성값으로 저장하고 [user_list.jsp]
//문서로 포워드 이동하기 위한 정보가 저장된 ActionForward 객체 반환
// => 로그인 상태의 사용자만 요청 가능하도록 권한 설정
public class ListModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null) {
				throw new Exception("비정상적인 요청 - 권한 관련 오류");
			}
			
			//UserinfoService 클래스의 getUserinfoList() 메소드를 호출하여 회원목록을 List 객체로
			//반환받아 request 객체의 속성값으로 저장
			// => 포워드 이동된 JSP 문서에서 request 객체의 속성값을 반환받아 응답 처리
			request.setAttribute("userinfoList", UserinfoService.getService().getUserinfoList());
			
			actionForward.setForward(true);
			actionForward.setPath("/model_two/user_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath(request.getContextPath()+"/error.do");
		}
		return actionForward;
	}

}
