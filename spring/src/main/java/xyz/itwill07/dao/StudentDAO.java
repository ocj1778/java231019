package xyz.itwill07.dao;

import java.util.List;

public interface StudentDAO {
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int no);
	Student selectStudent(int no);
	List<Student> selectStudentList();
}
