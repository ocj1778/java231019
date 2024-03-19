package xyz.itwill06.aop;

//횡단관심모듈
public class JoinPointAdvice {
	//Before Advice Method
	public void beforeDisplay() {
		System.out.println("### [before]핵심관심코드 실행 전에 삽입되어 실행될 횡단관심코드 ###");
	}
}
