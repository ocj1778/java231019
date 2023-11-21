package xyz.itwill.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//원본파일(c:/data/bandzip.exe)에 저장된 값을 원시데이타로 제공받아 타겟파일(c:/data/bandzip_byte.exe)에
//전달하여 저장하는 프로그램 작성 - 파일 복사 프로그램 
// => 가공되지 않은 원시데이타를 이용하여 입력 또는 출력 처리하여 모든 형식의 원본파일을 복사해
//타겟파일로 전달하여 저장 가능	
public class FileCopyByteApp {
	public static void main(String[] args) throws IOException {
		//원본파일에 저장된 값을 원시데이타로 제공받기 위한 입력스트림 생성
		BufferedInputStream in=null;
		try {
			//BufferedInputStream 클래스 : 대량의 원시데이타를 제공받을 입력스트림을 생성하기 위한 클래스
			// => BufferedInputStream(InputStream in) 생성자로 객체 생성
			// => in 매개변수에 InputStream 객체를 전달받아 저장
			//FileInputStream 클래스로 만들어진 파일 입력스트림을 BufferedInputStream 클래스를
			//사용하여 확장된 파일 입력스트림으로 생성
			in=new BufferedInputStream(new FileInputStream("c:/data/bandzip.exe"));
		} catch (FileNotFoundException e) {
			System.out.println("[에러]원본파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		
		//타겟파일에 원시데이타를 전달하기 위한 출력스트림 생성
		//BufferedOutputStream 클래스 : 대량의 원시데이타를 전달할 출력스트림을 생성하기 위한 클래스
		// => BufferedOutputStream(OutputStream out) 생성자로 객체 생성
		// => out 매개변수에 OutputStream 객체를 전달받아 저장
		//FileOutputStream 클래스로 만들어진 파일 출력스트림을 BufferedOutputStream 클래스를
		//사용하여 확장된 파일 출력스트림으로 생성
		BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("c:/data/bandzip_byte.exe"));
		
		int readByte;
		
		while(true) {
			//원본파일에 저장된 값을 입력스트림을 사용하여 원시데이타를 제공받아 변수에 저장
			readByte=in.read();
			
			//입력스트림으로 제공받을 수 있는 원시데이타가 없는 경우 반복문 종료
			if(readByte == -1) break;
			
			//변수에 저장된 원시데이타를 출력스트림을 사용하여 타겟파일로 전달 
			out.write(readByte);
		}
		
		//파일 입력스트림 또는 파일 출력스트림은 사용 후 반드시 제거
		in.close();
		out.close();
		
		System.out.println("[메세지]파일을 성공적으로 복사 하였습니다.");
	}
}