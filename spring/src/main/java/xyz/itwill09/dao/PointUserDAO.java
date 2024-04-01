package xyz.itwill09.dao;

import java.util.List;

import xyz.itwill09.dto.PointUser;

public interface PointUserDAO {
	int insertPointUser(PointUser user);
	int updatePlusPointUser(String id);
	int updateMinusPointUser(String id);
	List<PointUser> selectPointUser(String id);
}
