package xyz.itwill.mapper;

import org.apache.ibatis.jdbc.SQL;

//Provider 클래스(SQL Builder 클래스) : SQL 명령을 반환하는 메소드가 작성된 클래스
public class MyHewonProvider {
	//SQL 객체의 메소드를 호출하여 SQL 명령을 작성하여 반환하는 메소드
	// => Java 명령을 사용하여 동적 SQL 기능 구현 가능
	public String selectDynamicName(String name) {
		//SQL 객체 : SQL 명령 작성에 필요한 메소드를 호출하여 SQL 명령을 생성해 저장하기 위한 객체
		//SQL.toString() : SQL 객체에 저장된 SQL 명령을 문자열로 반환하는 메소드
		return new SQL() {{
			SELECT("hewon_id, hewon_name, hewon_phone");
			SELECT("hewon_email, hewon_status");
			FROM("myhewon");
			if(name != null && !name.equals("")) {
				WHERE("hewon_name=#{name}");
			}
			ORDER_BY("hewon_id");
		}}.toString();
	}
}
