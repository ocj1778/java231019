package xyz.itwill.dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Properties 파일 : 프로그램 실행에 필요한 값을 제공하기 위한 텍스트 파일 
// => 파일의 확장자를 [properties]로 저장하며 [이름 = 값] 패턴의 문자열을 저장
// => Properties 파일에는 영문자,숫자,일부 특수문자를 제외한 나머지 문자는 유니코드로 변환되어 저장
// => Properties 파일에 저장된 값은 이름으로 구분하여 값을 제공받으며 문자열로 제공
// => 프로그램에서 자주 변경되는 값을 Properties 파일에 저장하여 사용하면 프로그램의 유지보수 효율성 증가

//[user.properties] 파일에 저장된 값을 얻어와 출력하는 프로그램 작성
public class PropertiesApp {
	public PropertiesApp() throws IOException {
		//Properties 파일을 읽기 위한 입력스트림 생성
		// => Properties 파일의 경로를 제공받아 FileInputStream 클래스로 입력스트림 생성
		// => 프로그램 배포시 파일 경로에 문제 발생 
		//FileInputStream in=new FileInputStream("src/xyz/itwill/dbcp/user.properties");
		
		//Object.getClass() : 현재 동작중인 클래스에 대한 Class 객체(Clazz)를 반환하는 메소드
		//Class 객체 : 메모리에 저장된 클래스에 대한 정보를 저장한 객체
		//Class.getClassLoader() : 클래스(Java Class 파일)를 읽어 메모리에 저장한 ClassLoader 객체를 반환하는 메소드
		//ClassLoader.getResourceAsStream(String name) : 매개변수로 프로젝트에 존재하는 패키지의 
		//파일 경로를 제공받아 입력스트림을 생성하여 반환하는 메소드
		InputStream in=getClass().getClassLoader().getResourceAsStream("xyz/itwill/dbcp/user.properties");
		
		//Properties 클래스로 객체 생성
		// => Properties 클래스는 Map 인터페이스를 상속받은 콜렉션 클래스
		// => Properties 객체에는 다수의 엔트리(Entry)를 저장하여 사용
		// => Properties 파일로 제공되는 [이름 = 값] 패턴의 문자열을 Properties 객체의 엔트리에 추가하여 저장
		Properties properties=new Properties();
		
		//Properties.load(InputStream in) : 매개변수로 Properties 파일을 읽기 위한 입력스트림을
		//제공받아 Properties 파일의 [이름 = 값]의 문자열로 Properties 객체의 엔트리로 추가하는 메소드
		properties.load(in);
		
		//Properties.get(String key) : Properties 객체에 저장된 엔트리 중에서 매개변수로 
		//전달받은 맵키(Key)의 맵값(객체)를 반환하는 메소드
		// => 맵값은 Object 객체로 반환하므로 반드시 명시적 객체 형변환해야만 사용 가능
		// => Properties 객체에 저장된 엔트리의 맵값은 무조건 String 객체로만 변환하여 사용
		String id=(String)properties.get("id");
		String password=(String)properties.get("password");
		String name=(String)properties.get("name");
		
		System.out.println("아이디 = "+id);
		System.out.println("비밀번호 = "+password);
		System.out.println("이름 = "+name);
	}
	
	public static void main(String[] args) throws IOException {
		new PropertiesApp();
	}
}
