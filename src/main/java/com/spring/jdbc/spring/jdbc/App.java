package com.spring.jdbc.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.spring.jdbc.entities.Student;

public class App {
	public static void main(String[] args) {
		int j=0;
		int i=10;
		System.out.println("+++++++SPRING JDBC STARTED++++++");
		/*
		 * ApplicationContext con = new
		 * ClassPathXmlApplicationContext("com/spring/jdbc/spring/jdbc/configjdbc.xml");
		 * StudentDao dao = con.getBean("studentDao", StudentDao.class);
		 */
		//Wihout XML using annotation 
		ApplicationContext con=new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao dao = con.getBean("studentDao", StudentDao.class);
		 Student student=new Student();
		 student.setStudentId(010); 
		 student.setStudentName("Lucky");
		 student.setStudentAddr("DMNJD-Odisha");
		 int result=dao.insertData(student);
		System.out.println("Student added ::"+result);
		 

		/*
		 * Student student2=new Student();
		 * 
		 * student2.setStudentId(654); student2.setStudentName("Chinmay");
		 * student2.setStudentAddr("Ganjam-Odisha"); int
		 * updateRec=dao.updateData(student2); System.out.println(updateRec); int
		 * deleteRecord=dao.deleteData(student2.getStudentId());
		 * System.out.println("No of record deleted ::"+deleteRecord);
		 */
		/*
		 * Student student=dao.getStudentData(889); System.out.println(student);
		 */

		List<Student> studentAll = dao.getAllStudent();
		for (Student stu : studentAll)
			System.out.println(stu);
	}
}
