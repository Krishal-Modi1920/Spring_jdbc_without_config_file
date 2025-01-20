package com.spring.jdbc;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student; 
/*
 * 
 * Everytime Enter Some new Name otherwise it will prompt an error 
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started.........." );
        // spring jdbc => JDBC Template
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        
//        // Insert   
//        Student student = new Student();
//        student.setId(147);
//        student.setName("Aditya Lathiya");
//        student.setCity("Amreli");       
//        
//        int result = studentDao.insert(student);
//        System.out.println("student added " + result);

        
//        // Update
//        Student student = new Student();
//        student.setId(466);
//        student.setName("Vasif Peerji");
//        student.setCity("Jamnagar");
//        
//        int result = studentDao.change(student);
//        System.out.println("Data Changed " + result);

    
//        // Delete 
//        int result = studentDao.delete(147);
//        System.out.println("Data Deleted: " + result);
//      
        
        
//		  // Selecting single Student         
//        Student student = studentDao.getStudent(666);
//        System.out.println(student);  // This will print the student details if found

    
        //  Selecting Multiple Student
        List<Student> students = studentDao.getAllStudents();
        for (Student s:students)
        {
        	System.out.println(s);
        }
        
     }
}
