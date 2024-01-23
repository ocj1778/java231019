package xyz.itwill.dto;

/*
create table member(member_num number primary key, id varchar2(3) unique, passwd varchar2(200)
	    , name varchar2(30), email varchar2(50), mobile varchar2(20), zipcode varchar2(10)
	    , address1 varchar2(200), address2 varchar2(100), join_date date, update_date date
	    , last_login date, member_status number(1));
	    
create sequence member_seq;    
*/

/*
이름            널?       유형            
------------- -------- ------------- 
MEMBER_NUM    NOT NULL NUMBER        
ID                     VARCHAR2(3)   
PASSWD                 VARCHAR2(200) 
NAME                   VARCHAR2(30)  
EMAIL                  VARCHAR2(50)  
MOBILE                 VARCHAR2(20)  
ZIPCODE                VARCHAR2(10)  
ADDRESS1               VARCHAR2(200) 
ADDRESS2               VARCHAR2(100) 
JOIN_DATE              DATE          
UPDATE_DATE            DATE          
LAST_LOGIN             DATE          
MEMBER_STATUS          NUMBER(1)    
*/

public class MemberDTO {

}
