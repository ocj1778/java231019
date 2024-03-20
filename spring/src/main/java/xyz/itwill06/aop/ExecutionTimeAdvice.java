package xyz.itwill06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	/*
	//타겟메소드의 명령이 실행되는 시간을 측정하여 기록하기 위한 메소드 - Around Advice Method
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		//핵심관심코드 실행 전에 삽입되어 실행될 횡단관심코드 작성
		long startTime=System.currentTimeMillis();
		
		//핵심관심모듈의 메소드(타겟메소드 - 핵심관심코드)을 호출하여 결과값을 반환받아 저장
		Object result=joinPoint.proceed();

		//핵심관심코드 실행 후에 삽입되어 실행될 횡단관심코드 작성
		long endTime=System.currentTimeMillis();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		System.out.println(className+" 클래스의 "+methodName+"() 메소드 실행 시간 = "
				+(endTime-startTime)+"ms");
		
		return result;
	}
	*/
	
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		//핵심관심코드 실행 전에 삽입되어 실행될 횡단관심코드 작성
		//StopWatch 클래스 : 시간을 측정하기 위한 기능을 제공하는 클래스
		StopWatch stopWatch=new StopWatch();
		
		//StopWatch.start() : 시간 측정을 시작하는 메소드
		stopWatch.start();
		
		//핵심관심모듈의 메소드(타겟메소드 - 핵심관심코드)을 호출하여 결과값을 반환받아 저장
		Object result=joinPoint.proceed();

		//핵심관심코드 실행 후에 삽입되어 실행될 횡단관심코드 작성
		//StopWatch.stop() : 시간 측정을 종료하는 메소드
		stopWatch.stop();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		//StopWatch.getTotalTimeMillis() : 측정된 시간을 ms 단위로 반환하는 메소드 
		System.out.println(className+" 클래스의 "+methodName+"() 메소드 실행 시간 = "
				+stopWatch.getTotalTimeMillis()+"ms");
		
		return result;
	}
}
