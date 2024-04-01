package xyz.itwill09.dto;

import lombok.Data;

/*
이름       널?       유형            
-------- -------- ------------- 
USERID   NOT NULL VARCHAR2(100) 
PASSWORD          VARCHAR2(100) 
NAME              VARCHAR2(200) 
EMAIL             VARCHAR2(300) 
STATUS            NUMBER(1)     
*/

@Data
public class Userinfo {
	private String userid;
	private String password;
	private String name;
	private String email;
	private int status;
	
}
