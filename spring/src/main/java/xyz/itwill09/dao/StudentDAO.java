package xyz.itwill09.dao;

import java.util.List;

import xyz.itwill07.dao.Student;

public interface StudentDAO {
	int insertStudent(Student student);
	List<Student> selectStudentList();
}
