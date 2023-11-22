package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//회원정보(Member 객체)를 파일에 전달하여 저장하는 프로그램 작성
public class MemberSaveApp {
	public static void main(String[] args) throws IOException {
		//파일에 원시데이타를 전달할 수 있는 출력스트림을 생성하여 객체를 전달할 수 있는
		//출력스트림으로 확장
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("c:/data/member.txt"));
		
		//확장된 출력스트림으로 Member 객체를 전달하여 파일에 저장
		// => writeObject() 메소드 호출시 NotSerializableException 발생
		//NotSerializableException : 객체 직렬화 처리되지 않은 클래스로 생성된 객체를 출력
		//스트림으로 전달할 경우 발생되는 예외
		// => 출력스트림으로 전달되는 객체를 생성하는 클래스를 객체 직렬화 처리하면 예외 미발생
		out.writeObject(new Member("abc123", "홍길동", "abc@itwill.xyz"));
		out.writeObject(new Member("opq456", "임꺽정", "opq@itwill.xyz"));
		out.writeObject(new Member("xyz789", "전우치", "xyz@itwill.xyz"));
		
		out.close();
		
		System.out.println("c:\\data\\member.txt 파일을 확인해 보세요.");
	}
}
