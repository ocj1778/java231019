package xyz.itwill06.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecutionTimeApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("06-3_timer.xml");
		ExecutionTimeBean bean=context.getBean("executionTimeBean", ExecutionTimeBean.class);
		System.out.println("==============================================================");
		bean.one();
		System.out.println("==============================================================");
		bean.two();
		System.out.println("==============================================================");
		((ClassPathXmlApplicationContext)context).close();		
	}
}
