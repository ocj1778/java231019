package xyz.itwill09.dto;

import lombok.Data;

//회원정보를 저장하기 위한 클래스 - VO 클래스 >> DTO 클래스
// => DAO 클래스에서 정보를 전달할 목적으로 작성된 클래스
// => 페이지 요청시 전달값을 저장할 목적으로 사용 - 전달값의 이름과 필드의 이름이 같도록 작성
@Data
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
}
