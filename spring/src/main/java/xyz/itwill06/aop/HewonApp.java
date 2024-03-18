package xyz.itwill06.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HewonApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("06-1_aop.xml");
		HewonService service=context.getBean("hewonService", HewonService.class);
		System.out.println("==============================================================");
		service.addHewon(null);
		System.out.println("==============================================================");
		service.getHewon(0);
		System.out.println("==============================================================");
		service.getHewonList();
		System.out.println("==============================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
