package ch24;

public class Subject {
	private int subjectScore;
	private String subjectName;
	
	public Subject(String name, int score) {
		subjectName = name;
		subjectScore = score;
	}

	public int getSubjectScore() {
		return subjectScore;
	}

	public String getSubjectName() {
		return subjectName;
	}

	
	

}
