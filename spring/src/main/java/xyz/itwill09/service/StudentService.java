package xyz.itwill09.service;

import java.util.List;

import xyz.itwill09.dto.Student;

public interface StudentService {
	void addStuent(Student student);
	List<Student> getStudentList();
}
