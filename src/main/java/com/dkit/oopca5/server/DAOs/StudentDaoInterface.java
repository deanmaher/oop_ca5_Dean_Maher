package com.dkit.oopca5.server.DAOs;

import com.dkit.oopca5.server.DTOs.Student;
import com.dkit.oopca5.server.Exceptions.DaoException;
import java.util.List;

public interface StudentDaoInterface {

    public List<Student> findAllStudents() throws DaoException;

}
