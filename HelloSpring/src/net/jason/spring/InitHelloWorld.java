package net.jason.spring;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloWorld implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		System.out.println("BeforeInitialization" + beanName);
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("AfterInitialization" + beanName);
		return bean;
	}
}
