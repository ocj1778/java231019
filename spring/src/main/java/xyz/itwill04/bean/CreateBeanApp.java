package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring 프레임워크에서는 BeanFactory 객체 또는 ApplicationContext 객체로 스프링 컨테이너
//(Spring Container) 기능 제공
// => 스프링 컨테이너는 환경설정파일(Spring Bean Configuration File - XML)로 클래스를 제공받아
//객체(Spring Bean)를 생성하여 관리
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1.BeanFactory 객체를 생성하여 스프링 컨테이너로 사용하는 방법");
		System.out.println("=============== Spring Container 초기화 전 ===============");
		//BeanFactory 인터페이스를 상속받은 자식클래스로 객체 생성 - BeanFactory 객체
		// => BeanFactory 객체를 생성할 때 Spring Bean Configuration File을 제공받아 
		//스프링 컨테이너 생성 - 스프링 컨테이너 초기화 작업
		// => BeanFactory 객체는 Spring Bean Configuration File에 등록된 클래스로 객체를 미리
		//생성하지 않고 Spring Bean 제공을 요청할 경우 생성
		BeanFactory factory=new XmlBeanFactory
				(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("=============== Spring Container 초기화 후 ===============");
		//BeanFactory.getBean(String beanName) : 매개변수로 Spring Bean를 구분하기 위한 식별자
		//(BeanName)을 전달받아 스프링 컨테이너로부터 객체(Spring Bean)를 생성하여 반환하는 메소드
		// => Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		// => 매개변수로 전달받은 식별자(BeanName)의 Spring Bean이 없는 경우 NoSuchBeanDefinitionException 발생
		CreateBean bean1=(CreateBean)factory.getBean("createBean");
		bean1.display();
		System.out.println("==========================================================");
		System.out.println("2.ApplicationContext 객체를 생성하여 스프링 컨테이너로 사용하는 방법");
		System.out.println("=============== Spring Container 초기화 전 ===============");
		//ApplicationContext 인터페이스를 상속받은 자식클래스로 객체 생성 - ApplicationContext 객체
		// => ApplicationContext 객체를 생성할 때 Spring Bean Configuration File을 제공받아 
		//스프링 컨테이너 생성 - 스프링 컨테이너 초기화 작업
		// => 클래스가 참조 가능한 폴더(ClassPath)에 작성된 Spring Bean Configuration File을 제공받아 사용
		// => ApplicationContext 객체는 Spring Bean Configuration File에 등록된 클래스로 객체를 미리 생성
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("=============== Spring Container 초기화 후 ===============");
		//ApplicationContext.getBean(String beanName) : 매개변수로 Spring Bean를 구분하기 위한 식별자
		//(BeanName)을 전달받아 스프링 컨테이너로부터 객체(Spring Bean)를 반환하는 메소드
		// => Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		// => 매개변수로 전달받은 식별자(BeanName)의 Spring Bean이 없는 경우 NoSuchBeanDefinitionException 발생
		//DL(Dependency Lookup) : 스프링 컨테이너가 관리하는 Spring Bean를 검색하여 제공하는 기능
		CreateBean bean2=(CreateBean)context.getBean("createBean");
		bean2.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext 객체를 제거하는 메소드
		// => 스프링 컨테이너 소멸전 스프링 컨테이너에 의해 관리되는 모든 객체(Spring Bean)도 자동 소멸
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==========================================================");
	}
}
