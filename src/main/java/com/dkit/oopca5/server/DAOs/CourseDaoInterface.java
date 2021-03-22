package com.dkit.oopca5.server.DAOs;

import com.dkit.oopca5.server.DTOs.Course;
import com.dkit.oopca5.server.Exceptions.DaoException;
import java.util.List;

public interface CourseDaoInterface {


        public List<Course> findAllCourses() throws DaoException;


}
