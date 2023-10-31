package oop;

public class StudentApp {
	public static void main(String[] args) {
		Student student1=new Student(1000, "홍길동", 90, 90);
		Student student2=new Student(2000, "임꺽정", 94, 98);
		Student student3=new Student(3000, "전우치", 91, 80);
		Student student4=new Student(4000, "일지매", 76, 82);
		Student student5=new Student(5000, "장길산", 84, 86);
		
		student1.display();
		student2.display();
		student3.display();
		student4.display();
		student5.display();
	}
}
