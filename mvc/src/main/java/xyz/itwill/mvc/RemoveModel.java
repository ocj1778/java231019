package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/remove.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => 아이디를 전달받아 USERINFO 테이블에 저장된 행을 삭제하고 [/list.do] 주소로 리다이렉트
//이동하기 위한 정보가 저장된 ActionForward 객체 반환
// => 관리자가 자식의 회원정보를 삭제한 경우 [/logout.do] 주소로 리다이렉트 이동하기 위해 
//정보가 저장된 ActionForward 객체 반환
// => 관리자만 요청 가능하도록 권한 설정
public class RemoveModel implements Action {

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
			
			//UserinfoService 클래스의 removeUserinfo() 메소드를 호출하여 회원정보 삭제 처리
			UserinfoService.getService().removeUserinfo(userid);
			
			actionForward.setForward(false);
			if(loginUserinfo.getUserid().equals(userid)) {
				actionForward.setPath(request.getContextPath()+"/logout.do");
			} else {
				actionForward.setPath(request.getContextPath()+"/list.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath(request.getContextPath()+"/error.do");
		}
		return actionForward;
	}

}
