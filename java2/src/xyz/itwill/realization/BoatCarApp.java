package xyz.itwill.realization;

public class BoatCarApp {
	public static void main(String[] args) {
		//BoatCarReal boatCar=new BoatCarReal();
		
		//자식클래스의 생성자로 자식객체를 생성하여 인터페이스로 생성된 참조변수에 자식객체 저장
		// => 묵시적 객체 형변환에 의해 자식클래스의 메소드 호출
		// => 부모 인터페이스에 따라 호출이 불가능한 메소드 발생 가능
		BoatCar boatCar=new BoatCarReal();
		//Car boatCar=new BoatCarReal();
		//Boat boatCar=new BoatCarReal();
		
		boatCar.run();
		boatCar.navigate();
		boatCar.floating();
	}
}
