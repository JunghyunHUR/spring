package net.jason.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("net/jason/bean/Beans.xml");
		
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		
		objA.getMessage1();
		objA.getMessage2();
		
		HelloKorea objB = (HelloKorea) context.getBean("helloKorea");
		objB.getMessage1();
		objB.getMessage2();
		objB.getMessage3();
	}

}
