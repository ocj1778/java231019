package xyz.itwill09.dto;

import lombok.Data;

//create table rest_board(idx number primary key, writer varchar2(50), content varchar2(100), regdate date);
//create sequence rest_board_seq;    

@Data
public class RestBoard {
	private int idx;
	private String writer;
	private String content;
	private String regdate;
}
