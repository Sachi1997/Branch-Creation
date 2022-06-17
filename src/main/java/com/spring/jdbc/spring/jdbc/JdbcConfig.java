package com.spring.jdbc.spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource; 
import com.spring.jdbc.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.spring.jdbc.dao.StudentDaoImple;


public class JdbcConfig {
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=SpringJdbc");
		ds.setUsername("sa");
		ds.setPassword("spring123");
		return ds;
	}
	@Bean("jdbcTemp")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
		
	}
	@Bean("studentDao")
	public StudentDao getStudentdao() {
		StudentDaoImple dao=new StudentDaoImple() ;
		dao.setJdbcTemplate(getTemplate());
		return dao;		
	}
}
