package xyz.itwill02.factory;

//Factory 디자인 패턴을 적용하여 작성된 클래스 - Factory 클래스
// => 프로그램 개발에 필요한 객체를 생성하여 제공하는 클래스
// => IoC(Inversion of Control)기능의 클래스
public class MessageObjectFactory {
	//Factory 클래스에 의해 제공될 객체를 구분하기 위한 상수(Constant)
	public static final int HELLO_MSG=1;  
	public static final int HI_MSG=2;  
	
	//인터페이스를 상속받은 자식클래스로 객체를 생성하여 반환하는 정적 메소드
	public static MessageObject getMessageObject(int message) {
		//MessageObject object=new HelloMessageObject();
		//MessageObject object=new HiMessageObject();
		
		MessageObject object=null;
		switch (message) {
		case HELLO_MSG: 
			object=new HelloMessageObject();
			break;
		case HI_MSG: 
			object=new HiMessageObject();
			break;
		}
		
		return object;
	}
}
