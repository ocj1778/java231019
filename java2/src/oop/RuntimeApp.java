package oop;

import java.io.IOException;

//Runtime 클래스 : 프로그램 실행 관련 정보를 제공하기 위한 기능의 메소드가 작성된 클래스
// => Runtime 클래스는 프로그램에 하나의 객체만 제공하는 클래스 - 싱글톤 클래스(Singleton Class)
public class RuntimeApp {
	public static void main(String[] args) throws IOException {
		//Runtime 클래스는 생성자가 은닉화 처리되어 있으므로 new 연산자가 생성자를 호출하여 
		//객체 생성 불가능
		//Runtime runtime=new Runtime();
		
		//Runtime.getRuntime() : Runtime 객체를 반환하는 메소드
		// => 정적 메소드이므로 클래스를 사용하여 호출
		// => getRuntime() 메소드를 여러번 호출해도 동일한 객체를 반환
		Runtime runtime1=Runtime.getRuntime();
		Runtime runtime2=Runtime.getRuntime();
		
		System.out.println("runtime1 = "+runtime1);
		System.out.println("runtime2 = "+runtime2);
		System.out.println("==============================================================");
		System.out.print("메모리를 정리하기 전 JVM 사용 메모리의 크기 >> ");
		//Runtime.totalMemory() : JVM이 사용 가능한 전체 메모리의 크기를 반환하는 메소드
		//Runtime.freeMemory() : JVM이 사용 가능한 여유 메모리의 크기를 반환하는 메소드
		System.out.println(runtime1.totalMemory()-runtime1.freeMemory()+"Byte");
		
		//Runtime.gc() : 메모리를 정리하는 프로그램(Garbage Collector)를 실행하는 메소드
		runtime1.gc();//System.gc() : Runtime.gc() 메소드와 동일한 기능을 제공하는 메소드

		System.out.print("메모리를 정리한 후 JVM 사용 메모리의 크기 >> ");
		System.out.println(runtime1.totalMemory()-runtime1.freeMemory()+"Byte");
		
		//Runtime.exec(String command) : 운영체제에 명령을 전달하여 실행하는 메소드
		runtime2.exec("calc.exe");
		System.out.println("==============================================================");
	}
}












