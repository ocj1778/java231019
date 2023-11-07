package xyz.itwill.enumerate;

public class CompassApp {
	public static void main(String[] args) {
		//열거형 내부에 선언된 상수필드값 출력 - 상수필드의 이름을 제공받아 출력
		System.out.println("동쪽 = "+Compass.EAST);
		System.out.println("서쪽 = "+Compass.WEST);
		System.out.println("남쪽 = "+Compass.SOUTH);
		System.out.println("북쪽 = "+Compass.NORTH);
		System.out.println("==============================================================");
		//EnumType.values() : 열거형 내부에 선언된 모든 상수필드를 배열로 변환하여 반환하는 정적메소드
		//배열에 저장된 상수필드를 차례대로 제공받아 변수에 저장하여 반복 처리 
		for(Compass compass : Compass.values()) {
			//EnumType.ordinal() : 상수필드를 구분하기 위한 첨자(Index)를 반환하는 메소드
			System.out.println(compass+" : "+compass.ordinal()+" = "+compass.getValue());
		}
		System.out.println("==============================================================");
	}
}
