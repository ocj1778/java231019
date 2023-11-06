package xyz.itwill.realization;

//인터페이스 선언시 extends 키워드를 사용하여 기존 인터페이스를 상속받아 작성 가능
// => 다수의 인터페이스 상속 가능 - 다중상속
public interface BoatCar extends Car, Boat {
	void floating();
}
