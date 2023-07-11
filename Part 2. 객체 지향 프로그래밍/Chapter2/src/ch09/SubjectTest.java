package ch09;

public class SubjectTest {
	public static void main(String[] args)
	{
		Student student = new Student(100,"lee");
		student.setKoreaSubject("국어",100);
		student.setKoreaSubject("수학",99);
		
		Student student2 = new Student(200,"kim");
		student.setKoreaSubject("국어",50);
		student.setKoreaSubject("수학",65);
		
		student.showScoreInfo();
		student2.showScoreInfo();
	}
}
