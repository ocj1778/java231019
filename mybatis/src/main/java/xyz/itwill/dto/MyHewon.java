package xyz.itwill.dto;

/*
MYHEWON : 회원정보를 저장하기 위한 테이블
create table myhewon(hewon_id varchar2(50) primary key, hewon_name varchar2(50)
    , hewon_phone varchar2(20), hewon_email varchar2(100), hewon_status number(1));
    
이름           널?       유형            
------------ -------- ------------- 
HEWON_ID     NOT NULL VARCHAR2(50)  - 아이디 
HEWON_NAME            VARCHAR2(50)  - 이름
HEWON_PHONE           VARCHAR2(20)  - 전화번호
HEWON_EMAIL           VARCHAR2(100) - 이메일
HEWON_STATUS          NUMBER(1)     - 공개범위

공개범위 : 1(아이디), 2(아이디&이름), 3(아이디&이름&전화번호), 4(아이디&이름&전화번호&이메일)
*/

public class MyHewon {
	private String id;
	private String name;
	private String phone;
	private String email;
	private int status;
	
	public MyHewon() {
		// TODO Auto-generated constructor stub
	}

	public MyHewon(String id, String name, String phone, String email, int status) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.status = status;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
