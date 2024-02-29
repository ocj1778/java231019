package xyz.itwill.dto;

/*
이름       널?       유형            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(50)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE     
*/

//테이블의 컬럼명과 같은 이름으로 필드명을 작성하여 클래스를 선언하는 것을 권장
// => mybatis 프레임워크의 SqlSession 객체는 검색행의 컬럼값을 같은 이름의 필드에 자동 저장
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
