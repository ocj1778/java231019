package xyz.itwill.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//태그 클래스 : JSP 문서에서 커스텀 태그를 사용할 경우 객체를 생성하기 위한 클래스
// => TagSupport 클래스를 상속받아 작성
public class CustomTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//JSP 문서에서 커스텀 태그를 사용할 경우 태그 클래그의 객체에 의해 자동 호출되는 메소드
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println("<h3>커스텀 태그 사용</h3>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
