package xyz.itwill.mapper;

import java.util.List;
import java.util.Map;

import xyz.itwill.dto.MyHewon;

public interface MyHewonMapper {
	int insertHewon(MyHewon hewon);
	List<MyHewon> selectHewonList();
	List<MyHewon> selectDiscriminatorHewonList();
	List<MyHewon> selectStatusHewonList(int status);
	String selectDtoHewonId(MyHewon hewon);
	//HashMap 클래스(Map 인터페이스)를 매개변수로 작성할 경우 제네릭 설정은 맵키를 String
	//클래스로 설정하고 맵값은 Object 클래스로 설정하여 사용
	String selectMapHewonId(Map<String, Object> map);
	int insertMapHewon(Map<String, Object> map);
}
