package com.test.app.student.vo;

public class StudentVo {
	
	private String studentNumber;
	private String studentName;
	private String koreanScore;
	private String EnglishScore;
	private String MathScore;
	
	public StudentVo() {
		
	}

	public StudentVo(String studentNumber, String studentName, String koreanScore, String englishScore,
			String mathScore) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.koreanScore = koreanScore;
		EnglishScore = englishScore;
		MathScore = mathScore;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(String koreanScore) {
		this.koreanScore = koreanScore;
	}

	public String getEnglishScore() {
		return EnglishScore;
	}

	public void setEnglishScore(String englishScore) {
		EnglishScore = englishScore;
	}

	public String getMathScore() {
		return MathScore;
	}

	public void setMathScore(String mathScore) {
		MathScore = mathScore;
	}
	
	@Override
	public String toString() {
		return "StudentVo [studentNumber=" + studentNumber + ", studentName=" + studentName + ", koreanScore="
				+ koreanScore + ", EnglishScore=" + EnglishScore + ", MathScore=" + MathScore + "]";
	}
}
