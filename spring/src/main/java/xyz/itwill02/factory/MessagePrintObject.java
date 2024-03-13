package xyz.itwill02.factory;

public class MessagePrintObject {
	public void messagePrint() {
		//객체를 직접 생성하여 메소드 호출 - 객체간의 결합도가 높아 유지보수의 효율성 감소
		//MessageObject object=new HelloMessageObject();
		
		//프로그램 실행에 필요한 객체를 Factory 클래스로부터 반환받아 메소드 호출
		// => 제어의 역행(IoC)을 사용하여 객체간의 결합도를 낮춰 유지보수의 효율성 증가 
		//MessageObject object=MessageObjectFactory.getMessageObject();
		
		//MessageObject object=MessageObjectFactory.getMessageObject(MessageObjectFactory.HELLO_MSG);
		MessageObject object=MessageObjectFactory.getMessageObject(MessageObjectFactory.HI_MSG);
		
		String message=object.getMessage();
		System.out.println("message = "+message);
	}
}
