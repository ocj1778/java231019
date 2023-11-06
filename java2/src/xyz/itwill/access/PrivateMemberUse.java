package xyz.itwill.access;

public class PrivateMemberUse {
	public void run() {
		@SuppressWarnings("unused")
		PrivateMember member=new PrivateMember();
		
		/*
		member.number=100;
		member.display();
		*/
	}
}
