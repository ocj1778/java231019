package basic;

//switch : 값을 비교하여 명령을 선택 실행하기 위한 키워드 - 실수값 비교 불가능
//형식) switch({변수|연산식}) {
//			case 값1 : 명령; 명령; ... [break;]
//			case 값2 : 명령; 명령; ... [break;]
//			case 값3 : 명령; 명령; ... [break;]
//			...
//			[default : 명령; 명령; ...]
//      }
// => switch 키워드의 () 기호에 변수 또는 연산식을 작성하여 비교하고자 하는 값 제공
// => switch 키워드로 제공되는 값을 case 키워드로 제공되는 값과 차례대로 비교하여 같은 값을 
//가지고 있는 case 키워드 위치에 작성된 명령부터 하단에 작성된 모든 명령들을 실행
// => case 키워드로 제공되는 값은 리터럴 또는 상수(Constant)만 작성 가능
// => case 키워드로 제공되는 값이 중복되어 작성될 경우 에러 발생
// => 블럭 내부의 명령 중 break 명령을 실행하면 switch 구문 종료
// => switch 키워드로 제공되는 값이 case 제공되는 모든 값과 다른 경우 default 키워드로 제공
//되는 명령 실행 - 생략 가능 

public class SwitchApp {
	public static void main(String[] args) {
		//int choice=1;
		//int choice=2;
		int choice=3;
		
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		}
		System.out.println("===============================================================");
		choice=4;
		
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		}
		System.out.println("===============================================================");
		choice=5;

		//switch 키워드로 제공되는 값이 case 키워드로 제공되는 모든 값들과 다른 경우 default 
		//키워드로 제공되는 명령을 무조건 실행
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		default:
			System.out.println("지구로 이동합니다.");
		}
		System.out.println("===============================================================");
		choice=1;

		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
			break;
		case 2:
			System.out.println("금성으로 이동합니다.");
			break;
		case 3:
			System.out.println("화성으로 이동합니다.");
			break;
		default:
			System.out.println("지구로 이동합니다.");
		}
		System.out.println("===============================================================");
		int jumsu=85;
		
		//변수값이 0~100 범위의 유효한 값이 맞는지를 구분하여 출력하는 프로그램 작성
		if(jumsu >= 0 && jumsu <= 100) {
			//변수값(점수)을 이용하여 등급(학점)을 구분하여 출력하는 프로그램 작성
			String grade;
			
			switch(jumsu/10) {
			case 10:
			case 9: grade="A"; break;
			case 8: grade="B"; break;
			case 7: grade="C"; break;
			case 6: grade="D"; break;
			default: grade="F";
			}
			
			System.out.println("[결과]"+jumsu+"점 = "+grade+"학점");			
		} else {
			System.out.println("[에러]0~100 범위를 벗어난 비정상적인 점수가 입력 되었습니다.");
		}
		System.out.println("===============================================================");
		String kor="둘";
		String eng="";
		
		//문자열을 비교하여 명령 선택 실행 가능
		switch(kor) {
		case "하나": eng="One"; break;
		case "둘": eng="Two"; break;
		case "셋": eng="Three"; break;
		}
		
		System.out.println("[결과]"+kor+" = "+eng);
		System.out.println("===============================================================");
	}
}
