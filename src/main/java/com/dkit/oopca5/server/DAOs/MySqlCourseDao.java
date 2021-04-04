//SD2A
//Dean Maher
//D00230655
package com.dkit.oopca5.server.DAOs;


import com.dkit.oopca5.server.DTOs.Course;
import com.dkit.oopca5.server.DTOs.Student;
import com.dkit.oopca5.server.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCourseDao extends MySqlDao implements CourseDaoInterface {

    @Override
    public List<Course> findAllCourses() throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> courses = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM COURSE";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next())
            {
                String courseID = rs.getString("courseID");
                String level = rs.getString("level");
                String title = rs.getString("title");
                String institution = rs.getString("institution");
                Course c = new Course(courseID, level, title,institution );
                courses.add(c);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllCourses() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllCourses() " + e.getMessage());
            }
        }
        return courses;     // may be empty
    }

    public Course findCourseByID(String courseID) throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course c = null;

        try
        {
            con = this.getConnection();

            String query = "SELECT * FROM Course WHERE courseID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, courseID);  // search based on the cao number

            rs = ps.executeQuery();
            if (rs.next())
            {
                courseID = rs.getString("courseID");
                String level = rs.getString("level");
                String title = rs.getString("title");
                String institution = rs.getString("institution");

                c = new Course(courseID, level, title,institution );
            }
        } catch (SQLException e)
        {
            throw new DaoException("findCourseByID() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findCourseByID() " + e.getMessage());
            }
        }
        return c;     // s may be null
    }
}


