package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container 초기화 전 ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-2_collection.xml");
		System.out.println("=============== Spring Container 초기화 후 ===============");
		CollectionBean bean=context.getBean("collectionBean", CollectionBean.class);
		
		//CollectionBean 객체의 필드값(콜렉션 객체  - Set 객체, List 객체 등)를 반환받아 출력
		// => 콜렉션 객체의 toString() 메소드 호출 - Collection에 저장된 모든 요소값 출력
		System.out.println("nameSet = "+bean.getNameSet());
		System.out.println("nameList = "+bean.getNameList());
		System.out.println("controllerSet = "+bean.getControllerSet());
		System.out.println("controllerList = "+bean.getControllerList());
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();		
	}
}
