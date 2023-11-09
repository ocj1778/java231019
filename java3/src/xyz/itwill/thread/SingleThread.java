package xyz.itwill.thread;

public class SingleThread {
	public void display() {
		System.out.println("SingleThread 클래스의 display() 메소드 시작");
		
		System.out.println("["+Thread.currentThread().getName()
				+"] 스레드에 의해 SingleThread 클래스의 display() 메소드 명령 실행");
		
		for(char i='a';i<='z';i++) {
			System.out.print(i);
		}
		System.out.println();
		
		System.out.println("SingleThread 클래스의 display() 메소드 종료");
	}
}
