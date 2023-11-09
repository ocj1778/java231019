package xyz.itwill.thread;

public class MultiThreadOne extends Thread {
	@Override
	public void run() {
		for(char i='A';i<='Z';i++) {
			System.out.print(i);
		}
	}
}
