package basic;

//연산자(Operator) : 계산을 목적으로 제공되는 기호 또는 키워드
// => 피연산자 : 연산자에 의해 계산되는 값을 의미
// => 단항연산자(피연산자 : 1개), 이항연산자(피연산자 : 2개), 삼항연산자(피연산자 : 3개)

//일반적으로 연산식은 왼쪽에서 오른쪽 방향으로 실행되지만 단항 연산자와 대입 연산자를 이용한
//연산식은 오른쪽에서 왼쪽 방향으로 실행되어 처리
//ex)  A + B + C         A = B = C
//     ────→        ←──── 
public class OperatorApp {
	public static void main(String[] args) {
		//최우선 연산자 : 무조건 가장 먼저 연산 처리되는 연산자
		// => () : 우선 처리 연산자, [] : 배열 연산자, . 연산자 : 객체 연산자
		System.out.println("10 + 20 * 3 = "+(10+20*3));
		System.out.println("(10 + 20) * 3 = "+((10+20)*3));
		System.out.println("===============================================================");
		//단항 연산자 : 피연산자의 갯수가 1개인 연산자
		// => + : 양수화 연산자 - 피연산자에 +1를 곱한 결과값을 제공하는 연산자
		// => - : 음수화 연산자(2의 보수 연산자) - 피연산자에 -1를 곱한 결과값을 제공하는 연산자
		// => ~ : Bit Not 연산자(1의 보수 연산자) - 피연산자(정수값)로 표현된 Bit 단위의 값을 반대로 변환하여 제공하는 연산자
		// => ! : Not 연산자 - false(거짓)와 true(참)를 반대로 변환하여 제공하는 연산자
		// => ++ : 1 증가 연산자 - 피연산자를 반드시 변수로 사용하며 변수의 값을 1 증가하여 저장하는 연산자 
		// => -- : 1 감소 연산자 - 피연산자를 반드시 변수로 사용하며 변수의 값을 1 감소하여 저장하는 연산자 
		// => (자료형) : 강제 형변환 연산자 - 피연산자의 자료형을 일시적으로 변환하여 제공하는 연산자
		// => new : 객체 생성 연산자 - 클래스의 생성자를 이용하여 객체를 생성하여 제공하는 연산자
		
		int a1=10;
		System.out.println("a1 = "+a1);
		System.out.println("-a1 = "+(-a1));
		System.out.println("===============================================================");
		System.out.println("20 > 10 = "+(20>10));
		System.out.println("!(20 > 10) = "+!(20>10));
		System.out.println("===============================================================");
		int a2=10, a3=10;
		System.out.println("a2 = "+a2+", a3 = "+a3);
		
		//++a2;//a2=a2+1;
		//--a3;//a3=a3-1;
		
		//++ 연산자와 -- 연산자는 피연산자에 뒤에 위치하여 작성 가능
		// => ++ 연산자와 -- 연산자를 사용한 단일 명령인 경우 연산자의 위치는 연산결과에 미영향
		a2++;
		a3--;

		System.out.println("a2 = "+a2+", a3 = "+a3);
		System.out.println("===============================================================");
		int a4=10, a5=10;
		System.out.println("a4 = "+a4+", a5 = "+a5);

		//++ 연산자와 -- 연산자를 사용한 단일 명령이 아닌 경우 연산자의 위치는 연산결과에 영향
		int result1=++a4;//전처리 : ++a4 연산식이 실행된 후 result1=a4 연산식 실행
		int result2=a5++;//후처리 : result2=a5 연산식이 실행된 후 a5++ 연산식 실행
		System.out.println("a4 = "+a4+", a5 = "+a5);
		System.out.println("result1 = "+result1+", result2 = "+result2);
		System.out.println("===============================================================");
		//이항 연산자 : 피연산자의 갯수가 2개인 연산자
		// => 산술 연산자, 이동 연산자, 비교 연산자, 논리 연산자, 대입 연산자
		//산술 연산자 : *(곱), /(나눔), %(나머지), +(합 또는 문자열 결합), -(차)
		int b1=20, b2=10;
		System.out.println(b1+" * "+b2+" = "+(b1*b2));
		System.out.println(b1+" / "+b2+" = "+(b1/b2));
		System.out.println(b1+" % "+b2+" = "+(b1%b2));
		System.out.println(b1+" + "+b2+" = "+(b1+b2));
		System.out.println(b1+" - "+b2+" = "+(b1-b2));
		System.out.println("===============================================================");
		//이동 연산자 : 정수값을 원하는 방향으로 Bit 수만큼 이동하는 연산자
		// => <<(왼쪽 이동 연산자), >>(오른쪽 이동 연산자), >>>(오른쪽 이동 연산자)
		//50(10) : 4Byte - 00000000 00000000 00000000 00110010
		//50 << 3 :  00000000 00000000 00000001 10010000 - 400(10)     
		//50 >> 3 :  00000000 00000000 00000000 00000110 - 6(10)
		//-50(10) : 4Byte - 11111111 11111111 11111111 11001110
		//-50 >> 3 : 11111111 11111111 11111111 11111001
		//-50 >>> 3 : 00011111 11111111 11111111 11111001
		
		//비교(관계) 연산자 : 값을 비교하여 false 또는 true 중 하나의 논리값을 제공하는 연산자
		// => >, <, >=, <=, ==, !=, instanceof : 객체 비교 연산자
		System.out.println("20 > 10 = "+(20>10));
		System.out.println("20 < 10 = "+(20<10));
		System.out.println("20 == 10 = "+(20==10));
		System.out.println("20 != 10 = "+(20!=10));
		System.out.println("===============================================================");
		//논리 연산자 : Bit 논리 연산자, 일반 논리 연산자
		// => Bit 논리 연산자 : 두 피연산자의 정수값을 Bit 단위로 계산하기 위한 연산자 - &(논리곱), ^(배타적 논리합), |(논리합)
		// => 일반 논리 연산자 : 두 개의 비교 연산식을 연결하기 위한 연산자 - &&(and 연산자), ||(or 연산자)
		//int c=20;
		int c=-20;
		System.out.println("c = "+c);
		
		//변수>=작은값 && 변수<=큰값 : 변수값이 작은값~큰값 범위의 값인지를 확인하기 위한 연산식
		//&& 연산자는 첫번째 비교식이 거짓인 경우 두번째 조건식 미실행
		System.out.println("c >= 10 && c <=30 = "+(c>=10 && c<=30));
		//|| 연산자는 첫번째 비교식이 참인 경우 두번째 조건식 미실행
		System.out.println("c < 10 || c > 30 = "+(c<10 || c>30));
		System.out.println("===============================================================");
		//삼항 연산자 : 피연산자의 갯수가 3개인 연산자
		//형식) 조건식 ? 참값 : 거짓값
		// => 조건식 : false 또는 true 중 하나의 논리값을 제공하는 연산식
		// => 조건식이 [true]인 경우 참값을 제공하고 [false]인 경우 거짓값을 제공
		//int d1=20, d2=10;
		int d1=10, d2=20;
		System.out.println("큰값 = "+(d1 > d2 ? d1 : d2));
		System.out.println("===============================================================");
		//int d3=10;
		int d3=11;
		
		//[X % Y] 연산식의 결과값을 0과 비교하여 같은 경우 X는 Y의 배수로 표현 
		System.out.println(d3+" = "+(d3 % 2 == 0 ? "짝수" : "홀수"));
		System.out.println("===============================================================");
		//대입 연산자 : 왼쪽 피연산자(변수)에 값을 저장하기 위한 연산자
		// => 무조건 마지막에 실행되는 연산자
		// => 순수 대입 연산자 : 변수에 값을 저장하는 연산자 - =
		// => 연산 대입 연산자 : 변수값을 연산 처리하여 변수에 저장하는 연산자 - *=, /=, %=, +=, -=, <<=, >>=, >>>=, &=, ^=, |=
		int e=10;
		System.out.println("e = "+e);
		
		e+=20;//e=e+20;
		System.out.println("e = "+e);
		System.out.println("===============================================================");
	}
}
