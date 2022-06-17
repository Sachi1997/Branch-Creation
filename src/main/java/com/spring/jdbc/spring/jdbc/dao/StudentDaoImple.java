package com.spring.jdbc.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.spring.jdbc.entities.Student;

public class StudentDaoImple implements StudentDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertData(Student student) {
		String query = "insert into Student(studentId,Student_Name,Student_Addr) values(?,?,?)";
		// Fire Query
		int rec = this.jdbcTemplate.update(query, student.getStudentId(), student.getStudentName(),
				student.getStudentAddr());
		System.out.println("No. of records inserted ::");
		return rec;
	}

	public int updateData(Student student) {
		String query = "update Student set Student_Name=?,Student_Addr=? where StudentId=?";
		// Fire Query
		int updateRecord = this.jdbcTemplate.update(query, student.getStudentName(),student.getStudentAddr(),student.getStudentId());
		System.out.println("No. of records updated ::");
		return updateRecord;
	}

	public int deleteData(int studentId) {
		String query = "delete from Student where StudentId=?";
		// Fire Query
		int deleteRecord = this.jdbcTemplate.update(query,studentId);
		System.out.println("No. of records deleted ::");
		return deleteRecord;
	}

	public Student getStudentData(int studentId) {
		//selecting single student data
		String query="select * from Student where StudentId=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=  this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}

	
	public List<Student> getAllStudent() {
		//selecting multiple student data
				String query="select * from Student";
				List<Student> student=  this.jdbcTemplate.query(query, new RowMapperImpl());
				return  student;
			
	}

}
