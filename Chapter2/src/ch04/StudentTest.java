package ch04;

public class StudentTest {

	public static void main(String[] args) {
		Student student = new Student();
		student.studentId = 12345;
		student.setStudentName("Lee");
		student.address = "서울 강남구";
		
		student.showStudentInfo();
		
		
		Student student2 = new Student();
		student2.studentId = 54321;
		student2.studentName = "Kim";
		student2.address = "경기도 성남시";
		
		student2.showStudentInfo();
		
	}

}
