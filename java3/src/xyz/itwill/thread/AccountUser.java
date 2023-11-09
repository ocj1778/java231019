package xyz.itwill.thread;

//은행계좌 사용자정보(은행계좌정보, 사용자명)를 저장하기 위한 클래스
public class AccountUser extends Thread {
	//클래스로 작성된 필드에는 생성자 또는 Setter 메소드를 이용하여 반드시 객체 저장 - 포함관계
	private Account account;
	private String userName;
	
	public AccountUser() {
		// TODO Auto-generated constructor stub
	}

	public AccountUser(Account account, String userName) {
		super();
		this.account = account;
		this.userName = userName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//새롭게 생성된 스레드가 실행될 명령 작성 
	// => AccountUser 객체를 참조하여 필드 또는 메소드 사용 가능
	// => 필드에 저장된 Account 객체를 참조하여 입력 또는 출금 처리하는 메소드 호출
	@Override
	public void run() {
		//account.deposit(userName, 5000);
		
		synchronized (account) {
			account.withDraw(userName, 5000);
		}
	}
}










