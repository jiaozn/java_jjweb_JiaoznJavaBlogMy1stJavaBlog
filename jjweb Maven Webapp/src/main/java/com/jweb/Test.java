package com.jweb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jjweb.model.Student;
import com.jjweb.service.StudentService;

public class Test {
	public static void main(String[] args){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService service =(StudentService) context.getBean("studentServiceImpl");
		Student s=service.findById(1);
		System.out.println(s.getName());
	}
}
