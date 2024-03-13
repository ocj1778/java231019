package xyz.itwill03.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object=new HelloMessageObject();
		MessagePrintObject print=new MessagePrintObject();
		//매개변수에 객체를 전달하여 필드에 저장 - 포함관계 완성
		print.setObject(object);
		print.messagePrint();
		*/
		
		//ApplicationContext 객체 : 스프링 컨테이너(Spring Container) 기능을 제공하기 위한 객체
		// => Spring Bean Configuration File(XML)을 제공받아 객체(Spring Bean)를 생성하여 관리	
		ApplicationContext context=new ClassPathXmlApplicationContext("03_message.xml");
		
		//스프링 컨테이너에게 필요한 객체(Spring Bean)을 제공받아 저장
		MessagePrintObject print=(MessagePrintObject)context.getBean("messagePrintObject");
		
		print.messagePrint();
		
		//ApplicationContext 객체 제거 - 스프링 컨테이너 소멸
		// => 스프링 컨테이너가 관리하는 모든 객체(Spring Bean) 소멸
		((ClassPathXmlApplicationContext)context).close();
	}
}
