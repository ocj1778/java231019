package basic;

//continue : 반복문의 명령을 처음부터 다시 실행하기 위한 키워드
// => 반복문의 블럭 내부에서 continue 명령이 실행되면 하단에 작성된 명령을 실행하지 않고 처음부터 다시 실행

public class ContinueApp {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			if(i==3) continue;
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("===============================================================");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//continue 키워드가 포함된 반복문을 처음부터 다시 실행
				if(j==3) continue;//for(int j=1;j<=5;j++) 반복문 재실행
				System.out.println("i = "+i+", j = "+j);
			}
		}
		System.out.println("==============================================================");
		loop:
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//continue 라벨명 : 라벨명으로 지정된 반복문을 처음부터 다시 실행
				if(j==3) continue loop;//for(int i=1;i<=5;i++) 반복문 재실행
				System.out.println("i = "+i+", j = "+j);
			}
		}
		System.out.println("==============================================================");
	}
}
