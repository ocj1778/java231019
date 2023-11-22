package xyz.itwill.io;

import java.io.File;
import java.io.IOException;

public class FileApp {
	public static void main(String[] args) throws IOException {
		//File 클래스 : 파일(디렉토리 - 폴더) 관련 정보를 저장하기 위한 클래스
		// => File(String pathname) 생성자를 사용하여 File 객체 생성
		// => pathname 매개변수에는 플렛폼에 존재하는 파일의 경로를 전달하여 저장
		
		//파일경로 : 플렛폼에 존재하는 파일의 위치를 표현하는 방법
		// => 절대경로 표현방법, 상대경로 표현방법
		
		//절대경로 표현방법 : 최상위 디렉토리(Root Directory)를 기준으로 파일의 위치를 표현하는 방법
		//상대경로 표현방법 : 현재 실행 프로그램의 작업 디렉토리를 기준으로 파일의 위치를 표현
		//하는 방법 - 이클립스에서는 프로그램이 작성된 프로젝트 폴더를 작업 디렉토리로 사용
		//Windows 운영체제에서는 폴더(드라이브)와 파일을 구분하기 위해 \ 문자 사용
		// => Java 프로그램에서는 \ 기호가 회피문자(Escape Character)를 표현하기 위해 사용
		// => 폴더와 파일을 구분하는 \ 기호를 문자로 사용하기 위해 \\ 형태의 회피문자로 표현하여 사용
		
		//절대경로 표현방법을 사용하여 파일 경로를 표현해 File 객체 생성
		File fileOne=new File("c:\\data");
		
		//File.exists() : File 객체에 저장된 정보(파일경로)의 파일(디렉토리)이 플렛폼에 없는 
		//경우 [false]를 반환하고 있는 경우 [true]를 반환하는 메소드
		if(fileOne.exists()) {
			System.out.println("c:\\data 폴더가 이미 존재합니다.");
		} else {
			//File.mkdir() : File 객체에 저장된 정보(파일경로)로 디렉토리(폴더)를 생성하는 메소드
			fileOne.mkdir();
			System.out.println("c:\\data 폴더를 생성 하였습니다.");
		}
		System.out.println("===============================================================");
		//File fileTwo=new File("c:\\data\\itwill.txt");
		
		//Windows 운영체제를 제외한 나머지 운영체제에서는 폴더와 파일을 구분하기 위해 / 문자 사용
		// => Windows 운영체제를 사용해도 Java 프로그램에서는 \ 문자 대신 / 문자 사용 가능 
		File fileTwo=new File("c:/data/itwill.txt");
		
		if(fileTwo.exists()) {
			System.out.println("c:\\data\\itwill.txt 파일이 이미 존재합니다.");
		} else {
			//File.createNewFile() : File 객체에 저장된 정보(파일경로)로 파일을 생성하는 메소드
			// => IOException 발생 - 예외 처리 또는 예외 전달
			fileTwo.createNewFile();
			System.out.println("c:\\data\\itwill.txt 파일을 생성 하였습니다.");
		}
		System.out.println("===============================================================");
		//File(String parent, String child) 생성자를 사용하여 File 객체 생성
		// => parent 매개변수에는 파일이 위치한 디렉토리의 경로를 전달하고 child 매개변수에는
		//파일의 이름을 전달하여 저장
		File fileThree=new File("c:/data","itwill.txt");
		
		if(fileThree.exists()) {
			//File.delete() : File 객체에 저장된 정보(파일경로)로 파일을 삭제하는 메소드
			fileThree.delete();
			System.out.println("c:\\data\\itwill.txt 파일을 삭제 하였습니다.");
		} else {
			System.out.println("c:\\data\\itwill.txt 파일이 존재하지 않습니다.");
		}
		System.out.println("===============================================================");
		//매개변수에 파일경로를 상대경로 표현방법으로 전달하여 File 객체 생성
		// => 현재 실행 프로그램의 작업 디렉토리(프로젝트 폴더)를 기준으로 파일 경로 표현
		// => 상대경로 표현방법은 [..] 기호를 사용하여 상위 디렉토리를 표현하며 [파일 or 디렉토리]
		//형식으로 디렉토리에 존재하는 파일 또는 하위 디렉토리 표현
		File fileFour=new File("src");
		
		if(fileFour.exists()) {
			//File.toString() : File 객체에 저장된 정보(파일경로)를 문자열로 변환하여 반환하는 메소드
			//System.out.println("File 객체에 저장된 파일경로 = "+fileFour.toString());
			System.out.println("File 객체에 저장된 파일경로 = "+fileFour);//toString() 메소드 자동 호출
			
			//File.getAbsolutePath() : File 객체에 저장된 정보(파일경로)를 절대경로의 문자열로
			//변환하여 반환하는 메소드
			System.out.println("File 객체에 저장된 파일경로 = "+fileFour.getAbsolutePath());
		} else {
			System.out.println("작업폴더에 [src] 폴더가 없습니다.");
		}
		System.out.println("===============================================================");
		File fileFive=new File("c:/");
		
		//File.isDirectory() : File 객체에 저장된 정보(파일경로)가 디렉토리가 아닌 경우 [false]를
		//반환하고 디렉토리인 경우 [true]를 반환하는 메소드
		if(fileFive.isDirectory()) {
			//File.listFiles() : File 객체에 저장된 정보(파일경로)가 디렉토리인 경우 하위에 
			//존재하는 모든 파일(디렉토리)의 경로가 저장된 File 객체 배열을 반환하는 메소드 
			File[] subFiles=fileFive.listFiles();
			
			System.out.println(fileFive+"의 자식 파일(디렉토리) 목록 >>");
			for(File file : subFiles) {
				//File.isFile() : File 객체에 저장된 정보(파일경로)의 파일이 아닌 경우 [false]를 
				//반환하고 파일인 경우 [true]를 반환하는 메소드				
				if(file.isFile()) {
					System.out.println("파일 = "+file);
				} else {
					System.out.println("폴더 = "+file);
				}
			}
		}
		System.out.println("===============================================================");
	}
}
