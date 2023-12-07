package xyz.itwill.jdbc;

public class StaticBlock {
	//정적영역(Static Block) : 클래스가 메모리에 저장된 후 자동 실행될 명령을 작성하는 영역
	// => 정적영역에 작성된 명령을 프로그햄 동작시 한번만 실행
	static {
		System.out.println("### StaticBlock 클래스의 정적영역에 작성된 명령 실행 ###");
		StaticBlock sb=new StaticBlock();
		sb.display();
	}
	
	public StaticBlock() {
		System.out.println("### StaticBlock 클래스의 기본 생성자 호출 - 객체 생성 ###");
	}
	
	public void display() {
		System.out.println("### StaticBlock 클래스의 display() 메소드 호출 ###");
	}
}
