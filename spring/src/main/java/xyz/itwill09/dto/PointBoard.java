package xyz.itwill09.dto;

import lombok.Builder;
import lombok.Data;

//create table point_board(idx number primary key, writer varchar2(20), content varchar2(100));
//create sequence point_board_seq;

@Data
@Builder
public class PointBoard {
	private int idx;
	private String writer;
	private String content;
}
