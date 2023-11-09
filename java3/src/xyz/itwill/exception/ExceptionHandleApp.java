package xyz.itwill.exception;

//예외(Exception) : JVM(Java Virtual Machine)에 의해 Java 프로그램이 실행될 때 발생되는 다양한 오류
// => 사용자가 프로그램을 정상적으로 실행하지 않았거나 프로그램을 잘못 개발한 경우 예외 발생
// => 프로그램 실행시 예외가 발생된 경우 예외가 발생된 시점에 프로그램은 강제 종료
// => 예외가 발생되어 프로그램이 강제로 종료되는 것을 방지하거나 예외가 발생된 이유를 알기 위해
//예외처리(ExceptionHandle) 필요

//Java 프로그램에서는 예외를 처리하기 위한 다양한 예외클래스를 제공
//예외클래스(Exception Class) : 예외 관련 정보(예외 관련 메세지)를 저장하기 위한 클래스
// => Exception 클래스를 상속받아 작성된 자식클래스
// => 프로그램 실행시 예외가 발생되면 JVM은 예외클래스로 예외 관련 정보가 저장된 객체 생성

//Throwable 클래스 : 프로그램에서 발생되는 모든 오류정보를 저장하기 위한 부모클래스
// => 자식클래스 : Error 클래스, Exception 클래스

//예외의 종류
//1.일반 예외 : 프로그램 실행시 예외가 발생될 가능성이 높아 예외처리를 하지 않은 경우 컴파일시 에러 발생
// => RuntimeExcpetion 클래스를 상속받지 않는 예외클래스로 예외처리
//2.실행 예외 : 프로그램 실행시 예외가 발생될 가능성이 낮아 예외처리를 하지 않아도 컴파일시 에러 미발생
// => RuntimeExcpetion 클래스를 상속받은 예외클래스로 예외처리
// => 실행 예외를 예외처리 하지 않은 경우 실행 예외가 발생되면 JVM이 자동으로 예외처리 하여  
//예외메세지 제공 후 프로그램 강제 종료

//예외처리 방법 - try~catch 구문을 사용하여 예외 처리
//형식) try {
//             예외가 발생될 수 있는 명령; ...
//      } catch(예외클래스 참조변수) {
//             예외 처리 명령; ...
//      } finally {
//             예외 발생과 상관없이 무조건 실행될 명령; ...
//      }
// => try 키워드의 블럭에 명령이 실행될 때 예외가 발생되면 JVM에 의해 예외클래스로 객체 생성
// => try 키워드의 블럭에서 발생된 예외 객체를 catch 키워드로 가져와 소괄호 내부의 참조변수에
//저장 후 블럭 내부의 명령으로 예외 처리 - 참조변수에 저장된 예외 객체를 이용하여 예외 처리
// => try 키워드의 블럭에서 예외가 발생되면 catch 키워드 블럭으로 프로그램의 흐름(스레드)가 
//이동되어 예외 처리 명령 실행 - try 키워드의 블럭에서 예외가 발생된 위치 아래에 작성된 명령 미실행
// => catch 키워드의 블럭을 여러개 작성 가능 - 다양한 예외를 구분하여 예외 처리
// => finally 키워드의 블럭에는 예외 발생과 상관없이 무조건 실행될 명령을 작성하여 생략 가능
// => finally 키워드의 블럭은 사용 자원에 대한 제거 명령을 실행할 때 작성

public class ExceptionHandleApp {
	public static void main(String[] args) {
		int[] array={10, 20, 30, 40, 50};
		
		try {

			//배열 요소의 첨자가 사용범위를 벗어난 경우 ArrayIndexOutOfBoundsException 발생
			for(int i=0;i<=array.length;i++) {
				System.out.println("array["+i+"] = "+array[i]);//예외 발생 - 예외 객체 생성
			}
	
			//예외가 발생되지 않아야 실행되는 명령
			System.out.println("[메세지]프로그램이 정상적으로 실행 되었습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {//ArrayIndexOutOfBoundsException 관련 예외 처리
			//ArrayIndexOutOfBoundsException 객체를 제공받아 참조변수에 저장하여 예외 처리
			
			//프로그램 사용자에게 예외 관련 메세지 출력 - 선택
			// => 사용자 입력값에 의해 예외가 발생된 경우에 대한 예외 처리
			//System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생 되었습니다.");
			
			//예외가 발생된 이유를 프로그램 개발자에게 제공(기록) : 에러 로그 - 필수
			// => 예외 객체가 저장된 참조변수로 메소드를 호출하여 예외 관련 메세지를 제공받아 기록
			//Throwable.getMessage() : 예외 객체에 저장된 예외 메세지를 반환하는 메소드
			//System.out.println("[예외]"+e.getMessage());
			
			//Throwable.printStackTrace() : 예외가 발생된 경로를 역으로 추적으로 발생된 
			//정보를 제공받아 출력하는 메소드
			e.printStackTrace();//JVM이 예외를 자동으로 처리하는 방법
		} finally {
			System.out.println("[메세지]예외 발생과 상관없이 무조건 실행될 명령");
		}
	}
}
