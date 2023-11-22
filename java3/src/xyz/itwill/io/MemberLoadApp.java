package xyz.itwill.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//파일에 저장된 모든 회원정보(Member 객체)를 제공받아 출력하는 프로그램 작성
public class MemberLoadApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//파일에 저장된 원시데이타를 제공할 수 있는 입력스트림을 생성하여 객체를 제공받을 수
		//있는 입력스트림으로 확장		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("c:/data/member.txt"));
		
		System.out.println("<<회원목록>>");
		while(true) {
			try {
				//ObjectInputStream.readObject() 메소드를 호출하여 파일에 저장된 Member 객체를
				//제공받아 저장
				// => readObject() 메소드를 호출시 더이상 제공받은 객체가 없는 경우 EOFException 발생
				// => EOFException : EOF(End Of File)를 읽어들인 경우 발생되는 예외
				Member member=(Member)in.readObject();
				System.out.println(member);//Member 클래스의 toString() 메소드 자동 호출
			} catch (EOFException e) {
				break;
			}
		}
		
		in.close();
	}
}











