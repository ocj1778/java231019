package xyz.itwill.enumerate;

public enum Compass {
	//열거형 내부에 선언된 상수필드는 기본적으로 정수형(int)으로 설정
	// => 상수필드를 선언하면 열거형 내부의 기본 생성자를 이용하여 상수필드의 첨자로 초기값이 자동 저장
	// => 상수필드에 차례대로 0부터 1씩 증가되는 정수값이 초기값으로 저장
	//EAST, WEST, SOUTH, NORTH;
	
	//매개변수가 존재하는 생성자를 만든 경우 상수필드를 선언할 때 생성자로 필요한 초기값 저장
	EAST(1), WEST(2), SOUTH(3), NORTH(4);
	
	//상수필드의 저장값을 표현하기 위해 필드
	// => 생성자를 선언하지 않은 기본 생성자를 사용하여 모든 상수필드에 [0]이 저장
	// => 상수필드에 원하는 값을 저장하기 위해서는 생성자 작성
	// => Getter 메소드만 작성되도록 final 제한자를 사용하여 필드 선언하는 것을 권장
	// => 필드의 자료형을 [int]가 아닌 [String]으로 변경하면 상수필드에 초기값으로 문자열 저장 가능 
	private final int value;
	
	//상수필드에 원하는 값을 초기값으로 저장하기 위한 생성자
	// => [private] 접근제한자를 사용하여 생성자 작성
	// => 매개변수로 전달받은 값을 이용하여 상수필드에 저장될 초기값으로 사용
	private Compass(int value) {
		this.value=value;
	}
	
	//상수필드에 저장된 값을 반환하기 위한 메소드
	public int getValue() {
		return value;
	}
}
