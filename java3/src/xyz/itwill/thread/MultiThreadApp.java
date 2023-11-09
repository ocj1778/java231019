package xyz.itwill.thread;

//다중 스레드 프로그램
// => 프로그램 개발자가 직접 스레드를 생성하여 명령을 동시에 실행되도록 작성한 프로그램
// => 프로그램 실행하는 모든 스레드가 소멸되야만 프로그램 종료
// => GUI 프로그램 및 Web 프로그램 등은 다중 스레드 프로그램으로 작성

//프로그램 개발자가 스레드를 생성하여 원하는 명령을 실행하는 방법-1
//1.Thread 클래스를 상속받은 자식클래스 선언
//2.Thread 클래스를 상속받은 자식클래스에서 무조건 run() 메소드를 오버라이드 선언
// => run() 메소드에는 생성된 새로운 스레드가 실행하기 위한 명령 작성
//3.Thread 클래스를 상속받은 자식클래스의 생성자로 객체 생성 - Thread 객체 생성
//4.Thread 객체를 참조하여 start() 메소드를 호출 - Thread 객체를 이용하여 새로운 스레드 생성
// => 생성된 스레드는 자식클래스의 run() 메소드를 자동 호출하여 명령 실행

public class MultiThreadApp {
	//JVM에 의해 [main] 스레드가 자동으로 생성되어 main() 메소드를 호출해 명령 실행
	public static void main(String[] args) {
		/*
		//새로운 스레드를 생성하여 생성된 스레드로 원하는 명령 실행 
		// => Thread 클래스를 이용하여 객체를 생성 후 start() 메소드 호출 - 스레드 생성
		// => 생성된 스레드는 Thread 클래스의 run() 메소드를 자동 호출하여 명령 실행
		// => Thread 클래스의 run() 메소드에는 아무런 명령도 없으므로 생성된 스레드 무의미
		Thread thread=new Thread();
		thread.start();
		*/
		
		/*
		MultiThreadOne one=new MultiThreadOne();
		//Thread.start() : Thread 객체로 새로운 스레드를 생성하기 위한 메소드
		// => 생성된 스레드는 Thread 객체를 참조하여 run() 메소드를 자동 호출 - 숨겨진 메소드
		// => 자식클래스에서 오버라이드 선언한 run() 메소드가 호출되어 명령 실행
		one.start();
		//하나의 Thread 객체는 하나의 스레드만 생성 가능
		// => Thread 객체를 참조해 start() 메소드를 호출할 경우 IllegalThreadStateException 발생
		// => 다중 스레드 프로그램에서 예외가 발생될 경우 예외가 발생된 스레드만 소멸
		//one.start();
		*/
		
		//Thread 객체를 참조하여 start() 메소드외에 다른 메소드를 호출하지 않을 경우 참조변수에
		//객체를 저장하지 않고 객체를 생성하여 직접 메소드 호출
		new MultiThreadOne().start();
		new MultiThreadOne().start();
		
		for(char i='a';i<='z';i++) {
			System.out.print(i);
		}
	}
}












