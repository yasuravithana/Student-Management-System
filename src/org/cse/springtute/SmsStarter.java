package org.cse.springtute;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SmsStarter {

	public static void main(String[] args) {            
            ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
            context.start();
            StudentManagementSystem sms =(StudentManagementSystem)context.getBean("StudentManagementSystemBean");
            System.out.println("\nInitially these records were stored\n");
            sms.listAllStudents();
            System.out.println("\nThree new students are registered");
            sms.registerStudent((Student)context.getBean("student1"));
            sms.registerStudent((Student)context.getBean("student2"));
            sms.registerStudent((Student)context.getBean("student3"));
            System.out.println("\nNow these records are stored.\n");
            sms.listAllStudents();
	}
}
