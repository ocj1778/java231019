package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container 초기화 전 ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
		System.out.println("=============== Spring Container 초기화 후 ===============");
		//ApplicationContext.getBean(String beanName) : 매개변수로 Spring Bean를 구분하기 위한 식별자
		//(BeanName)을 전달받아 스프링 컨테이너로부터 객체(Spring Bean)를 반환하는 메소드
		// => Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		//InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");

		//ApplicationContext.getBean(String beanName, Class<T> clazz) : 스프링 컨테이너로부터
		//매개변수로 BeanName의 Spring Bean을 Class 객체로 형변환하여 반환하는 메소드
		InitDestroyMethodBean bean=context.getBean("initDestroyMethodBean", InitDestroyMethodBean.class);
		
		//bean 엘리먼트를 사용하여 객체가 생성된 후에 메소드가 자동 호출되도록 설정 가능
		//bean.init();//객체의 초기화 처리를 위한 메소드
		
		bean.display();
				
		//bean 엘리먼트를 사용하여 객체가 소멸되기 전에 메소드가 자동 호출되도록 설정 가능
		//bean.destroy();//객체의 마무리 처리를 위한 메소드
		System.out.println("==========================================================");
		context.getBean("lazyInitBean", LazyInitBean.class);
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==========================================================");
	}
}
