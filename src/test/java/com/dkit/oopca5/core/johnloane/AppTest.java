package com.dkit.oopca5.core.johnloane;

import static org.junit.Assert.assertTrue;
import com.dkit.oopca5.server.DTOs.Student;
import com.dkit.oopca5.client.BusinessObjects.StudentManager;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAddStudentToStudentManager(){
        // load students
        StudentManager studentManager = new StudentManager();
//
//        Student s = studentManager.getStudent(12345678);

        int caoNumber = 11111111;
        String dob = "1999-09=09";
        String password = "password";
        Student expected = new Student(caoNumber, dob, password);
        studentManager.addStudent(expected);

        Student actual = studentManager.getStudent(11111111);

        assertTrue(actual.equals(expected));
    }

    @Test
    public void testStudentDAO(){
//        StudentDaoInterface studentDao = new MySqlStudentDAO();
//        studentDao.findAllStudents();
    }
}

