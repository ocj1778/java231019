package xyz.itwill.thread;

//은행계좌정보(잔액)를 저장하기 위한 클래스 
// => 입금 및 출금 관련 메소드 작성
public class Account {
	private int balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금 처리 메소드 - 매개변수로 입금자와 입금액을 전달받아 처리
	public void deposit(String name, int amount) {
		balance+=amount;
		System.out.println("[입금]"+name+"님이 "+amount+"원을 입금하여 잔액은 "+balance+"원입니다.");
	}
	
	//출금 처리 메소드 - 매개변수로 출금자와 출금액을 전달받아 처리
	public void withDraw(String name, int amount) {
		if(balance < amount) {
			System.out.println("[에러]"+name+"님, 잔액이 "+balance+"원 남아 "+amount+"원을 출금할 수 없습니다.");
			return;
		}
		
		balance-=amount;
		System.out.println("[출금]"+name+"님이 "+amount+"원을 출금하여 잔액은 "+balance+"원입니다.");
	}
}
