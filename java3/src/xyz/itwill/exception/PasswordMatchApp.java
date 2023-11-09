package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값을 입력받아 저장된 비밀번호와 비교하여 결과를 출력하는 프로그램 작성
public class PasswordMatchApp {
	public static void main(String[] args) {
		/*
		int password=123456;//비밀번호가 저장된 변수
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("비밀번호 입력 >> ");
		int number=scanner.nextInt();
		
		if(number==password) {
			System.out.println("[결과]키보드로 입력된 비밀번호가 맞습니다.");
		} else {
			System.out.println("[결과]키보드로 입력된 비밀번호가 틀립니다.");
		}
		
		scanner.close();
		*/

		int password=123456;//비밀번호가 저장된 변수
		
		Scanner scanner=new Scanner(System.in);

		try {
			System.out.print("비밀번호 입력 >> ");
			//Scanner.nextInt() 메소드를 호출하면 InputMismatchException 발생 가능
			int number=scanner.nextInt();
			
			if(number!=password) {
				//인위적으로 예외 객체를 생성하여 예외를 발생하는 명령
				//형식) throw new 예외클래스(String message);
				//throw new RuntimeException("[결과]키보드로 입력된 비밀번호가 틀립니다.");
				
				//인위적으로 발생되는 예외는 직접 예외클래스를 생성하여 사용하는 것을 권장
				// => 발생되는 예외를 보다 명확하게 구분하기 위해 필요한 예외클래스 작성
				throw new PasswordMismatchException("[결과]키보드로 입력된 비밀번호가 틀립니다.");
			}
			
			//예외가 발생되지 않은 경우 실행되는 명령
			System.out.println("[결과]키보드로 입력된 비밀번호가 맞습니다.");
		} catch (InputMismatchException e) {
			System.out.println("[에러]숫자만 입력 가능합니다.");
		} catch (PasswordMismatchException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생 되었습니다.");
		} finally {
			scanner.close();
		}
	}
}
