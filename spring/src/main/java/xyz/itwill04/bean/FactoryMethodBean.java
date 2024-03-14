package xyz.itwill04.bean;

//싱글톤 디자인 패턴을 적용하여 작성된 클래스 - 싱글톤 클래스(Singleton Class)
// => 프로그램에 필요한 객체를 하나만 제공하기 위한 목적의 클래스를 작성하기 위한 사용하는 디자인 패턴
public class FactoryMethodBean {
	private static FactoryMethodBean _bean;
	
	private FactoryMethodBean() {
		System.out.println("### FactoryMethodBean 클래스의 기본 생성자 호출 ###");
	}
	
	static {
		_bean=new FactoryMethodBean();
	}
	
	public static FactoryMethodBean getFactoryMethodBean() {
		return _bean;
	}
}
