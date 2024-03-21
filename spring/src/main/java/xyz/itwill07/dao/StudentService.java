package xyz.itwill07.dao;

import java.util.List;

public interface StudentService {
	void addStudent(Student student);
	void modifyStudent(Student student);
	void removeStudent(int no);
	Student getStudent(int no);
	List<Student> getStudentList();
}
