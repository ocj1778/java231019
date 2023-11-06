package xyz.itwill.other;

import xyz.itwill.access.PackageMember;

public class PackageMemberOtherUse {
	public void run() {
		@SuppressWarnings("unused")
		PackageMember member=new PackageMember();
		
		/*
		member.number=100;
		member.display();
		*/
	}
}
