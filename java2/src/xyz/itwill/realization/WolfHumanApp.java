package xyz.itwill.realization;

//인터페이스(Interface) : 현실에 존재하는 대상을 클래스보다 추상적으로 표현하기 위한 자료형
// => 인터페이스에는 상수필드(Constant Field)와 추상메소드(Abstract Method)만을 작성
// => JDK11 이상에서는 인터페이스에 정적메소드(Static Method)와 기본메소드(Default Method)도 작성 가능
//형식) public interface 인터페이스명 {
//			자료형 필드명=값;//public static final 생략 가능
//			반환형 메소드명(자료형 변수명,...);//public abstract 생략 가능
//      }
// => 인터페이스의 이름은 파스칼 표기법을 사용하여 작성하는 것을 권장

//클래스 선언시 인터페이스를 상속받아 작성    
//형식) public class 자식클래스명 implements 인터페이스명, 인터페이스명,... {  }
// => 클래스는 implements 키워드를 사용하여 다수의 인터페이스를 상속받아 작성 가능 - 다중상속
// => 자식클래스는 상속받은 모든 인터페이스의 추상메소드를 무조건 오버라이드 선언
// => 인터페이스로 객체 생성은 불가능하지만 참조변수를 생성하여 자식클래스의 생성자로 만들진
//객체 저장 가능 - 묵시적 객체 형변환에 의해 참조변수로 자식객체를 참조해 자식클래스의 메소드 호출

//인터페이스 선언시 다른 인터페이스를 상속받아 작성 가능 - 다중 상속 가능
//형식) public interface 인터페이스명 extends 인터페이스명, 인터페이스명, ... { }

//인터페이스를 선언하여 클래스를 만들때 상속 받아야 되는 이유
//1.클래스의 단일 상속 관련 문제를 일부 보완하기 위해 인터페이스 사용
//ex) public class 늑대인간 extends 인간, 늑대  =>  불가능(에러 발생)
//    public class 늑대인간 extends 인간 implements 늑대  =>  가능
//    public class 흡혈늑대인간 extends 인간 implements 늑대, 흡혈귀  =>  가능
//2.클래스 선언시 반드시 만들어야 되는 메소드를 정의하기 위해 인터페이스 사용 - 작업지시서
//ex) TV or Radio or SmartPhone >> 볼륨 증가, 불륨 감소 - 인터페이스 
// => 인터페이스를 상속받은 모든 자식클래스에 동일한 메소드가 선언되도록 규칙 제공
// => 클래스간의 결합도를 낮추어 시스템 변경에 따른 유지보수의 효율성 증가

public class WolfHumanApp {
	public static void main(String[] args) {
		
	}
}













