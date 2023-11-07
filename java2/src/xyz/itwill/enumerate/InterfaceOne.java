package xyz.itwill.enumerate;

public interface InterfaceOne {
	//상수필드(Constant Field) - public static final 제한자 생략 가능
	// => 상수(Constant) : 프로그램에서 리터럴 대신 시용하기 위한 의미있는 단어
	// => 클래스에서도 상수필드를 선언할 수 있지만 상수를 보다 쉽게 선언하거나 사용하기 위해
	//인터페이스에 상수필드를 만드는 것을 권장
	int INSERT=1, UPDATE=2, DELETE=3, SELECT=4;
}
