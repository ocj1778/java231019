package inheritance;

public class CarApp {
	public static void main(String[] args) {
		Car car=new Car("싼타페", "홍길동");
		
		System.out.println("모델명 = "+car.getModelName());
		System.out.println("소유자 = "+car.getUserName());
		System.out.println("==============================================================");
		/*
		//Object.toString() : 참조변수에 저장된 객체를 참조하여 "클래스명@메모리주소" 형식의
		//문자열로 변환하여 반환하는 메소드
		System.out.println("car.toString() = "+car.toString());
		//참조변수를 출력 처리할 경우 자동으로 Object 객체를 참조하여 toString() 메소드를 자동 호출
		// => 참조변수를 출력할 경우 toString() 메소드 호출은 생략 가능
		System.out.println("car = "+car);
		*/
		
		//묵시적 객체 형변환에 의해 Object 클래스의 toString() 메소드가 아닌 Car 클래스에
		//작성된 toString() 메소드가 자동 호출되어 Car 객체의 필드값 출력
		System.out.println("car = "+car);
		System.out.println("==============================================================");
		//문자열이 저장된 String 객체를 생성하여 메모리 주소를 String 클래스의 참조변수에 저장
		String name="홍길동";
		
		//String.toString() : String 객체에 저장된 문자열을 반환하는 메소드
		//System.out.println("이름 = "+name.toString());
		//참조변수를 출력할 경우 String 클래스에 오버라이드 선언된 toString() 메소드 자동 호출
		System.out.println("이름 = "+name);
		System.out.println("==============================================================");
	}
}
