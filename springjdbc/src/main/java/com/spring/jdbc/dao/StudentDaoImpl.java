package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;  // Correct import
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
    private JdbcTemplate jdbcTemplate;

    // Insert Operation
    @Override
    public int insert(Student student) {
        // Insert Query
        String query = "insert into student(id, name, city) values(?, ?, ?)";
        int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return r;
    }

    // Update Operation
    @Override
    public int change(Student student) {
        // Updating query
        String query = "update student set name=?, city=? where id=?";
        int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return r;
    }

    // Delete Operation
    public int delete(int studentId) {
        // Delete query
        String query = "delete from student where id=?";
        int r = this.jdbcTemplate.update(query, studentId);
        return r;
    }

    // Get Single Student Operation
    @Override
    public Student getStudent(int studentId) {
        // Query
        String query = "select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();  // Correct usage
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return student;
    }

    
    // Selecting Multiple Students
    @Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
    	return students;
	}
    
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	
}
