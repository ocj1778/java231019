package inheritance;

//자동차 정보(모델명, 소유자명)를 저장하기 위한 클래스
// => 클래스 작성시 상속받은 부모클래스가 없는 경우 무조건 Object 클래스를 자동으로 상속받아 사용
// => 모든 Java 클래스는 Object 클래스를 상속받기 때문에 Object 클래스의 메소드 사용 가능
//Object 클래스 : 모든 Java 클래스의 부모클래스 - 최선조 클래스(Root Class)
// => Object 클래스로 생성된 참조변수에는 모든 클래스로 생성된 객체 저장 가능
// => Object 클래스는 모든 Java 클래스를 대표하기 위한 자료형
public class Car /* extends Object */ {
	private String modelName;
	private String userName;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, String userName) {
		super();
		this.modelName = modelName;
		this.userName = userName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//Object 클래스(부모클래스)의 toString() 메소드를 오버라이드 선언
	// => Object 클래스의 toString() 메소드는 숨겨지고 자식클래스의 toString() 메소드 사용
	// => VO 클래스의 모든 필드값을 문자열로 변환하여 반환하는 기능 제공 - 필드값 확인
	@Override
	public String toString() {
		return "modelName : "+modelName+", userName : "+userName;
	}
}
