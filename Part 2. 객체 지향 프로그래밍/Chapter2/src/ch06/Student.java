package ch06;

public class Student {
	public int studentNumber;
	public String studentName;
	public int studentGrade;
	
	public Student() {}
	
	public Student(int Number, String Name, int grade) {
		this.studentNumber = Number;
		this.studentName = Name;
		this.studentGrade = grade;
	}
	
	public String showStudentInfo() {
		return studentNumber + "학생의 이름은 " + studentName + "이고, " + studentGrade + "학년 입니다."; 
	}
}
