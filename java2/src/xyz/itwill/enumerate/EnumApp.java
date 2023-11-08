package xyz.itwill.enumerate;

public class EnumApp {
	public static void main(String[] args) {
		//열거형에 선언된 상수필드값 출력 - 상수필드에 저장된 정수값 대신 상수필드명 출력
		// => 열거형에 선언된 상수필드의 이름이 하나의 값으로 사용
		// => 프로그램에서 상수필드가 값을 대표하는 이름으로 사용 가능
		System.out.println("삽입(EnumOne.INSERT) = "+EnumOne.INSERT);
		System.out.println("변경(EnumOne.UPDATE) = "+EnumOne.UPDATE);
		System.out.println("삭제(EnumOne.DELETE) = "+EnumOne.DELETE);
		System.out.println("검색(EnumOne.SELECT) = "+EnumOne.SELECT);
		System.out.println("==============================================================");
		System.out.println("삽입(EnumTwo.ADD) = "+EnumTwo.ADD);
		System.out.println("변경(EnumTwo.MODIFY) = "+EnumTwo.MODIFY);
		System.out.println("삭제(EnumTwo.REMOVE) = "+EnumTwo.REMOVE);
		System.out.println("검색(EnumTwo.SEARCH) = "+EnumTwo.SEARCH);
		System.out.println("==============================================================");
		//열거형에 선언된 상수필드를 저장하기 위해서는 반드시 열거형을 이용하여 변수를 생성하여 저장
		// => 상수필드가 선언된 열거형을 하나의 자료형으로 사용 가능
		// => 변수에서 변수의 자료형(열거형)의 상수필드만 저장 가능
		//int choice=EnumOne.INSERT;//에러발생
		EnumOne choice=EnumOne.INSERT;
		System.out.println("choice = "+choice);
		System.out.println("==============================================================");
		//나열형으로 선언된 변수값은 같은 자료형(열거형)의 상수필드값만 비교 가능
		// => case 키워드에는 열거형 없는 상수명만 표현하여 비교
		switch (choice) {
		case INSERT:
		//case EnumTwo.ADD:
			System.out.println("# 학생정보를 삽입합니다.");
			break;
		case UPDATE:
			System.out.println("# 학생정보를 변경합니다.");
			break;
		case DELETE:
			System.out.println("# 학생정보를 삭제니다.");
			break;
		case SELECT:
			System.out.println("# 학생정보를 검색합니다.");
			break;
		}
		System.out.println("==============================================================");
	}
}