package xyz.itwill.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentApp {
	public static void main(String[] args) {
		List<Student> studentListOne=new ArrayList<Student>();
		studentListOne.add(new Student(1000, "홍길동"));
		studentListOne.add(new Student(2000, "임꺽정"));
		studentListOne.add(new Student(3000, "전우치"));
		studentListOne.add(new Student(4000, "일지매"));
		studentListOne.add(new Student(5000, "장길산"));
		
		System.out.print("정렬 전 >> ");
		System.out.println(studentListOne);
		
		//Collections 클래스의 sort() 메소드를 호출하면 List 객체에 저장된 모든 요소값(객체 필드값)을 
		//비교하여 정렬하기 위해 Student 클래스의 compareTo() 메소드를 자동 호출하여 비교 처리
		Collections.sort(studentListOne);
		
		System.out.print("정렬 후 >> ");
		System.out.println(studentListOne);
		System.out.println("==============================================================");
		List<Student> studentListTwo=new ArrayList<Student>();
		studentListTwo.add(new Student(6000, "유재석"));
		studentListTwo.add(new Student(7000, "강호동"));
		studentListTwo.add(new Student(8000, "신동엽"));
		studentListTwo.add(new Student(9000, "김용만"));
		
		Map<Integer, List<Student>> studentListMap=new HashMap<Integer, List<Student>>();
		studentListMap.put(1, studentListOne);
		studentListMap.put(2, studentListTwo);
		
		for(Integer ban : studentListMap.keySet()) {
			System.out.println(ban+"반의 학생정보 >> ");
			
			List<Student> studentList=studentListMap.get(ban);
			for(Student student : studentList) {
				System.out.println(student);//Student 클래스의 toString() 메소드 자동 호출
			}
			
			System.out.println();
		}
		System.out.println("==============================================================");
	}
}
