package net.jason.spring;

public class ExeExam implements Engineer {
	
	private int subjectA;
	private int subjectB;
	private int subjectC;
	private int subjectD;
	private int subjectE;
	
	@Override
	public int total() {
		return subjectA + subjectB + subjectC + subjectD + subjectE;
	}

	@Override
	public float avg() {
		return total() / 5.0f ;
	}

}
