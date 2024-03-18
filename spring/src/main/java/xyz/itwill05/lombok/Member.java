package xyz.itwill05.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//클래스 작성에 필요한 메소드를 자동으로 생성해주는 Lombok 라이브러리를 사용하는 방법
//1.Lombok 라이브러리를 프로젝트 빌드 처리 - 메이븐 사용 : pom.xml
//2.이클립스(STS)를 종료하고 콘솔(cmd)를 관리자 권한으로 실행한 후 Lombok 라이브러리 파일이
//저장된 로컬 저장소(Local Repository - 사용자 폴더의 .m2 폴더)의 폴더로 이동
//3.콘솔에서 Jar 프로그램을 실행하여 Lombok 라이브러리를 이클립스에서 사용할 수 있도록 설정
// => Jar 프로그램 실행 방법 : java -jar lombok=1.18.30.jar
// => 탐색기에서 로컬 저정소의 폴더로 이동하여 Lombok 라이브러리 파일(Jar)을 더블클릭하여 실행 기능
//4.Jar 프로그램을 실행해 제공된 설치창(Installer)에서 Lombok 라이브러리를 사용할 이클립스(STS)를
//선택하여 Lombok 라이브러리 설치
// => 이클립스(STS)를 자동으로 찾을 수 없는 경우 이클립스(STS)가 설치된 폴더를 선택하여 Lombok 설치
//5.이클립스(STS)가 설치된 폴더로 이동하여 STS.ini 파일을 편집하여 저장하고 이클립스(STS) 실행
// => [-javaagent:lombok.jar] 변경 - lombok.jar 파일을 경로를 절대경로에서 상대경로로 변경
//6.이클립스(STS)에서 Lombok 라이브러리가 제공하는 어노테이션을 사용하여 클래스 작성
// => @AllArgsConstructor, @NoArgsConstructor, @RequiredArgsConstructor, @Setter, @Getter, @ToString 등 

//@NoArgsConstructor : 매개변수가 없는 기본 생성자를 제공하기 위한 어노테이션
//@AllArgsConstructor : 모든 필드를 초기화 처리하기 위한 매개변수가 작성된 생성자를 제공하기 위한 어노테이션
//@RequiredArgsConstructor : final 제한자를 사용한 필드만 초기화 처리하기 위한 매개변수가 작성된 
//생성자를 제공하기 위한 어노테이션
// => @NoArgsConstructor 어노테이션과 같이 사용할 경우 에러 발생
//@Setter : 클래스에 작성된 모든 필드에 대한 Setter 메소드를 제공하기 위한 어노테이션
// => 필드에 @Setter 어노테이션을 사용하여 해당 필드에 대한 Setter 메소드만 제공 가능
//@Getter : 클래스에 작성된 모든 필드에 대한 Getter 메소드를 제공하기 위한 어노테이션
//=> 필드에 @Getter 어노테이션을 사용하여 해당 필드에 대한 Getter 메소드만 제공 가능
//@ToString : 클래스에 toString() 메소드를 오버라이드 선언되도록 제공하기 위한 어노테이션
// => 클래스에 작성된 모든 필드값을 결합하여 문자열로 반환하는 기능 제공 - 필드값 확인
//@Data : Setter 메소드, Getter 메소드, toString 메소드, equals 메소드, hashCode 메소드를 
//제공하기 위한 어노테이션 - VO 클래스(객체를 값으로 비교되도록 작성된 클래스)를 선언할 때 사용

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Member {
	private String id;
	private String name;
	private String email;
}













