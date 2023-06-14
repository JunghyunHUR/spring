package student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		Student student = new Student("ȫ�浿", "18��", "2�г�", "8��");
		StudentInfo studentInfo = new StudentInfo(student);
		studentInfo.getStudentInfo();
		 */
		
		String configXml = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configXml);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		studentInfo.getStudentInfo();
		
		ctx.close();
	}
}
