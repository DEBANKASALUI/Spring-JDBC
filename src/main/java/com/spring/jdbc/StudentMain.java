package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.dao.StudentDAOImpl;
import com.spring.jdbc.entity.Student;

//following Industry Standard and Design Pattern
public class StudentMain {

	public static void main(String[] args) {
		System.out.println("Spring JDBC Program started...!");

//		for XML based Configuration
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

//		for Annotation based Configuration
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDAO dao = context.getBean("dao", StudentDAO.class);

//		 Inserting Student:
		Student stu = new Student(112, "Hagrid", "France");
		System.out.println(stu);
		int result = dao.insert(stu);
		System.out.println("Number of records inserted: " + result);

//		Updating Student:
		Student stu1 = new Student();
		stu1.setId(110);
		stu1.setName("Genie Dumbledore");
		stu1.setCity("Germany");
		int uResult = dao.change(stu1);
		System.out.println(stu1);
		System.out.println("Number of records updated: " + uResult);

//		Deleting Student:
		int dResult = dao.delete(110);
		System.out.println("Number of records deleted: " + dResult);

//		Selecting Single Data
		Student student = dao.getStudent(105);
		System.out.println(student);

//		Selecting Multiple Data
		List<Student> stu3 = dao.getAllStudents();
		System.out.println(stu3);
		stu3.forEach(i -> System.out.println(i));

	}

}
