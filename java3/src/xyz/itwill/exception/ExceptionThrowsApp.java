package xyz.itwill.exception;

public class ExceptionThrowsApp {
	//예외가 발생된 명령의 메소드에서 예외처리를 하지 않고 예외가 발생된 메소드를 호출한 명령에게
	//예외 전달 가능 - 메소드 머릿부에 throws 키워드를 사용하여 발생되는 모든 예외들을 전달 
	//형식) 접근제한자 반환형 메소드명(자료형 변수명,...) throws 예외클래스, 예외클래스, ... {  
	//             예외가 발생되는 명령; ... 
	//      }
	public static void display() throws ArrayIndexOutOfBoundsException {
		int[] array={10, 20, 30, 40, 50};
		
		for(int i=0;i<=array.length;i++) {
			System.out.println("array["+i+"] = "+array[i]);
		}
	}
	
	public static void main(String[] args) {
		//예외를 전달하는 메소드를 호출한 명령에서 전달된 예외를 처리하는 것을 권장
		try {
			//ExceptionThrowsApp.display();//정적메소드는 클래스를 이용하여 호출
			display();//같은 클래스의 정적메소드는 클래스 없이 호출 가능
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생 되었습니다.");
		}
	}
}
