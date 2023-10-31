package oop;

//static : 객체가 아닌 클래스로 클래스 내부에 작성된 필드 또는 메소드에 접근하기 위한 기능을
//제공하는 키워드(제한자)
// => 클래스(내부클래스), 필드, 메소드 작성시 사용 가능한 제한자
//제한자(Modifier) : 특별한 기능(제한)을 제공하기 위한 키워드
// => Access Modifier(private, package, protected, public), static, final, abstract

//학생정보(학번,이름,국어,영어,총점)를 저장하기 위한 클래스 - VO 클래스
public class Student {
	//인스턴스 필드(Instance Field) : 객체가 생성될 때 메모리(HeapArea)에 만들어지는 필드
	// => 생성자를 이용하여 인스턴스 필드에 필요한 초기값 저장
	private int num;
	private String name;
	private int kor, eng, tot;
	
	//정적 필드(Static Field) : 클래스를 읽어 메모리(MethodArea)에 저장될 때 만들어지는 필드
	// => 객체가 생성되기 전에 메모리에 하나만 만들어지는 필드
	// => 정적 필드에는 기본값이 저장되며 필요한 경우 정적필드 작성시 직접 초기값 저장
	// => 클래스로 생성된 모든 객체가 정적 필드 사용 가능 - 모든 객체가 메모리를 공유하여 사용
	// => 정적 필드를 작성하면 메모리를 절약할 수 있고 필드값 변경 용이
	// => 클래스 외부에서는 객체가 아닌 클래스를 이용하여 필드 사용
	//public static int total=0;
	private static int total=0;
	
	//생성자(Constructor)
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name, int kor, int eng) {
		super();
		//매개변수로 전달받은 값으로 필드 초기화
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
		//매개변수로 전달받은 값을 계산하여 필드 초기화 - 총점을 계산하는 메소드 호출 가능
		// => 코드(명령)의 중복성을 최소화하여 프로그램의 생산성 및 유지보수의 효율성 증가
		//tot=kor+eng;
		calcTot();
	}

	//인스턴스 메소드(Instance Method) : 객체를 사용하여 메소드 호출
	// => 인스턴스 메소드는 this 키워드를 제공받아 객체의 필드 또는 메소드 사용 가능
	// => 인스턴스 메소드는 인스턴스 필드 및 인스턴스 메소드뿐만 아니라 정적 필드와 정적
	//메소드 사용 가능
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}
	
	//국어점수와 영어점수를 이용하여 총점을 계산하여 저장하는 메소드
	public void calcTot() {
		tot=kor+eng;
	}
	
	public void display() {
		System.out.print("["+name+"("+num+")]님의 성적 >> ");
		System.out.println("국어 = "+kor+", 영어 = "+eng+", 총점 = "+tot);
	}

	//정적 메소드(Static Method) : 클래스를 사용하여 메소드 호출
	// => 정적 메소드에 this 키워드를 제공받지 않으므로 객체의 필드 또는 메소드 사용 불가능
	// => 정적 메소드에서는 정적 필드과 정적 메소드만 사용 가능
	// => 정적 메소드에서 인스턴스 필드 및 인스턴스 메소드를 사용할 경우 에러 발생
	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		Student.total = total;
	}
}










