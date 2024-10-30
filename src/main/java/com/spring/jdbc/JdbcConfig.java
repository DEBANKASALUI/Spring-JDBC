package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mysql.cj.jdbc.Driver;
import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.dao.StudentDAOImpl;

@Configuration
@ComponentScan(basePackages={"com.spring.jdbc.dao"})
public class JdbcConfig {

	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		return driverManagerDataSource;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {

		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}

//	Not Required if we are using Component & Autowired Annotations in DAO class

//	@Bean("dao")
//	public StudentDAO getStudentDao() {
//
//		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
//		studentDAOImpl.setTemplate(getTemplate());
//		return studentDAOImpl;
//
//	}

}
