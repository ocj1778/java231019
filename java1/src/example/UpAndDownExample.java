package example;

import java.util.Scanner;

//컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요.
// => 1~100 범위의 정수 난수값을 제공받도록 작성
// => 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
// => 키보드 입력값이 1~100 범위가 아닌 경우 메세지 출력 후 재입력
// => 난수값과 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료
// => 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
// => 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성
public class UpAndDownExample {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//1~100 범위의 정수 난수값을 제공받아 변수에 저장
		int dap=(int)(Math.random()*100)+1;
		
		//정답 상태를 저장하기 위한 변수
		// => false : 정답을 맞추지 못한 상태, true : 정답을 맞춘 상태
		boolean result=false;
		
		//키보드로 정수값을 입력받아 난수값을 맞추기 위한 기회를 10번 제공하기 위한 반복문 
		for(int i=1;i<=10;i++) {
			int input;//키보드 입력값을 저장하기 위한 변수
			
			//키보드 입력값을 검증하기 위한 반복문
			while(true) {
				System.out.print(i+"번째 정수값 입력[0~100] >> ");
				//키보드 입력값을 제공받아 변수에 저장
				input=scanner.nextInt();
				if(input >= 1 && input <= 100) break;//정상적인 값이 입력된 경우 반복문 종료
				System.out.println("[에러]1~100 범위의 정수값만 입력 가능합니다.");
			}
			
			//난수값과 키보드 입력값을 비교하여 결과 출력
			if(dap == input) {
				System.out.println("[메세지]축하합니다."+i+"번만에 맞췄습니다.");
				result=true;//변수에 정답을 맞춘 상태값을 저장
				break;//난수값을 맞추기 위한 반복문 종료
			} else if(dap > input) {
				System.out.println("[결과]"+input+"보다 큰 값을 입력해 보세요.");
			} else {
				System.out.println("[결과]"+input+"보다 작은 값을 입력해 보세요.");
			}
		}
		
		if(!result) {//정답을 맞추지 못한 상태인 경우
			System.out.println("[메세지]정답을 맞추지 못했군요. 정답은 ["+dap+"]입니다.");
		}
		
		scanner.close();
	}
}
