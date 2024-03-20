package xyz.itwill06.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAnnotationApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("06-5_aopAnnotation.xml");
		AopAnnotationBean bean=context.getBean("aopAnnotationBean", AopAnnotationBean.class);
		System.out.println("==============================================================");
		bean.display1();
		System.out.println("==============================================================");
		bean.display2();
		System.out.println("==============================================================");
		bean.display3();
		System.out.println("==============================================================");
		((ClassPathXmlApplicationContext)context).close();			
	}
}
