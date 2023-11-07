package xyz.itwill.enumerate;

//열거형(EnumerateType) : 상수필드만을 선언하기 위한 자료형
//형식) public enum 열거형명 { 상수명; 상수명; ...  }
// => 열거형의 이름은 파스칼 표기법을 사용하여 작성하는 것을 권장
public enum EnumOne {
	//상수필드 선언 - public static final 제한자 및 int 자료형 생략 가능
	// => 열거형의 상수필드에는 0부터 1씩 증가되는 정수값이 기본값으로 자동 저장
	INSERT, UPDATE, DELETE, SELECT;
}
