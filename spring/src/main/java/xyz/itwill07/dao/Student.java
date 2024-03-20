package xyz.itwill07.dao;

import lombok.Builder;
import lombok.Data;

/*
이름       널?       유형            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(50)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE    
*/

//STUDENT 테이블의 행(학생정보)을 저장하여 전달하기 위한 클래스 - DTO 클래스
@Data
@Builder
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}
