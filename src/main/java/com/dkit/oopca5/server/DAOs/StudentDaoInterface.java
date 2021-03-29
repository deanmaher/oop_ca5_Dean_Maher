package com.dkit.oopca5.server.DAOs;

import com.dkit.oopca5.server.DTOs.Student;
import com.dkit.oopca5.server.Exceptions.DaoException;
import java.util.List;

public interface StudentDaoInterface {

    public List<Student> findAllStudents() throws DaoException;
    public boolean registerStudent(Student s ) throws DaoException;
    public Student findStudent(String caoNumber) throws DaoException;

}
