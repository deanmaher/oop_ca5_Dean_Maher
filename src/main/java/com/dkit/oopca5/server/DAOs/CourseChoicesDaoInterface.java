//SD2A
//Dean Maher
//D00230655
package com.dkit.oopca5.server.DAOs;
import com.dkit.oopca5.server.DTOs.Course;
import com.dkit.oopca5.server.Exceptions.DaoException;
import java.util.List;

public interface CourseChoicesDaoInterface {
    public List<String> getStudentChoices() throws DaoException;
}
