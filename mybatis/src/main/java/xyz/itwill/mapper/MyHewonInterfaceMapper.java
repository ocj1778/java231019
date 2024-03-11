package xyz.itwill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import xyz.itwill.dto.MyHewon;

//mybatis 프레임워크에서는 Interface 기반의 매퍼 파일만을 사용하여 매퍼 등록 가능
// => 인터페이스의 추상메소드에 매퍼 어노테이션을 사용하여 SQL 명령 등록
public interface MyHewonInterfaceMapper {
	//추상메소드의 @Select 어노테이션으로 등록된 SELECT 명령은 기본적으로 검색행을 자동 매핑
	//하여 Java 객체로 제공
	// => 자동 매핑 기능을 사용하기 위해서는 검색행의 컬럼명과 객체 필드의 이름을 반드가 같도록 작성
	// => 검색행의 컬럼명이 객체 필드의 이름과 모두 다른 경우 Java 객체 대신 NULL 제공
	//@Results : 검색행을 Java 객체로 제공하기 위한 매핑 정보를 설정하는 어노테이션
	// => XML 기반의 매퍼 파일에서 resultMap 엘리먼트와 유사한 기능 제공
	//value 속성 : 검색행의 컬럼값이 객체 필드에 저장하기 위한 정보를 다수의 Result 어노테이션이
	//저장된 배열을 속성값으로 설정 - 다른 속성이 없는 경우 속성값만 설정 가능
	@Results(value = {
			//@Result : 검색행의 컬럼값이 객체 필드에 저장하기 위한 정보를 제공하는 어노테이션
			// => XML 기반의 매퍼 파일에서 id 엘리먼트(result 엘리먼트)와 유사한 기능 제공
			//column 속성 : 검색행의 컬럼명을 속성값으로 설정
			//property 속성 : 검색행의 컬럼값이 저장된 객체 필드의 이름을 속성값으로 설정
			@Result(column = "hewon_id", property = "id")				
			, @Result(column = "hewon_name", property = "name")				
			, @Result(column = "hewon_phone", property = "phone")				
			, @Result(column = "hewon_email", property = "email")				
			, @Result(column = "hewon_status", property = "status")				
	})
	@Select("select hewon_id, hewon_name, hewon_phone, hewon_email, hewon_status from myhewon order by hewon_id")
	List<MyHewon> selectHewonList();
}











