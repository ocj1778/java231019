package oop;

//클래스(Class) : 객체(Object)를 생성하기 위한 자료형 - 참조형
// => Java 프로그램에서는 객체(Object) 대신 인스턴스(Instance)로 표현
// => 현실에 존재하는 대상을 클래스 자료형으로 표현하여 프로그램에서 사용되는 객체 생성

//클래스 자료형 선언 방법 
//형식) [public] class 클래스명 {
//             필드(Field) : 표현 대상의 속성(값)을 저장하기 위한 변수 - 멤버변수
//             생성자(Constructor) : 객체를 생성하기 위한 특별한 메소드
//             메소드(Method) : 표현 대상의 행위(기능)을 제공하기 위한 함수 - 멤버함수
//      }
// => 클래스명은 식별자로 파스칼 표기법을 사용하여 작성
// => 클래스 내부의 모든 메소드는 필드를 이용하여 필요한 행위(기능) 구현
// => 클래스 내부에 생성자를 작성하지 않으면 매개변수가 없는 기본 생성자가 자동으로 생성되어 제공

//클래스 자료형을 사용하여 객체를 생성하는 방법
//형식) 클래스명 참조변수=new 클래스명();
// => new 연산자로 클래스 내부에 선언된 생성자(Constructor)를 호출하여 객체 생성
// => 힙영역에 생성된 객체의 메모리 주소를 참조변수에 저장하여 참조변수에 저장된 메모리 주소로 객체 참조
// => 참조변수에 저장된 메모리 주소로 객체를 참조하여 . 연산자를 사용해 객체의 필드 또는 메소드 사용

//클래스를 선언할 때 필드와 메소드에 접근 제한자를 사용하여 객체의 접근 허용 관련 설정 가능
//접근 제한자(Access Modifier) : private, package(default), protected, public
// => 클래스, 필드, 생성자, 메소드를 작성할 때 접근 허용 관련 설정을 하기 위한 키워드(제한자)
//private : 클래스 내부에서만 접근 가능하도록 허용하는 접근 제한자
// => 필드, 생성자, 메소드를 은닉화 처리하기 위해 사용 - 클래스 외부에서 접근할 경우 에러 발생
// => 일반적으로 필드를 작성할 때 사용 - 객체를 사용하여 필드에 직접적인 접근 제한하여 비정상적인 값이 저장되는 것을 방지
// => 데이타 은닉화(Data Hiding) : 값을 숨겨 보호하기 위한 기능 - 비정상적인 값 저장 방지
//public : 모든 패키지의 클래스에서 접근 가능하도록 허용하는 접근 제한자
// => 일반적으로 메소드 작성할 때 사용 - 프로그램 작성에 필요한 모든 클래스(객체)에서 사용 가능하도록 허용

//자동차를 모델링하여 작성된 클래스
// => 속성 : 모델명, 엔진상태, 현재속도 - 필드
// => 행위 : 시동 온(On), 시동 오프(Off), 속도 증가, 속도 감소, 이동 중지 - 메소드
public class Car {
	//필드(Field) : 표현대상의 속성값을 저장하기 위한 변수
	// => 클래스 내부의 작성된 모든 메소드에서 필드 사용 가능
	private String modelName;//모델명
	private boolean engineStatus;//엔진상태 - false : EngineOff, true : EngineOn
	private int currentSpeed;//현재속도
	
	//생성자(Constructor) : 표현대상을 객체를 생성하기 위한 특별한 메소드
	// => 클래스 내부에 생성자를 작성하지 않으면 매개변수가 없는 기본 생성자(Default Constructor)를
	//자동으로 생성하여 제공
	
	//메소드 : 표현대상의 행위(기능)을 제공하기 위한 함수
	// => 필드를 사용하여 메소드 내부에 작성된 명령으로 필요한 기능 구현
	public void startEngine() {//시동 온(On)
		engineStatus=true;
		System.out.println(modelName+"의 자동차 시동을 켰습니다.");
	}
	
