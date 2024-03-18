package xyz.itwill05.lombok;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberServiceApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container 초기화 전 ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-5_lombok.xml");
		System.out.println("=============== Spring Container 초기화 후 ===============");
		MemberService service=context.getBean("memberService", MemberService.class);
		service.addMember(null);
		service.modifyMember(null);
		service.removeMember(null);
		service.getMember(null);
		service.getMemberList();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();		
		
	}
}
