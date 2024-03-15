package xyz.itwill05.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private Set<String> nameSet;
	private List<String> nameList;
	//콜렉션 클래스의 제네릭을 인터페이스로 설정하면 콜렉션 객체에는 인터페이스를 상속받은
	//모든 자식클래스의 객체를 요소로 추가하여 저장 가능
	private Set<Controller> controllerSet;
	private List<Controller> controllerList;
	private Map<String, Controller> controllerMap;
	private Properties controllerProperties;
	
	public CollectionBean() {
		System.out.println("### CollectionBean 클래스의 기본 생성자 호출 ###");
	}

	public Set<String> getNameSet() {
		return nameSet;
	}

	public void setNameSet(Set<String> nameSet) {
		this.nameSet = nameSet;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public Set<Controller> getControllerSet() {
		return controllerSet;
	}

	public void setControllerSet(Set<Controller> controllerSet) {
		this.controllerSet = controllerSet;
	}

	public List<Controller> getControllerList() {
		return controllerList;
	}

	public void setControllerList(List<Controller> controllerList) {
		this.controllerList = controllerList;
	}

	public Map<String, Controller> getControllerMap() {
		return controllerMap;
	}

	public void setControllerMap(Map<String, Controller> controllerMap) {
		this.controllerMap = controllerMap;
	}

	public Properties getControllerProperties() {
		return controllerProperties;
	}

	public void setControllerProperties(Properties controllerProperties) {
		this.controllerProperties = controllerProperties;
	}
}
