package xyz.itwill.bean;

//JavaBean : 컨테이너에 의해 생성되는 Java 객체
// => useBean 태그에 의해 WAS 프로그램이 생성하는 객체로 전달값을 객체 필드에 저장 가능
// => 전달값을 객체 필드에 저장하기 위해서는 전달값의 이름과 같은 이름으로 필드 선언

//전달값을 이용하여 회원정보를 저장하기 위한 클래스 - JavaBean >> DTO 객체
public class HewonBean {
	private String name;
	private String phone;
	private String address;
	
	public HewonBean() {
		// TODO Auto-generated constructor stub
	}

	public HewonBean(String name, String phone, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
