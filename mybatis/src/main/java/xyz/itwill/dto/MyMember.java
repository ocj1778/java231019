package xyz.itwill.dto;

//create table mymember(id varchar2(50) primary key, name varchar2(50)
//	    , phone varchar2(20), email varchar2(100));

//테이블 생성 >> DTO 클래스 작성 >> mybatis 환경설정파일에 별칭 및 맵퍼 등록 - 생략 가능 
// >> 매퍼 파일 작성 >> DAO 클래스 작성

public class MyMember {
	private String id;
	private String name;
	private String phone;
	private String email;
	
	public MyMember() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
