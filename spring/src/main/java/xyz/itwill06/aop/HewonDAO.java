package xyz.itwill06.aop;

import java.util.List;

public interface HewonDAO {
	int insertHewon(Hewon hewon);
	Hewon selectHewon(int num);
	List<Hewon> selectHewonList();
}
