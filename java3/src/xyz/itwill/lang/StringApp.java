package xyz.itwill.lang;

//String 클래스 : 문자열을 저장하기 위한 클래스
// => String 객체에 저장된 문자열을 사용하는 다양한 기능의 메소드 제공
// => String 객체에 저장된 문자열은 내부적으로 byte 배열로 처리 - 배열 요소에 문자를 하나씩 저장
public class StringApp {
	public static void main(String[] args) {
		//문자열을 " " 기호를 사용하여 리터럴로 표현하면 JVM은 자동으로 메모리의 메소드영역  
		//(MethodArea)에 문자열이 저장된 String 객체 생성 - 상수객체 
		// => 메소드영역(MethodArea)에는 같은 문자열이 저장된 String 객체(상수객체) 생성 불가
		String str1="ABC";
		
		//String.toString() : String 객체에 저장된 문자열을 반환하는 메소드
		System.out.println("str1.toString() = "+str1.toString());
		//참조변수를 출력하면 참조변수가 String 객체를 참조해 자동으로 toString() 메소드 호출
		//하므로 toString() 메소드 호출 생략 가능
		System.out.println("str1 = "+str1);
		System.out.println("===============================================================");
		//상수객체로 생성된 String 객체는 같은 문자열이 저장된 String 객체를 생성하지 않고
		//기존 String 객체를 재활용하여 제공
		// => str1 참조변수와 str2 참조변수에는 같은 String 객체의 메모리 주소 저장
		String str2="ABC";
		
		//참조변수를 비교연산자로 비교 처리하면 참조변수에 저장된 메모리 주소를 비교
		// => String 객체에 저장된 문자열을 비교하는 것이 아니라 String 객체의 메모리 주소 비교
		if(str1 == str2) {
			System.out.println("str1 변수와 str2 변수에 저장된 메모리 주소가 같습니다.");
		} else {
			System.out.println("str1 변수와 str2 변수에 저장된 메모리 주소가 다릅니다.");
		}
		System.out.println("===============================================================");
		//new 연산자로 String 클래스의 생성자를 호출하여 메모리의 힙영역(HeapArea)에 String 객체 생성
		// => str1 참조변수와 str3 참조변수에는 서로 다른 메모리 주소 저장
		String str3=new String("ABC");
		
		if(str1 == str3) {
			System.out.println("str1 변수와 str3 변수에 저장된 메모리 주소가 같습니다.");
		} else {
			System.out.println("str1 변수와 str3 변수에 저장된 메모리 주소가 다릅니다.");
		}
		System.out.println("===============================================================");
		//String.equals(String str) : String 객체에 저장된 문자열과 매개변수로 전달받은 String
		//객체의 문자열을 비교하여 다른 경우 [false]를 반환하고 같은 경우 [true]를 반환하는 메소드
		// => 비교 문자열이 영문자인 경우 대소문자를 구분하여 비교
		if(str1.equals(str3)) {
			System.out.println("str1 변수와 str3 변수가 참조하는 String 객체의 문자열이 같습니다.");
		} else {
			System.out.println("str1 변수와 str3 변수가 참조하는 String 객체의 문자열이 다릅니다.");
		}
		System.out.println("===============================================================");
		String str4="abc";
		
		if(str1.equals(str4)) {
			System.out.println("str1 변수와 str4 변수가 참조하는 String 객체의 문자열이 같습니다.");
		} else {
			System.out.println("str1 변수와 str4 변수가 참조하는 String 객체의 문자열이 다릅니다.");
		}
		System.out.println("===============================================================");
		//String.equalsIgnoreCase(String str) : String 객체에 저장된 문자열과 매개변수로 전달받은 
		//String 객체의 문자열을 비교하여 다른 경우 [false]를 반환하고 같은 경우 [true]를 반환하는 메소드
		// => 비교 문자열이 영문자인 경우 대소문자를 구분하지 않고 비교
		if(str1.equalsIgnoreCase(str4)) {
			System.out.println("str1 변수와 str4 변수가 참조하는 String 객체의 문자열이 같습니다.");
		} else {
			System.out.println("str1 변수와 str4 변수가 참조하는 String 객체의 문자열이 다릅니다.");
		}
		System.out.println("===============================================================");
		//String.compareTo(String str) : String 객체에 저장된 문자열과 매개변수로 전달받은 String
		//객체의 문자열을 비교하여 String 객체에 저장된 문자열이 크면 양수를 반환하고 매개변수로 
		//전달받은 String 객체의 문자열이 크면 음수를 반환하고 같으면 [0]를 반환하는 메소드
		// => 비교 문자열이 영문자인 경우 대소문자를 구분하여 비교
		if(str1.compareTo(str4) > 0) {
			System.out.println("str1 변수가 참조하는 String 객체의 문자열이 str4 변수가 참조하는 String 객체의 문자열보다 큽니다.");
		} else if(str1.compareTo(str4) < 0) {
			System.out.println("str1 변수가 참조하는 String 객체의 문자열이 str4 변수가 참조하는 String 객체의 문자열보다 작습니다.");
		} else {
			System.out.println("str1 변수가 참조하는 String 객체의 문자열과 str4 변수가 참조하는 String 객체의 문자열이 같습니다.");
		}
		System.out.println("===============================================================");
	}
}


















