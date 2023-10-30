package oop;

//Car 클래스를 객체로 생성하여 사용하기 위한 클래스 - 프로그램
public class CarApp {
	public static void main(String[] args) {
		//Car 클래스를 이용하여 객체를 생성해 참조변수에 저장
		// => 하나의 클래스로 서로 다른 속성값이 저장된 다수의 객체 생성
		// => 클래스는 객체를 생성하기 위한 틀(Template)
		// => 객체를 생성하면 객체 필드에는 기본값(숫자형 : 0, 논리형 : false, 참조형 : null)이 초기값으로 자동 저장
		Car carOne=new Car();
		Car carTwo=new Car();
		Car carThree=new Car();
		
		System.out.println("carOne = "+carOne);
		System.out.println("carTwo = "+carTwo);
		System.out.println("carThree = "+carThree);
		System.out.println("==============================================================");
		//참조변수.필드명 : 참조변수에 저장된 객체를 사용하여 필드 사용
		// => 참조변수가 참조하는 객체의 필드에는 기본값이 초기값으로 저장
		//문제점)객체를 사용하여 필드에 직접적인 접근을 허용하면 필드에 비정상적인 값 저장 가능
		//해결법)클래스 선언시 필드가 숨겨지도록 은닉화 처리하여 작성
		// => 참조변수에 저장된 객체를 사용하여 은닉화 처리된 필드를 사용할 경우 에러 발생
		//carOne.modelName="싼타페";//객체 필드값 변경
		//은닉화 처리된 필드값을 직접 변경할 경우 에러가 발생되므로 Setter 메소드를 호출하여 필드값 변경
		carOne.setModelName("싼타페");//매개변수로 전달된 값으로 필드값 변경		
		
		//System.out.println("첫번째 자동차의 모델명 = "+carOne.modelName);//객체 필드값 출력
		//System.out.println("첫번째 자동차의 엔진상태 = "+carOne.engineStatus);
		//System.out.println("첫번째 자동차의 현재속도 = "+carOne.currentSpeed);
		//은닉화 처리된 필드값을 제공받아 출력할 경우 에러가 발생되므로 Getter 메소드를 호출하여 필드값 반환받아 출력
		System.out.println("첫번째 자동차의 모델명 = "+carOne.getModelName());
		System.out.println("첫번째 자동차의 엔진상태 = "+carOne.isEngineStatus());
		System.out.println("첫번째 자동차의 현재속도 = "+carOne.getCurrentSpeed());
		System.out.println("==============================================================");
		/*
		carTwo.modelName="쏘나타";
		carTwo.engineStatus=true;
		carTwo.currentSpeed=80;
		
		System.out.println("두번째 자동차의 모델명 = "+carTwo.modelName);
		System.out.println("두번째 자동차의 엔진상태 = "+carTwo.engineStatus);
		System.out.println("두번째 자동차의 현재속도 = "+carTwo.currentSpeed);
		*/
		carTwo.setModelName("쏘나타");
		carTwo.setEngineStatus(true);
		carTwo.setCurrentSpeed(80);
		
		System.out.println("두번째 자동차의 모델명 = "+carTwo.getModelName());
		System.out.println("두번째 자동차의 엔진상태 = "+carTwo.isEngineStatus());
		System.out.println("두번째 자동차의 현재속도 = "+carTwo.getCurrentSpeed());
		System.out.println("==============================================================");
		//참조변수.메소드명(값, 값,...) : 참조변수에 저장된 객체를 사용하여 메소드 호출
		carOne.startEngine();
		carOne.speedUp(50);
		carOne.speedUp(30);
		carOne.speedDwon(40);
		//carOne.speedZero();
		carOne.stopEngine();
		System.out.println("==============================================================");
	}
}
