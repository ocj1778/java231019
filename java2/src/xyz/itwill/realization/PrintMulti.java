package xyz.itwill.realization;

public class PrintMulti implements Printable {
	@Override
	public void print() {
		System.out.println("[복합기]문서를 출력합니다.");
	}
	
	@Override
	public void scan() {
		System.out.println("[복합기]문서를 스캔합니다.");
	}
}
