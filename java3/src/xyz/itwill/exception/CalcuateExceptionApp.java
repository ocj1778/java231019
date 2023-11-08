package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값 2개를 입력받아 첫번째 정수값으로 두번째 정수값을 나눈 몫을 계산하여 출력하는
//프로그램 작성
public class CalcuateExceptionApp {
	//public CalcuateExceptionApp() throws InputMismatchException, ArithmeticException {
	public CalcuateExceptionApp() throws Exception {//메소드에서 발생되는 모든 예외 전달
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("첫번째 정수값 입력 >> ");
		//Scanner.nextInt() : 입력값을 얻어와 정수값으로 변환하여 반환하는 메소드
		// => 입력값이 정수값으로 변환되지 못할 경우 InputMismatchException 발생
		// => 직접 예외 처리하지 않고 메소드를 이용하여 예외 전달
		int num1=scanner.nextInt();
		
		System.out.print("두번째 정수값 입력 >> ");
		int num2=scanner.nextInt();
		
		//어떤수를 [0]으로 나눈 경우 ArithmeticException 발생
		// => 직접 예외 처리하지 않고 메소드를 이용하여 예외 전달
		System.out.println("[결과]"+num1+" / "+num2+" = "+(num1/num2));
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		/*
		try {
			//new 연산자로 클래스의 생성자를 호출하여 객체 생성 - 생성자에 작성된 명령 실행
			// => 생성자를 호출하여 예외가 전달되어 예외가 발생하므로 예외처리 하는 것을 권장
			new CalcuateExceptionApp();
		} catch (InputMismatchException e) {
			System.out.println("[에러]형식에 맞는 값을 입력해 주세요.");
		} catch (ArithmeticException e) {
			System.out.println("[에러]0으로 나눌 수 없습니다.");
		} catch (Exception e) {//모든 예외 관련 객체를 전달받아 예외 처리
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생 되었습니다.");
		}
		*/
		
		//catch 키워드에서 예외클래스를 | 연산자로 연결하여 다수의 예외클래스에 객체를 전달받아 예외처리 가능
		try {
			new CalcuateExceptionApp();
		} catch (InputMismatchException | ArithmeticException e) {
			System.out.println("[에러]형식에 맞는 값을 입력해 주세요.");
		} catch (Exception e) {
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생 되었습니다.");
		}
	}
}
