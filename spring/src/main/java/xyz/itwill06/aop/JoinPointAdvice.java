package xyz.itwill06.aop;

import org.aspectj.lang.JoinPoint;

//횡단관심모듈
public class JoinPointAdvice {
	//Around Advice Method를 제외한 나머지 Advice Method는 일반적으로 반환형을 [void]로 작성하고
	//매개변수를 작성하지 않거나 JoinPoint 인터페이스를 자료형으로 사용하는 매개변수 작성 가능
	// => Advice 클래스의 메소드를 규칙에 맞지 않게 작성한 경우 IllegalArgumentException 발생
	//JoinPoint 객체 : 타겟메소드 관련 정보가 저장된 객체
	// => AspectJ 컴파일러에 의해 Advice 클래스의 메소드가 호출될 때 타겟메소드 관련 정보를 저장한
	//JoinPoint 객체를 매개변수에 전달하여 저장
	// => Advice 클래스의 메소드에서 타겟메소드 관련 정보가 필요한 경우 매개변수를 선언하여
	//JoinPoint 객체를 전달받아 JoinPoint 객체의 메소드를 호출하여 사용 가능
	
	//Before Advice Method
	public void beforeDisplay(JoinPoint joinPoint) {
		//System.out.println("### [before]핵심관심코드 실행 전에 삽입되어 실행될 횡단관심코드 ###");
		
		//JoinPoint.getTarget() : 타겟메소드를 호출한 객체(핵심관심모듈 - Spring Bean)를 반환하는 메소드
		// => Object 타입의 객체 반환
		//Object.getClass() : 객체를 생성한 클래스의 Class 객체를 반환하는 메소드
		//Class.getName() : Class 객체의 클래스(패키지 포함)를 문자열로 반환하는 메소드 
		//System.out.println(joinPoint.getTarget().getClass().getName());
		//Class.getSimpleName() : Class 객체의 클래스(패키지 미포함)를 문자열로 반환하는 메소드 
		//System.out.println(joinPoint.getTarget().getClass().getSimpleName());
		
		//JoinPoint.getSignature() : 타겟메소드의 정보가 저장된 Signature 객체를 반환하는 메소드
		//Signature.getName() : 타겟메소드의 이름을 반환하는 메소드
		//System.out.println(joinPoint.getSignature().getName());
		
		//JoinPoint.getArgs() : 타겟메소드의 매개변수에 저장된 모든 값(객체)을 Object 배열로 반환하는 메소드
		//System.out.println(joinPoint.getArgs());
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		Object[] params=joinPoint.getArgs();
		
		System.out.print("### [before]"+className+" 클래스의 "+methodName+"(");
		for(int i=0;i<params.length;i++) {
			System.out.print(params[i]);
			if(i < params.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println(") 메소드 호출 ###");
	}
}















