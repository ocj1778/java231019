package xyz.itwill08.mvc;

import java.util.HashMap;
import java.util.Map;

//클라이언트의 요청정보(Command)로 요청 처리 클래스(Model)의 객체를 제공하기 위한 클래스
public class HandlerMapping {
	//Map 객체를 저장하기 위한 필드
	// => Map 객체에 저장될 엔트리(Entry)의 맵키는 요청정보를 저장하기 위해 String 클래스로 제네릭 
	//설정하고 맵값은 요청 처리 클래스의 객체를 저장하기 위해 Controller 인터페이스로 제네릭 설정
	private Map<String, Controller> mappings;
	
	//생성자를 사용하여 필드에 Map 객체를 생성하여 저장하고 Map 객체에 엔트리 추가하도록 처리
	public HandlerMapping() {
		mappings=new HashMap<String, Controller>();
		mappings.put("/list.itwill", new ListController());
		mappings.put("/view.itwill", new ViewController());
	}
	
	//클라이언트의 요청정보를 전달받아 요청 처리 클래스의 객체를 반환하는 메소드
	public Controller getController(String command) {
		return mappings.get(command);
	}
}
