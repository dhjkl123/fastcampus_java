package ch06;

public class StuentTest {

	public static void main(String[] args) {
		Student student = new Student(12345,"kim",1);
		
		System.out.println(student.showStudentInfo());
		
		Student student2 = new Student();
		
		System.out.println(student2.showStudentInfo());
	}

}
