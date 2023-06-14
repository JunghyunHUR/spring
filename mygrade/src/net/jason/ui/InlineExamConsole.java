package net.jason.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.jason.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	@Autowired
	private Exam exam;
	
	public InlineExamConsole() {}
	
//	public InlineExamConsole(Exam exam) {
//		System.out.println("오버로드 생성자");
//		this.exam = exam;
//	}
	
	@Override
	public void print() {
		
		System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
		
	}
	@Override
	@Autowired
//	@Qualifier("exam1")
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
