package xyz.itwill.util;

import java.util.Scanner;
import java.util.regex.Pattern;

//java.util.regex 패키지 : 정규표현식 관련 기능을 제공하기 위한 Java 자료형이 선언된 패키지

//정규표현식(RegualarExpression) : 메타문자(Meta Character), 회피문자(Escape Character)등을
//사용하여 일정한 규칙의 문자열을 제공하는 표현식 - 사용자 입력값에 대한 검증 처리
/*
^문자 : 문자(열)로 시작됨을 의미
문자$ : 문자(열)로 종료됨을 의미
. : 임의의 문자 하나를 의미(\ 문자 제외)
[문자1문자2문자3] : 나열된 문자 중 하나를 의미
[^문자1문자2문자3] : 나열된 문자를 제외한 문자 중 하나를 의미
[문자1-문자2] : [문자1]부터 [문자2] 범위의 문자 중 하나를 의미
(문자열1|문자열2|문자열3) : 나열된 문자열 중 하나를 의미
문자열+ : 문자열이 1번이상 반복됨을 의미
문자열* : 문자열이 0번이상 반복됨을 의미
문자열? : 문자열이 0번 또는 1번 존재함을 의미
문자열{숫자} : 문자열이 [숫자]만큼 반복됨을 의미
문자열{숫자1,숫자2} : 문자열이 [숫자1]부터 [숫자2]만큼 반복됨을 의미
(?!)문자열 : 문자열에서 대소문자를 구분하지 않음을 의미
(?=문자열) : 문자열이 반드시 포함됨을 의미
(!=문자열) : 문자열이 반드시 포함되지 않음을 의미
*/

/*
\s : 공백이 있는 문자열을 의미
\S : 공백이 없는 문자열을 의미
\w : 영문자, 숫자, 특수문자(_)의 문자로만 구성된 문자열을 의미
\W : 영문자, 숫자, 특수문자(_)의 문자를 제외한 문자로 구성된 문자열을 의미
\d : 숫자 형태의 문자로만 구성된 문자열을 의미
\D : 숫자 형태의 문자를 제외한 문자로 구성된 문자열을 의미
\메타문자 : 메타문자를 일반문자로 표현됨을 의미 - ex) \. : 문자 .
*/

//키보드로 사용자에게 값을 입력받아 원하는 패턴의 값인지를 비교하여 출력하는 프로그램 작성
// => 입력값이 원하는 패턴의 문자열이 아닌 경우 에러 메세지 출력 후 프로그램 종료
public class RegualarExpressionApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//키보드로 [아이디]를 입력받아 원하는 패턴의 [아이디]인지를 검사
		// => 아이디는 영문자로 시작되며 영문자, 숫자, 특수문자(_)의 조합으로 6~20 범위의
		//문자들로 구성된 패턴을 가진 문자열
		System.out.print("아이디 입력 >> ");
		String id=scanner.nextLine();
		
		if(id==null || id.equals("")) {//사용자 입력값이 없는 경우
			System.out.println("[에러]아이디를 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//아이디에 대한 패턴을 정규표현식으로 표현하여 저장
		//String idReg="^[a-zA-Z][a-zA-Z0-9_]{5,19}$";
		String idReg="^[a-zA-Z]\\w{5,19}$";
		
		//Pattern 클래스 : 정규표현식을 저장하기 위한 클래스
		// => 정규표현식 관련 기능을 메소드로 제공
		//Pattern.matches(String regEx, CharSequence input) : 정규표현식의 패턴으로 입력값을
		//비교하여 입력값이 패턴과 다르면 [false]를 반환하고 같으면 [true]를 반환하는 정적메소드
		// => CharSequence 인터페이스 : 문자열을 저장하기 위한 클래스가 상속받기 위한 인터페이스
		if(!Pattern.matches(idReg, id)) {
			System.out.println("[에러]아이디는 6~20자의 영문자, 숫자와 특수기호(_)만 사용 가능합니다.");
			System.exit(0);
		}

		System.out.println("[메세지]패턴에 맞는 아이디를 입력 하였습니다.");
		System.out.println();
		
		//키보드로 [비밀번호]를 입력받아 원하는 패턴의 [비밀번호]인지를 검사
		// => 비밀번호는 영문자, 숫자, 특수문자가 반드시 1번 이상 포함된 8~30 범위의 문자들로
		//구성된 패턴을 가진 문자열
		System.out.print("비밀번호 입력 >> ");
		String password=scanner.nextLine();
		
		if(password==null || password.equals("")) {
			System.out.println("[에러]비밀번호를 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		String passwordReg="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{8,30}$";

		if(!Pattern.matches(passwordReg, password)) {
			System.out.println("[에러]비밀번호는 8~30자의 영문자, 숫자, 특수기호가 반드시 1번이상 포함되도록 입력해 주세요.");
			System.exit(0);
		}
		
		System.out.println("[메세지]패턴에 맞는 비밀번호를 입력 하였습니다.");
		System.out.println();
		
		//키보드로 [이메일]를 입력받아 원하는 패턴의 [이메일]인지를 검사
		// => 이메일은 [아이디@도메인] 형식의 패턴을 가진 문자열
		System.out.print("이메일 입력 >> ");
		String email=scanner.nextLine();
		
		if(email==null || email.equals("")) {
			System.out.println("[에러]이메일을 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		String emailReg="^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)*$";
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("[에러]아이디@도메인 형식으로 이메일을 입력해 주세요.");
			System.exit(0);
		}
		
		System.out.println("[메세지]패턴에 맞는 이메일를 입력 하였습니다.");
		
		scanner.close();
	}
}
