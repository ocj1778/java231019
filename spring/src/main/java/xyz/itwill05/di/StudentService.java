package xyz.itwill05.di;

import java.util.List;

//학생정보를 처리하는 Service 클래스가 반드시 상속받아야 되는 인터페이스
public interface StudentService {
	void addStudent(Student student);
	void modifyStudent(Student student);
	void removeStudent(int num);
	Student getStudent(int num);
	List<Student> getStudentList();
}
