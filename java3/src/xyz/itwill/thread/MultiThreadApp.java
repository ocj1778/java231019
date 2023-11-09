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

//프로그램 개발자가 스레드를 생성하여 원하는 명령을 실행하는 방법-2
//1.Runnable 인터페이스를 상속받은 자식클래스 선언
// => 자식클래스가 이미 다른 클래스를 상속받아 Thread 클래스를 상속받지 못하는 경우 Runnable 인터페이스 사용
//2.Runnable 인터페이스를 상속받은 자식클래스에서 무조건 run() 메소드를 오버라이드 선언
//3.Runnable 인터페이스를 상속받은 자식클래스의 생성자로 객체 생성
//4.Thread 클래스의 매개변수가 존재하는 생성자를 이용하여 Thread 객체 생성
// => 생성자의 매개변수에는 Runnable 인터페이스를 상속받은 자식클래스의 객체 전달
// => Runnable 인터페이스를 상속받은 자식클래스의 오버라이드 선언된 run() 메소드를 Thread 객체가 사용
//5.Thread 객체를 참조하여 start() 메소드를 호출

public class MultiThreadApp {
	//JVM에 의해 [main] 스레드가 자동으로 생성되어 main() 메소드를 호출해 명령 실행
	// => main() 메소드에 의해 전달된 예외는 JVM에 의해 자동으로 예외 처리 
	public static void main(String[] args) throws InterruptedException {
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
		
		/*
		MultiThreadTwo two=new MultiThreadTwo();
		Thread thread=new Thread(two);
		thread.start();
		*/		
		new Thread(new MultiThreadTwo()).start();
		
		//Runnable 인터페이스를 상속받은 자식클래스를 선언하지 않고 Runnable 인터페이스로 
		//익명클래스로 객체를 생성하여 Thread 클래스의 생성자에게 전달 
		//Runnable 인터페이스는 반환값도 없고 매개변수도 없는 함수형 인터페이스로 사용 가능
		// => 람다표현식을 사용하여 익명클래스로 객체 생성
		new Thread(() -> {
			for(int i=0;i<=9;i++) {
				System.out.print(i);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		for(char i='a';i<='z';i++) {
			System.out.print(i);
			
			//Thread.sleep(long millis) : 스레드를 원하는 시간(ms)동안 일시 중지하는 정적메소드
			// => InterruptedException 발생 - 일반 예외이므로 예외 처리하지 않으면 에러 발생
			// => try~catch 구문을 사용하지 않고 메소드에 throws 키워드를 사용하여 예외 전달
			Thread.sleep(500);
		}
	}
}
