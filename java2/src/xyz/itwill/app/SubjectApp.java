package xyz.itwill.app;

//패키지(Package) : 같은 목적의 자료형(참조형)을 명확하게 구분하기 그룹화 하기 위한 폴더
// => Java 참조형 : 클래스(Class), 인터페이스(Interface), 열거형(Enum)
// => Java 자료형을 보다 쉽게 찾아 사용하기 위해 패키지을 사용하는 것을 권장

//패키지의 이름은 도메인을 역방향으로 나열하여 작성한 후 그룹명을 지정하여 작성하는 것을 권장
// => 도메인(Domain) : 인터넷에서 개인 또는 그룹이 사용하는 컴퓨터를 표현하기 위해 사용하는 고유의 네트워크 이름
// => ex) itwill.xyz - 도메인 >> xyz.itwill.app 

//패키지(폴더)에 작성된 Java 소스파일에서는 Java 자료형 작성시 소스파일 처음 위치에 Java  
//자료형이 선언될 패키지를 반드시 작성
//형식) package 패키지경로;
// => Java 자료형이 특정 패키지에 작성되어 있는지를 명확히 구분하여 사용

//import : 다른 패키지에 작성된 Java 자료형을 명확히 표현하여 사용하기 위한 키워드
//형식) import 패키지경로.자료형;  
// => Java 자료형 대신 *(전체) 사용 가능
// => package 선언문 뒤에 작성하며 Java 자료형 선언 전에 작성 

import xyz.itwill.subject.OracleSubject;

public class SubjectApp {
	public static void main(String[] args) {
		//같은 패키지에 선언된 Java 자료형은 패키지 경로를 표현하지 않아도 Java 자료형 사용 가능
		// => 자료형
		//다른 패키지에 선언된 Java 자료형은 패키지 경로를 반드시 표현해야만 Java 자료형 사용 가능
		// => 패키지경로.자료형
		//xyz.itwill.subject.OracleSubject subject1=new xyz.itwill.subject.OracleSubject();
		
		//다른 패키지에 선언된 Java 자료형을 import 처리하면 패키지 경로를 표현없이 Java 자료형 사용 가능
		OracleSubject subject1=new OracleSubject();
		subject1.display();
	}
}














