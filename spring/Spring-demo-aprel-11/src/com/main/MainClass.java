package com.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// Spring konteyner yaratmaq
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Spring konteynerdən obyekti əldə etmək
		Student s = context.getBean("student", Student.class);
		// Obyekti istifadə etmək
		System.out.println(s.getName());
		s.setName("Adil");
		
		
		Student s1 = context.getBean("student", Student.class);
		 
		System.out.println(s1.getName());
		
		
		// Spring konteyneri bağlamaq
		context.close();

	}
}
