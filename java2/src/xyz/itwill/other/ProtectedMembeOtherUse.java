package xyz.itwill.other;

import xyz.itwill.access.ProtectedMember;

public class ProtectedMembeOtherUse {
	public void run() {
		@SuppressWarnings("unused")
		ProtectedMember member=new ProtectedMember();
		
		/*
		member.number=100;
		member.display();
		*/
	}
}

		