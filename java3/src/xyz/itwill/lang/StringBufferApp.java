package xyz.itwill.lang;

//StringBuffer 클래스 : 문자열을 저장하기 위한 클래스
// => String 클래스의 메소드는 String 객체에 저장된 문자열을 직접 사용하지 않고 필요한 기능을
//구현하여 처리결과를 제공 - 문자열을 간접 처리하는 메소드
// => StringBuffer 클래스의 메소드는 StringBuffer 객체에 문자열을 직접 사용하여 필요한 기능을
//구현하여 처리결과를 제공 - 문자열을 직접 처리하는 메소드
// => String 클래스의 메소드보다 StringBuffer 클래스의 메소드가 문자열 처리 속도가 우수

//StringBuilder 클래스 : 문자열을 저장하기 위한 클래스
// => StringBuffer 클래스와 동일한 메소드를 제공하지만 StringBuilder 클래스의 메소드는 일반
//메소드로 선언되어 있고 StringBuffer 클래스는 다중 스레드에 안전한 동기화 메소드로 선언 

public class StringBufferApp {
	public static void main(String[] args) {
		//StringBuffer 클래스는 new 연산자로 생성자를 호출하여 객체 생성
		StringBuffer sb=new StringBuffer("ABC");
		
		//StringBuffer.toString() : StringBuffer 객체에 저장된 문자열을 반환하는 메소드
		System.out.println("sb.toString() = "+sb.toString());
		//StringBuffer 객체가 저장된 참조변수를 출력하면 toString() 메소드 자동 호출
		System.out.println("sb = "+sb);
		
		//StringBuffer 객체에 저장된 문자열을 반환받아 String 객체에 저장해야 될 경우 toString() 메소드로 호출
		String str=sb.toString();//StringBuffer 객체 >> String 객체
		System.out.println("str = "+str);
		System.out.println("==============================================================");
		//StringBuffer.append(Object o) : StringBuffer 객체에 저장된 문자열에 매개변수로 
		//전달받은 값을 추가하는 메소드
		sb.append("DEF");
		System.out.println("sb = "+sb);//ABCDEF
		
		str+="DEF";//+ 연산자를 사용하여 문자열(String 객체)에 값을 결합하여 저장 가능 
		System.out.println("str = "+str);//ABCDEF
		System.out.println("==============================================================");
		//StringBuffer.insert(int index, Object o) : StringBuffer 객체에 저장된 문자열에
		//매개변수로 전달받은 값을 원하는 첨자 위치에 삽입하는 메소드
		sb.insert(4, "X");
		System.out.println("sb = "+sb);//ABCDXEF
		System.out.println("==============================================================");
		//StringBuffer.deleteCharAt(int index) : StringBuffer 객체에 저장된 문자열에서 매개변수로
		//전달받은 첨자 위치의 문자를 삭제하는 메소드
		sb.deleteCharAt(2);
		System.out.println("sb = "+sb);//ABDXEF
		System.out.println("==============================================================");
		//StringBuffer.delete(int beginIndex, int endIndex) : 문자열에서
		//매개변수로 전달받은 시작첨자 위치의 문자부터 종료첨자 위치의 문자 전까지의 모든
		//문자들을 삭제하는 메소드 - 원하는 범위의 문자열 삭제
		sb.delete(4, 6);
		System.out.println("sb = "+sb);//ABDX
		System.out.println("==============================================================");
		//StringBuffer.reverse() : StringBuffer 객체에 저장된 문자열의 문자를 반대로 나열하여
		//저장하는 메소드
		sb.reverse();
		System.out.println("sb = "+sb);//XDBA
		System.out.println("==============================================================");
	}
}