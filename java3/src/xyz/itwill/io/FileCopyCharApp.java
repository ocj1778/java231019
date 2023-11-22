package xyz.itwill.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//원본파일(c:/data/bandzip.exe)에 저장된 값을 문자데이타로 제공받아 타겟파일(c:/data/bandzip_char.exe)에
//전달하여 저장하는 프로그램 작성 - 파일 복사 프로그램
// => 문자데이타만 저장된 원본파일(문서파일 - Text File)을 복사하여 타겟파일로 전달하여 저장 가능
// => 텍스트 파일을 제외한 원본파일(이진파일 - Binary File)은 파일에 저장된 값을 인코딩 처리한 
//문자데이타로 읽어 타겟파일에 전달하므로 변형된 값으로 파일 저장 - 원본파일과 다른 파일로 복사
public class FileCopyCharApp {
	public static void main(String[] args) throws IOException {
		//원본파일에 저장된 값을 문자데이타로 제공받기 위한 입력스트림 생성
		BufferedReader in=null;
		try {
			//BufferedReader 클래스 : 대량의 문자데이타를 제공받을 입력스트림을 생성하기 위한 클래스
			// => BufferedReader(Reader in) 생성자로 객체 생성
			// => in 매개변수에 Reader 객체를 전달받아 저장
			//FileReader 클래스로 만들어진 파일 입력스트림을 BufferedReader 클래스를 사용하여
			//확장된 파일 입력스트림으로 생성
			in=new BufferedReader(new FileReader("c:/data/bandzip.exe"));
		} catch (FileNotFoundException e) {
			System.out.println("[에러]원본파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		
		//타겟파일에 문자데이타를 전달하기 위한 출력스트림 생성
		//BufferedWriter 클래스 : 대량의 문자데이타를 전달할 출력스트림을 생성하기 위한 클래스
		// => BufferedWriter(Writer out) 생성자로 객체 생성
		// => out 매개변수에 Writer 객체를 전달받아 저장
		//FileWriter 클래스로 만들어진 파일 출력스트림을 BufferedWriter 클래스를 사용하여 
		//확장된 파일 출력스트림으로 생성
		BufferedWriter out=new BufferedWriter(new FileWriter("c:/data/bandzip_char.exe"));
		
		int readByte;
		
		while(true) {
			//원본파일에 저장된 값을 입력스트림을 사용하여 문자데이타를 제공받아 변수에 저장
			readByte=in.read();
			
			//입력스트림으로 제공받을 수 있는 문자데이타가 없는 경우 반복문 종료
			if(readByte == -1) break;
			
			//변수에 저장된 문자데이타를 출력스트림을 사용하여 타겟파일로 전달 
			out.write(readByte);
		}
		
		//파일 입력스트림 또는 파일 출력스트림은 사용 후 반드시 제거
		in.close();
		out.close();
		
		System.out.println("[메세지]파일을 성공적으로 복사 하였습니다.");
	}
}



