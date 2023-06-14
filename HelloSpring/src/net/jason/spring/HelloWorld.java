package net.jason.spring;

public class HelloWorld {
	private String message1;
	private String message2;
	
	public void getMessage1() {
		System.out.println("World Message : " + message1);
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
	}
	public void getMessage2() {
		System.out.println("World Message : " + message2);
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}
}
