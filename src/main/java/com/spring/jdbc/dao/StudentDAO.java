package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entity.Student;

public interface StudentDAO {

	public int insert(Student student);

	public int change(Student student);

	public int delete(int studentId);

	public Student getStudent(int studentId);

	public List<Student> getAllStudents();
}
