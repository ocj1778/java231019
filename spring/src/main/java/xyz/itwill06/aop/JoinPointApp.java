package xyz.itwill06.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JoinPointApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("06-2_param.xml");
		JoinPointBean bean=context.getBean("joinPointBean", JoinPointBean.class);
		System.out.println("==============================================================");
		bean.add();
		System.out.println("==============================================================");
		bean.modify(1000, "홍길동");
		System.out.println("==============================================================");
		bean.remove(2000);
		System.out.println("==============================================================");
		bean.getName();
		System.out.println("==============================================================");
		bean.calc(20, 10);
		//bean.calc(20, 0);
		System.out.println("==============================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
