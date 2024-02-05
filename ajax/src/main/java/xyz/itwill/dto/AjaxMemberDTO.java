package xyz.itwill.dto;

//create table ajax_member(id varchar2(30) primary key, passwd varchar2(100)
//	    , name varchar2(50), email varchar2(100));

public class AjaxMemberDTO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	public AjaxMemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
