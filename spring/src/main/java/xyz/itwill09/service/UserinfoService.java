package xyz.itwill09.service;

import java.util.List;

import xyz.itwill09.dto.Userinfo;

public interface UserinfoService {
	void addUserinfo(Userinfo userinfo);
	void modifyUserinfo(Userinfo userinfo);
	void removeUserinfo(String userid);
	Userinfo getUserinfo(String userid);
	List<Userinfo> getUserinfoList();
	Userinfo loginAuth(Userinfo userinfo);
}
