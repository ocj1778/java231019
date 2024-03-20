package xyz.itwill06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//Advice 클래스와 메소드에 AOP 관련 어노테이션을 사용하여 AOP 설정 가능
// => Spring Bean Configuration File에 aspectj-autoproxy 엘리먼트 설정

@Slf4j
@Component
//@Aspect : 핵심관심코드에 횡단관심코드를 삽입하여 실행하기 위한 기능을 제공하는 어노테이션
// => Spring Bean Configuration File의 aspect 엘리먼트와 유사한 기능 제공
@Aspect
public class AopAnnotationAdvice {
	//@Pointcut : 타겟메소드를 지정하기 위한 어노테이션
	// => Spring Bean Configuration File의 pointcut 엘리먼트와 유사한 기능 제공
	// => 메소드를 호출하여 Pointcut 표현식으로 설정된 타겟메소드를 제공받아 사용
	//value 속성 : 타겟메소드를 지정하기 위한 Pointcut 표현식을 속성값으로 설정
	// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
	@Pointcut("within(xyz.itwill06.aop.AopAnnotationBean)")
	public void aopPointcut() {}
	
	//@Before : 타겟메소드의 명령(핵심관심코드)이 실행되기 전에 삽입되어 실행될 횡단관심코드를
	//제공하기 위한 어노테이션
	// => Spring Bean Configuration File의 before 엘리먼트와 유사한 기능 제공
	//value 속성 : 타겟메소드를 지정하기 위한 Pointcut 표현식을 속성값으로 설정
	// => @Pointcut 어노테이션으로 설정된 Pointcut 메소드를 호출하여 Pointcut 표현식을 제공받아 
	//타겟메소드로 지정 가능
	// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
	//@Before("within(xyz.itwill06.aop.AopAnnotationBean)")
	@Before("aopPointcut()")
	public void beforeLog() {
		log.info("[before]핵심관심코드 실행 전에 삽입되어 실행될 횡단관심코드");
	}
	
	//@After : 타겟메소드의 명령(핵심관심코드)이 실행된 후에 예외 발생과 상관없이 무조건 
	//삽입되어 실행될 횡단관심코드를 제공하기 위한 어노테이션
	// => Spring Bean Configuration File의 after 엘리먼트와 유사한 기능 제공
	@After("aopPointcut()")
	public void afterLog() {
		log.info("[after]핵심관심코드 실행 후에 무조건 삽입되어 실행될 횡단관심코드");
	}

	//@AfterReturning : 타겟메소드의 명령(핵심관심코드)이 예외 발생 없이 정상적으로 실행된 후에  
	//삽입되어 실행될 횡단관심코드를 제공하기 위한 어노테이션
	// => Spring Bean Configuration File의 after-returning 엘리먼트와 유사한 기능 제공
	//returning 속성 : 타겟메소드의 반환값을 제공받아 저장할 매개변수의 이름을 속성값으로 설정
	@AfterReturning(value = "aopPointcut()", returning = "returnValue")
	public void afterReturningLog(Object returnValue) {
		log.info("[after-returning]핵심관심코드가 정상적으로 실행된 후에 삽입되어 실행될 횡단관심코드");
	}

	//@AfterThrowing : 타겟메소드의 명령(핵심관심코드)이 실행되면서 예외가 발생되면 삽입되어
	//실행될 횡단관심코드를 제공하기 위한 어노테이션
	// => Spring Bean Configuration File의 after-throwing 엘리먼트와 유사한 기능 제공
	//throwing 속성 : 타겟메소드에서 예외를 제공받아 저장할 매개변수의 이름을 속성값으로 설정
	@AfterThrowing(value = "aopPointcut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		log.info("[after-throwing]핵심관심코드 실행시 예외가 발생된 후 삽입되어 실행될 횡단관심코드");
	}
	
	@Around("aopPointcut()")
	public Object aroungLog(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("[around]핵심관심코드 실행 전에 삽입되어 실행될 횡단관심코드");
		Object result=joinPoint.proceed();
		log.info("[around]핵심관심코드 실행 후에 삽입되어 실행될 횡단관심코드");
		return result;
	}
}
