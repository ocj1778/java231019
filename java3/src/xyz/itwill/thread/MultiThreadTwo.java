package xyz.itwill.thread;

public class MultiThreadTwo implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<=9;i++) {
			System.out.print(i);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
