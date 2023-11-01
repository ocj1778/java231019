package inheritance;

public class MemberEventApp {
	public static void main(String[] args) {
		MemberEvent member1=new MemberEvent();
		
		member1.setId("abc123");
		member1.setName("홍길동");
		member1.setEmail("abc@itwill.xyz");
		
		member1.display();
		System.out.println("==============================================================");
		MemberEvent member2=new MemberEvent("xyz789", "임꺽정", "xyz@itwill.xyz");
		member2.display();
		System.out.println("==============================================================");
	}
}
