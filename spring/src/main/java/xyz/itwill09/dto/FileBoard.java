package xyz.itwill09.dto;

import lombok.Data;

//create table file_board(idx number primary key, writer varchar2(20)
//	    , subject varchar2(100), filename varchar2(200));
//create sequence file_board_seq;    

//DTO 클래스 : DAO 클래스의 메소드에서 정보(값)을 전달받거나 반환하기 위해 작성한 클래스
// => 페이지 요청시 전달값을 Command 객체로 제공받기 위해 사용
@Data
public class FileBoard {
	private int idx;
	private String writer;
	private String subject;
	//서버 디렉토리에 저장된 업로드 파일명을 저장하기 위한 필드 - 테이블 저장 
	private String filename;
	//사용자로부터 입력되어 전달된 파일정보를 저장하기 위한 필드 - 업로드 처리
	//private MultipartFile multipartFile;
}













