package xyz.itwill01.old;

public class MessagePrintObject {
	public void helloMessagePrint() {
		HelloMessageObject object=new HelloMessageObject();
		String message=object.getHelloMessage();
		System.out.println("message = "+message);
	}
	
	public void hiMessagePrint() {
		HiMessageObject object=new HiMessageObject();
		String message=object.getHiMessage();
		System.out.println("message = "+message);
	}
}
