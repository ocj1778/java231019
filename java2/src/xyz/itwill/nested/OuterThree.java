package xyz.itwill.nested;

public class OuterThree {
	private int outerNum;
	
	public OuterThree() {
		// TODO Auto-generated constructor stub
	}

	public OuterThree(int outerNum) {
		super();
		this.outerNum = outerNum;
	}

	public int getOuterNum() {
		return outerNum;
	}

	public void setOuterNum(int outerNum) {
		this.outerNum = outerNum;
	}
	
	public void outerDisplay() {
		System.out.println("outerNum = "+outerNum);
		
		//InnerThree innerThree=new InnerThree();
	}
	
	public void local() {
		//지역 내부클래스(Local InnerClass) : 외부클래스의 메소드에 선언된 내부클래스
		// => 메소드 호출시 메모리에 저장되며 메소드가 종료되면 자동 소멸
		// => 지역 내부클래스는 선언된 메소드에서만 사용이 가능한 내부클래스
		// => 접근제한자 및 static 제한자를 사용하여 지역 내부클래스를 작성할 경우 에러 발생
		// => abstract 또는 final 제한자를 사용하여 지역 내부클래스 작성 가능
		// => 비동기식 처리를 위한 스레드 객체를 생성하여 사용하기 위해 작성
		class InnerThree {
			//지역 내부클래스에는 사용하지 않는 필드, 생성자, 메소드를 작성하는 것을 비권장
			int innerNum;
			
			void innerDisplay() {
				System.out.println("innerNum = "+innerNum);
			}
		}
		 
		//지역 내부클래스는 선언된 메소드에서만 객체를 생성하여 필드 또는 메소드를 참조해 사용 가능
		InnerThree innerThree=new InnerThree();
		innerThree.innerNum=200;
		innerThree.innerDisplay();
	}
}