package xyz.itwill.jdbc;

//Class 객체를 제공받는 방법
//1.Class.forName(String className) 메소드를 호출하여 매개변수로 전달된 클래스에 대한 Class 객체 반환
//2.Object.getClass() 메소드를 호출하여 메소드를 호출한 클래스에 대한 Class 객체 반환
//3.[클래스명.class] 표현식을 사용하여 Class 객체 반환

public class StaticBlockApp {
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		//1.JVM은 ClassLoader 프로그램을 이용하여 클래스(Class 파일)을 읽어 메모리의 Method 영역에
		//클래스(Class 객체 - Clazz) 생성
		//2.new 연산자로 메모리에 저장된 클래스(Class 객체)의 생성자를 호출하여 객체 생성
		// => 객체는 메모리의 Heap 영역에 생성
		//3.참조변수를 생성하여 객체의 메모리 주소(HashCode)를 제공받아 저장
		// => 참조변수는 메모리의 Stack 영역에 생성
		StaticBlock sb=new StaticBlock();//자동으로 클래스를 메모리에 저장

		//참조변수에 저장된 메모리 주소로 객체를 참조해 메소드 호출
		sb.display();
		*/
	
		//Class.forName(String className) : 문자열로 패키지 경로가 포함된 클래스를 매개변수로
		//전달받아 ClassLoader 프로그램을 사용하여 클래스를 메모리에 저장하는 메소드
		// => 메모리에 저장된 클래스의 정보가 저장된 Class 객체를 생성하여 반환 
		// => 문자열로 전달받은 클래스가 없는 경우 ClassNotFoundExcpetion 발생되므로 반드시 예외 처리 
		Class.forName("xyz.itwill.jdbc.StaticBlock");//수동으로 클래스를 메모리에 저장
		//StaticBlock sb=new StaticBlock();
		//sb.display();
	}
}









