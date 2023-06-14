package net.jason.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyGradeExam implements Exam {
	@Value("20")
	private int kor;
	@Value("30")
	private int eng;
	@Value("40")
	private int math;
	@Value("50")
	private int com;
	
	public MyGradeExam() {}
	
	public MyGradeExam(int kor, int eng) {
		this.kor = kor;
		this.eng = eng;
	}
	
	public MyGradeExam(float kor, float eng) {
		this.kor = (int)kor;
		this.eng = (int)eng;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {
		return kor + eng + math + com;
	}
	
	@Override
	public double avg() {
		return total() / 4.0;
	}
	
	@Override
	public String toString() {
		return "나의점수는 [ 국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math + ", 컴퓨터 : " + com + "] 입니다.";
	}
}
