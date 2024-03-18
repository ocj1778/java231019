package xyz.itwill06.aop;

import java.util.List;

//핵심관심모듈(Core Concern Module) : 핵심관심코드의 메소드가 작성된 클래스 
public class HewonDAOImpl implements HewonDAO {
	@Override
	public int insertHewon(Hewon hewon) {
		System.out.println("*** HewonDAOImpl 클래스의 insertHewon(Hewon hewon) 메소드 호출 ***");
		return 0;
	}

	@Override
	public Hewon selectHewon(int num) {
		System.out.println("*** HewonDAOImpl 클래스의 selectHewon(int num) 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Hewon> selectHewonList() {
		System.out.println("*** HewonDAOImpl 클래스의 selectHewonList() 메소드 호출 ***");
		return null;
	}
}
