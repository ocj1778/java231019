package xyz.itwill.util;

import java.util.Objects;

//VO 클래스(Value Object) : 객체를 하나의 값으로 표현하기 위한 클래스
// => 데이타 불변 : VO 클래스의 모든 필드값은 변경하지 못하도록 처리 - final 제한자 사용해 필드 선언
// => final 제한자로 선언된 필드는 Setter 메소드를 사용하여 필드값을 변경할 수 없으므로 Getter 메소드만 작성
// => final 제한자로 선언된 필드에는 매개변수가 작성된 생성자를 이용하여 초기화 처리 - 기본 생성자 미작성
// => 객체를 하나의 값처럼 비교하기 위해 Object 클래스의 equals() 메소드와 hashCode() 메소드를 반드시 오버라이드 선언
// => 객체에 저장된 필드값을 검증하기 위해 사용하는 클래스 

//사용자정보(아이디, 이름, 이메일)를 저장하기 위한 클래스
// => Set 객체에 동일한 사용자정보(UserVO 객체)가 저장되는 것을 방지를 위해 VO 클래스로 선언
public class UserVO {
	private final String id;
	private final String name;
	private final String email;
	
	public UserVO(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	//메소드를 호출한 객체와 매개변수로 전달받은 객체의 필드값을 비교하여 결과를 반환하는 메소드
	// => 객체의 필드값을 비교하여 다르면 [false]를 반환하고 같으면 [true]를 반환하는 메소드
 	@Override
	public boolean equals(Object obj) {
		//매개변수로 전달받은 객체를 명시적 객체 형변환하여 참조변수에 저장
		UserVO userVO=(UserVO)obj;
		
		//Objects 클래스 : 객체를 비교하거나 [null] 검사를 하기 위한 기능을 메소드로 제공하는 클래스
		//Objects.equals(Object value1, Object value2) : 매개변수로 전달받은 값을 비교하여
		//결과를 논리값으로 반환하는 메소드 - NullPointerException 방지
		return Objects.equals(this.id, userVO.id);//사용자정보의 아이디를 비교하여 결과 반환
	}
	
	//객체의 필드값을 해싱기법을 사용해 정수값(int)으로 변환하여 반환하는 메소드 - 메모리 주소 비교
	@Override
	public int hashCode() {
		//Objects.hashCode(Object o) : 객체의 메모리 주소를 정수값으로 변환하여 반환하는 메소드
		return Objects.hashCode(id);
	}
	
	//필드값을 반환하는 메소드
	@Override
	public String toString() {
		return "{"+id+", "+name+", "+email+"}";
	}

}
