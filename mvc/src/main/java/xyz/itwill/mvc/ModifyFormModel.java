package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/modifyform.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => 아이디를 전달받아 USEINFO 테이블에 저장된 행을 검색하여 request 객체의 속성값으로 저장하고
//[user_modify.jsp] 문서로 포워드 이동하기 위한 정보가 저장된 ActionForward 객체 반환
// => 관리자만 요청 가능하도록 권한 설정
public class ModifyFormModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
				throw new Exception("비정상적인 요청 - 권한 관련 오류");
			}

			String userid=request.getParameter("userid");
			
			if(userid==null) {
				throw new Exception("비정상적인 요청 - 전달값 미전달 오류");
			}
			
			//UserinfoService 클래스의 getUserinfo() 메소드를 호출하여 반환된 회원정보
			//(UserinfoDTO 객체)를 request 객체의 속성값으로 저장
			request.setAttribute("userinfo", UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(true);
			actionForward.setPath("/model_two/user_modify.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath(request.getContextPath()+"/error.do");
		}
		return actionForward;
	}

}
