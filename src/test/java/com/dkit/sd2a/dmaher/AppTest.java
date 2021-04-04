//SD2A
//Dean Maher
//D00230655
package com.dkit.sd2a.dmaher;

import static org.junit.Assert.assertTrue;

import com.dkit.oopca5.client.CourseManager;
import com.dkit.oopca5.server.DTOs.Course;
import com.dkit.oopca5.server.DTOs.Student;
import com.dkit.oopca5.client.StudentManager;
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

        String caoNumber = "11111111";
        String dob = "1999-09=09";
        String password = "password";
        Student expected = new Student(caoNumber, dob, password);
        studentManager.addStudent(expected);

        Student actual = studentManager.getStudent(11111111);

        assertTrue(actual.equals(expected));
    }
    @Test
    public void testAddCourseToCourseManager(){
        // load courses
        CourseManager courseManager = new CourseManager();


        String courseID = "DK999";
        String level = "8";
        String title = "Ba in Culinary Arts";
        String institution = "DKIT";

        Course expected = new Course(courseID, level, title, institution );
        courseManager.addCourse(expected);

        Course actual = courseManager.getCourse("DK999");

        assertTrue(actual.equals(expected));
    }
    @Test
    public void findStudentTest()
    {
        String caoNumber ="121311";

        studentManager.addStudent(S1);
        //GET CLONE OF ORIGINAL STUDENT
        Student result = studentManager.getStudent(121911);

        //String expected = "Student{caoNumber=121911, dateOfBirth='14/01/2001', password='1234', email='deanmaher@gmail.com'}";

        assert( S1.equals(result) );
    }
    @Test
    public void testStudentDAO(){
//        StudentDaoInterface studentDao = new MySqlStudentDAO();
//        studentDao.findAllStudents();
    }
}

