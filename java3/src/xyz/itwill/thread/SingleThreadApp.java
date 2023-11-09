package xyz.itwill.thread;

//스레드(Thread) : 프로세스의 명령을 실행하기 위한 최소의 작업 단위 - 프로그램의 흐름
//프로세스(Process) : 메모리에 저장된 프로그램 - 중앙처리장치(CPU)에 의해 실행될 명령 제공

//단일 스레드 프로그램
// => JVM(Java Virtual Machine)이 Java 프로그램을 실행하기 위해 [main] 스레드 생성
// => [main] 스레드는 main() 메소드를 자동으로 호출하여 명령 실행
// => main() 메소드가 종료되면 [main] 스레드는 자동 소멸되어 프로그램 종료
public class SingleThreadApp {
	public static void main(String[] args) {
		System.out.println("SingleThreadApp 클래스의 main() 메소드 시작");
		
		//Thread 클래스 : 스레드 관련 정보를 저장하여 제어하기 위한 기능을 제공하는 클래스
		//Thread.currentThread() : 현재 명령을 읽어 처리하는 스레드 정보를 저장한 Thread 
		//객체를 반환하는 정적메소드
		//Thread.getName() : Thread 객체에 저장된 스레드의 이름(고유값)을 반환하는 메소드
		System.out.println("["+Thread.currentThread().getName()
				+"] 스레드에 의해 SingleThreadApp 클래스의 main() 메소드 명령 실행");
		
		for(char i='A';i<='Z';i++) {
			System.out.print(i);
		}
		System.out.println();

		new SingleThread().display();
		
		System.out.println("SingleThreadApp 클래스의 main() 메소드 종료");
	}
}
