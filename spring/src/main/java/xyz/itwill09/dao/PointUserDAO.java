package xyz.itwill09.dao;

import xyz.itwill09.dto.PointUser;

public interface PointUserDAO {
	int insertPointUser(PointUser user);
	int updatePlusPointUser(String id);
	int updateMinusPointUser(String id);
	PointUser selectPointUser(String id);
}
