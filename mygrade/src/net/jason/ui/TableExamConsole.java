package net.jason.ui;

import net.jason.entity.Exam;

public class TableExamConsole implements ExamConsole {
	
	private Exam exam;

	public TableExamConsole() {
	}

	public TableExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {

		System.out.printf("+---------------------+\n");
		System.out.printf("+  total  +    avg    +\n");
		System.out.printf("+---------------------+\n");
		System.out.printf("+  %3d    +    %3.2f   +\n", exam.total(), exam.avg());
		System.out.printf("+---------------------+\n");
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
