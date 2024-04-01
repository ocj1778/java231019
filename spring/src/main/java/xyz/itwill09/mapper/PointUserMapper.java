package xyz.itwill09.mapper;

import xyz.itwill09.dto.PointUser;

public interface PointUserMapper {
	int insertPointUser(PointUser user);
	int updatePlusPointUser(String id);
	int updateMinusPointUser(String id);
	PointUser selectPointUser(String id);
}
