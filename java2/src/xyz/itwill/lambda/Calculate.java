package xyz.itwill.lambda;

//함수형 인터페이스(Functional Interface) : 추상메소드가 하나만 작성된 인터페이스
// => 람다 표현식을 사용하기 위해 반드시 선언해야 되는 인터페이스
// => 인터페이스에 추상메소드를 반드시 하나만 작성 - 정적메소드 또는 기본메소드 작성 가능
// => @FunctionalInterface 어노테이션을 사용하여 작성하는 것을 권장

//@FunctionalInterface : 함수형 인터페이스의 작성규칙을 위반할 경우 에러를 발생하는 어노테이션 
@FunctionalInterface
public interface Calculate {
	int sum(int a, int b);
}
