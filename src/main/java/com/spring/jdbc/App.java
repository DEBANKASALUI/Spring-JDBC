package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

// not following Industry Standard and Design Pattern, without DAO
public class App {
	public static void main(String[] args) {
		System.out.println("Spring JDBC Program started...!");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		JdbcTemplate jt = context.getBean("jdbcTemplate", JdbcTemplate.class);

//        INSERT Query
		String query = "insert into student(id,name,city) values(?,?,?)";

//        fire Query
		int result = jt.update(query, 104, "Albus Severus Potter", "London");
		System.out.println("Number of records inserted: " + result);

	}
}
