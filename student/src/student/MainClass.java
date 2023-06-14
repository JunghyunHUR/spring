package student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		Student student = new Student("홍길동", "18살", "2학년", "8반");
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
