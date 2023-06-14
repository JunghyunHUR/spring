package net.jason;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.jason.entity.Exam;
import net.jason.ui.ExamConsole;

public class Program {
	
	public static void main(String[] args) {
		
//		Exam exam = new MyGradeExam();
//		ExamConsole console = new InlineExamConsole();
//		ExamConsole console = new TableExamConsole();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("setting.xml");
		
		/*
		 *  ClassPathXml, FileSystemXml, XmlWeb, Annotation...
		 *  
		 */
//		Exam exam = context.getBean(Exam.class);
//		System.out.println(exam.toString());
		
		ExamConsole console = (ExamConsole) context.getBean("console");
//		ExamConsole console = (ExamConsole) context.getBean("ExamConsole.class");
		console.print();
	}
}
