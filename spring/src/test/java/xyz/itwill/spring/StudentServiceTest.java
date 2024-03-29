package xyz.itwill.spring;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill09.dto.Student;
import xyz.itwill09.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		, "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
//@FixMethodOrder : 테스트 메소드 호출순서를 설정하기 위한 어노테이션
//value 속성 : MethodSorters Enum 자료형의 상수 중 하나를 속성값으로 설정
// => MethodSorters.DEFAULT : JUnit 프로그램의 내부 규칙에 의해 메소드가 정렬되어 호출 - 실행시 동일한 순서로 정렬되어 호출
// => MethodSorters.JVM : JVM 프로그램에 의해 메소드가 정렬되어 호출 - 실행시 불규칙한 순서로 정렬되어 호출
// => MethodSorters.NAME_ASCENDING : 테스트 메소드의 이름으로 정렬되어 호출 - 실행시 동일한 순서로 정렬되어 호출
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Slf4j
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testAddStudent() {
		Student student=Student.builder().no(8000).name("둘리").phone("010-4847-4314")
				.address("서울시 광진구").birthday("1998-07-27").build();
		
		studentService.addStuent(student);
	}
	
	@Test
	public void testGetStudnetList() {
		List<Student> studentList=studentService.getStudentList();
		
		for(Student student : studentList) {
			log.info(student.toString());
		}
	}
}
