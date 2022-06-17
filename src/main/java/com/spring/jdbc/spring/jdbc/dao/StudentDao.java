package com.spring.jdbc.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.spring.jdbc.entities.Student;

public interface StudentDao {
	public int insertData(Student student);
	
	public int updateData(Student student); 
	
	public int deleteData(int studentId); 
	
	public Student getStudentData(int studentId); 
	
	public List<Student> getAllStudent(); 
	
}