	public void stopEngine() {//시동 오프(Off)
		if(currentSpeed != 0) {
			/*
			currentSpeed=0;
			System.out.println(modelName+"의 자동차가 멈췄습니다.");
			*/
			
			//클래스 내부에 작성된 메소드는 서로 호출 가능
			// => 코드의 중복성을 최소화 하여 프로그램의 생산성 및 유지보수의 효율성 증가
			speedZero();
		}
		
		engineStatus=false;
		System.out.println(modelName+"의 자동차 시동을 껐습니다.");
	}
	
	public void speedUp(int speed) {//속도 증가
		if(!engineStatus) {//엔진이 꺼져 있는 경우
			System.out.println(modelName+"의 자동차 시동이 꺼져 있습니다.");
			return;
		}
		
		if(currentSpeed+speed > 150) {
			speed = 150 - currentSpeed;
		}
		
		currentSpeed+=speed;
		System.out.println(modelName+"의 자동차 속도가 "+speed
				+"Km/h 증가 되었습니다. 현재 속도는 "+currentSpeed+"Km/h 입니다.");
	}
	
	public void speedDwon(int speed) {//속도 감소
		if(!engineStatus) {//엔진이 꺼져 있는 경우
			System.out.println(modelName+"의 자동차 시동이 꺼져 있습니다.");
			return;
		}
		
		if(currentSpeed < speed) {
			speed = currentSpeed;
		}
		
		currentSpeed-=speed;
		System.out.println(modelName+"의 자동차 속도가 "+speed
				+"Km/h 감소 되었습니다. 현재 속도는 "+currentSpeed+"Km/h 입니다.");
	}
	
	public void speedZero() {//이동 중지
		currentSpeed=0;
		System.out.println(modelName+"의 자동차가 멈췄습니다.");
	}
	
	//은닉화 처리된 필드를 위해 필드값을 반환하는 Getter 메소드와 필드값을 변경하는 Setter 
	//메소드 작성 - 캡슐화
	//캡슐화(Encapsulation) : 표현대상의 속성(필드)과 행위(메소드)를 하나의 자료형(클래스)로 선언
	// => 필드를 은닉화 처리하여 필드값을 보호하고 메소드를 호출하여 필드값 처리  
	
	//Getter 메소드 : 클래스 외부에서 필드값을 사용할 수 있도록 필드값을 반환하는 메소드
	//형식) public 반환형 메소드명() { return 필드명; }
	// => 메소드의 이름은 [get필드명] 형식으로 작성하는 것을 권장
	// => 필드의 자료형이 [boolean]인 경우 메소드의 이름은 [is필드명] 형식으로 작성
	public String getModelName() { //모델명을 반환하는 메소드
		return modelName;
	}
	
	//Setter 메소드 : 클래스 외부의 값을 매개변수로 전달받아 매개변수에 저장된 값으로 필드값 변경하는 메소드
	//형식) public void 메소드명(자료형 매개변수) { 필드명=매개변수; }
	// => 메소드의 이름은 [set필드명] 형식으로 작성하는 것을 권장
	// => 매개변수에 전달되어 저장된 값을 검증 가능
	public void setModelName(String modelName) {//매개변수를 이용하여 모델명을 변경하는 메소드
		//매개변수에 저장된 값에 대한 데이타 검증 후 필드값으로 저장
		//this : 메소드 내부에서 클래스의 객체를 표현하기 위한 키워드
		// => 필드는 this 키워드를 사용하여 표현하고 매개변수는 this 키워드를 사용하지 않고 표현
		this.modelName=modelName;
	}

	//이클립스에서는 은닉화 처리되어 작성된 필드에 대한 Getter 메소드와 Setter 메소드를
	//자동으로 생성하는 기능 제공
	//[Alt]+[Shift]+[S] >> 팝업메뉴 - [R] >> Getter & Setter 메소드 생성창 >> 필드 선택 >> [Generate] 클릭 
	public boolean isEngineStatus() {
		return engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) {
		this.engineStatus = engineStatus;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
	
}




















