package xyz.itwill.dto;

//create table userinfo(userid varchar2(100) primary key, password varchar2(100)
//	    , name varchar2(200), email varchar2(300), status number(1));

public class UserinfoDTO {
	private String userid;
	private String password;
	private String name;
	private String email;
	private int status;
	
	public UserinfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
