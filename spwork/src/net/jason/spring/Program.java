package net.jason.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		
		Engineer exam = new ExeExam();
		
//		Create Application Context of Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("net/jason/spring/setting.xml");
		EngineerConsole console = (EngineerConsole) context.getBean("console");
		console.print();
		
//		EngineerConsole console = new EIProcessing(exam);
//		EngineerConsole console2 = new EISecurity();
//		console2.setEngineer(exam);
			
		//we want to
//		EngineerConsole console = ?;
//		console.print();
		//EngineerConsole console = new EISecurity();
	}
}
