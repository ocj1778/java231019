package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//태그 속성과 태그 내용이 있는 커스텀 태그를 생성하기 위한 클래스
public class HelloBodyTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private boolean test;

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try {
			if(test) {
				pageContext.getOut().println("<h3>");
			} else {
				pageContext.getOut().println("<p>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			if(test) {
				pageContext.getOut().println("님, 안녕하세요.</h3>");
			} else {
				pageContext.getOut().println("님, 반갑습니다.</p>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return EVAL_PAGE;
	}
}
