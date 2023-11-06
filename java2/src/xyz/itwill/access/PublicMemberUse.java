package xyz.itwill.access;

public class PublicMemberUse {
	public void run() {
		PublicMember member=new PublicMember();
		
		member.number=100;
		member.display();
	}
}
