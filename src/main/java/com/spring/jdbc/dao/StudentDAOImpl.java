package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;

@Component("dao")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate template;

	@Override
	public int insert(Student student) {

//		INSERT query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.template.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	@Override
	public int change(Student student) {

//		UPDATE Query
		String uquery = "update student set name=?,city=? where id=?";
		int u = this.template.update(uquery, student.getName(), student.getCity(), student.getId());
		return u;
	}

	@Override
	public int delete(int studentId) {

//		DELETE Query
		String dQuery = "delete from student where id=?";
		int d = this.template.update(dQuery, studentId);
		return d;
	}

	@Override
	public Student getStudent(int studentId) {
//		SELECT single student data
		String sQuery = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student stu = this.template.queryForObject(sQuery, rowMapper, studentId);
		return stu;
	}

	@Override
	public List<Student> getAllStudents() {
//		SELECT multiple students data
		String smQuery = "select * from student";
		List<Student> list = this.template.query(smQuery, new RowMapperImpl());
		return list;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
