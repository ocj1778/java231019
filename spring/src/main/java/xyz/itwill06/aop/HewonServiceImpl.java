package xyz.itwill06.aop;

import java.util.List;

import lombok.Setter;

//핵심관심모듈
public class HewonServiceImpl implements HewonService {
	@Setter
	private HewonDAO hewonDAO;
	
	@Override
	public void addHewon(Hewon Hewon) {
		System.out.println("*** HewonServiceImpl 클래스의 addHewon(Hewon Hewon) 메소드 호출 ***");
		hewonDAO.insertHewon(Hewon);
	}

	@Override
	public Hewon getHewon(int num) {
		System.out.println("*** HewonServiceImpl 클래스의 getHewon(int num) 메소드 호출 ***");
		return hewonDAO.selectHewon(num);
	}

	@Override
	public List<Hewon> getHewonList() {
		System.out.println("*** HewonServiceImpl 클래스의 getHewonList() 메소드 호출 ***");
		return hewonDAO.selectHewonList();
	}

}
