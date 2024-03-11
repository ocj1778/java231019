package xyz.itwill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import xyz.itwill.dto.MyHewon;

//mybatis 프레임워크에서는 Interface 기반의 매퍼 파일만을 사용하여 매퍼 등록 가능
// => 인터페이스의 추상메소드에 매퍼 어노테이션을 사용하여 SQL 명령 등록
public interface MyHewonInterfaceMapper {
	@Select("select hewon_id, hewon_name, hewon_phone, hewon_email, hewon_status from myhewon order by hewon_id")
	List<MyHewon> selectHewonList();
}
