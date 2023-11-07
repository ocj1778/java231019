package xyz.itwill.realization;

public class JdbcApp {
	public static void main(String[] args) {
		/*
		JdbcMysql mysql=new JdbcMysql();
		
		mysql.insert();
		mysql.update();
		mysql.delete();
		mysql.select();
		*/
		
		/*
		//시스템 변경에 의해 기존 클래스를 새로운 클래스로 변경할 경우 새로운 클래스로 객체를
		//생성하여 새로운 클래스의 메소드 호출
		// => 기존 클래스와 관계를 맺고 있는 클래스도 새로운 클래스를 사용하기 위해 명령을 재작성 
		// => 객체간의 결합도가 높아 유지보수의 효율성 감소
		JdbcOracle oracle=new JdbcOracle();
		
		oracle.add();
		oracle.modify();
		oracle.remove();
		oracle.search();
		*/
		
		//객체간의 결합도를 낮추기 위해 참조변수는 인터페이스를 이용하여 생성
		//Jdbc jdbc=new JdbcMysql();
		
		//시스템 변경에 의해 기존 클래스를 새로운 클래스로 변경할 경우 새로운 클래스로 객체를
		//생성하여 새로운 클래스의 메소드 호출
		// => 기존 클래스와 관계를 맺고 있는 클래스를 거의 변경하지 않고 새로운 클래스 사용 가능 
		// => 인터페이스를 사용하여 객체의 결합도를 낮춰 유지보수의 효율성 증가
		Jdbc jdbc=new JdbcOracle();
		
		//참조변수로 인터페이스의 추상메소드를 호출하면 묵시적 객체 형변환에 의해 자식객체를
		//참조하여 자식클래스의 메소드 호출
		jdbc.insert();
		jdbc.update();
		jdbc.delete();
		jdbc.select();
	}
}
