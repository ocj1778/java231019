package xyz.itwill9.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.StudentDAO;
import xyz.itwill09.dto.Student;

//Service 클래스 : 클라이언트 요청에 대한 데이타 처리 기능을 제공하기 위한 클래스 - 컴퍼넌트(Component)
// => Service 클래스의 메소드에서는 데이타 처리에 필요한 명령으로 DAO 클래스의 메소드를 
//호출하여 작성 - DAO 객체를 모듈화 처리하여 제공 
// => Service 클래스가 교체돼도 의존관계로 설정된 Controller 클래스에 영향을 최소화 하기 위해 
//인터페이스를 상속받아 작성하는 것을 권장

//Service 클래스는 Controller 클래스에서 객체로 제공받아 사용할 수 있도록 반드시 Spring Bean으로 등록
//=> Service 클래스는 @Service 어노테이션을 사용하여 Spring Bean으로 등록 처리
//=> @Service 어노테이션을 스프링 컨테이너가 처리하기 위해 반드시 클래스가 작성된 패키지를
//Spring Bean Configuration File(servlet-context.xml)의 component-scan 엘리먼트로 검색되도록 설정

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	//Service 클래스의 메소드에서는 DAO 클래스의 메소드를 호출할 수 있도록 DAO 객체가 저장될 필드 작성
	// => DAO 객체가 저장될 수 있는 필드를 작성하여 스프링 컨테이너로부터 Spring Bean을
	//제공받아 저장되도록 의존성 주입(DI) - 생성자 레벨의 의존성 주입
	private final StudentDAO studentDAO;
	
	@Override
	public void addStuent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}
}
