package xyz.itwill.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//태그 클래스 : JSP 문서에서 커스텀 태그를 사용할 경우 호출될 메소드가 작성된 클래스
// => TagSupport 클래스, BodyTagSupport 클래스, SimpleTagSupport 클래스 중 하나를 상속받아 작성
// => 커스텀 태그 사용시 자동 호출되는 메소드는 부모클래스의 메소드를 오버라이드 선언하여 작성

//태그 속성과 태그 내용이 없는 커스텀 태그 클래스
public class HelloTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//JSP 문서에서 커스텀 태그를 최초로 사용할 경우 태그 클래스를 객체로 생성하기 위해 한번만 호출
	public HelloTag() {
		System.out.println("HelloTag 클래스의 기본 생성자 호출 - 객체 생성");
	}
	
	//JSP 문서에서 커스텀 태그의 시작태그를 사용할 때마다 자동 호출되는 메소드
	@Override
	public int doStartTag() throws JspException {
		System.out.println("HelloTag 클래스의 doStartTag() 메소드 호출");
		return super.doStartTag();
	}
	
	//JSP 문서에서 커스텀 태그의 태그내용를 사용할 때마다 자동 호출되는 메소드
	@Override
	public int doAfterBody() throws JspException {
		System.out.println("HelloTag 클래스의 doAfterBody() 메소드 호출");
		return super.doAfterBody();
	}
	
	//JSP 문서에서 커스텀 태그의 종료태그를 사용할 때마다 자동 호출되는 메소드
	@Override
	public int doEndTag() throws JspException {
		System.out.println("HelloTag 클래스의 doEndTag() 메소드 호출");
		return super.doEndTag();
	}
}
