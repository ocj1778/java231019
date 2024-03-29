package xyz.itwill09.mapper;

import java.util.List;

import xyz.itwill09.dto.Student;

public interface StudentMapper {
	int insertStudent(Student student);
	List<Student> selectStudentList();
}
