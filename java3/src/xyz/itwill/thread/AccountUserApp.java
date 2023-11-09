package xyz.itwill.thread;

//다중 스레드 프로그램의 문제점
// => 다수의 스레드가 같은 객체로 동일한 메소드를 호출한 경우 스레드로 실행되는 명령이 순서
//없이 실행되어 잘못된 처리결과가 발생 가능
//해결법)스레드 동기화를 이용하여 스레드에 대한 메소드 호출 제어

//스레드 동기화(Thread Synchronize) : 스레드가 메소드를 호출한 경우 메소드의 모든 명령이 
//실행되기 전까지 다른 스레드로 메소드를 호출하지 못하도록 방지하는 기능
// => 스레드가 메소드를 호출하여 명령이 실행중인 경우 다른 스레드가 메소드를 호출면 메소드를 
//호출한 스레드를 일시 중지시켜 기존 스레드의 메소드의 명령을 모두 실행된 후 스레드가 실행
//되도록 락(Lock) 기능 제공

//메소드 호출에 대한 스레드 동기화 방법
//1.synchronized 키워드를 사용하여 메소드 작성 - 동기화 메소드(Synchronized Method)
//형식) 접근제한자 synchronized 반환형 메소드명(자료형 매개변수,...) { 명령; ... }
//2.synchronized 키워드로 블럭을 설정하여 메소드 호출
//형식) synchronized(공유객체) { 객체.메소드명(값,...); ... }
// => synchronized 키워드로 제공된 객체로 호출되는 모든 메소드는 동기화 처리되어 실행

public class AccountUserApp {
	public static void main(String[] args) {
		//Account 클래스로 객체를 생성하여 참조변수에 저장 - 은행계좌 생성
		Account account=new Account(10000);
		
		//AccountUser 클래스로 객체를 생성하여 참조변수에 저장
		// => 은행계좌를 사용하는 모든 사용자가 같은 은행계좌를 사용하도록 설정
		AccountUser userOne=new AccountUser(account, "홍길동");
		AccountUser userTwo=new AccountUser(account, "임꺽정");
		AccountUser userThree=new AccountUser(account, "전우치");

		/*
		//은행계좌 사용자(AccountUser 객체)로부터 은행계좌(Account 객체)를 반환받아 입금 처리하는 메소드 호출
		// => 단일스레드(main 스레드)를 이용하여 객체를 참조해 메소드 호출
		// => 모든 은행계좌 사용자는 단일 스레드로 입금 처리하므로 동시에 입금 처리 불가능
		userOne.getAccount().deposit(userOne.getUserName(), 5000);
		userTwo.getAccount().deposit(userTwo.getUserName(), 5000);
		userThree.getAccount().deposit(userThree.getUserName(), 5000);
		*/
		
		//새로운 스레드를 생성하여 run() 메소드의 명령 실행
		// => run() 메소드에 작성된 명령으로 AccountUser 객체에 저장된 Account 객체를 
		//이용하여 입금 또는 처리 - 다수의 스레드로 입금 또는 출력을 동시에 처리 가능 
		userOne.start();
		userTwo.start();
		userThree.start();
	}
}
