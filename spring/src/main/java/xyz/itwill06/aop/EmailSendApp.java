package xyz.itwill06.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailSendApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("06-4_email.xml");
		EmailSendBean bean=context.getBean("emailSendBean", EmailSendBean.class);
		System.out.println("==============================================================");
		bean.sendEmail("ocj1778@hanmail.net", "메일 전송 테스트"
				,"<h1>JavaMail 기능을 사용하여 전달된 이메일입니다.</h1>");
		System.out.println("==============================================================");
		((ClassPathXmlApplicationContext)context).close();			
	}
}
