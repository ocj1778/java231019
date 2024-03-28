package xyz.itwill09.dto;

import lombok.Builder;
import lombok.Data;

//DTO 클래스 : DAO 클래스의 메소드에서 값을 전달받거나 반환하기 위한 클래스
// => 테이블의 행을 Java 클래스로 표현하여 객체로 생성하기 위해 작성
@Data
@Builder
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}
