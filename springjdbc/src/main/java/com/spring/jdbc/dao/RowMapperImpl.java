// For the task of Selecting one student

package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;  // Correct import
import com.spring.jdbc.entities.Student;

public class RowMapperImpl implements RowMapper<Student> {  // Make RowMapper generic

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt(1));
        student.setName(rs.getString(2));
        student.setCity(rs.getString(3));
        return student;  // Return the populated student object
    }
}
