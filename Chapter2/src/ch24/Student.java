package ch24;

import java.util.ArrayList;

public class Student {
	
	public Student(int Number, String Name) {
		studentName = Name;
		studentNumber = Number;
	}
	
	private int studentNumber;
	private String studentName;
	private ArrayList<Subject> subjectArray = new ArrayList<>();

	public void addSubject(String subjectName, int subjectScore) {
		this.subjectArray.add(new Subject(subjectName,subjectScore));
	}
	
	public void showStudentInfo() {
		int total = 0;
		for(var subject : subjectArray) {
			int score = subject.getSubjectScore();
			System.out.println("학생 " + studentName + "의 " + subject.getSubjectName() + " 과목 성적은 " + score + "입니다.");
			total += score;
		}
		
		System.out.println("학생 " + studentName + "의 총점은 " + total + "입니다.");
	}
	

}
