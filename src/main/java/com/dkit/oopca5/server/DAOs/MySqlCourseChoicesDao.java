package com.dkit.oopca5.server.DAOs;


import com.dkit.oopca5.server.DTOs.Course;
import com.dkit.oopca5.server.DTOs.CourseChoices;
import com.dkit.oopca5.server.DTOs.Student;
import com.dkit.oopca5.server.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCourseChoicesDao extends MySqlDao implements CourseChoicesDaoInterface {

    @Override
    public List<String> getStudentChoices() throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> choices = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM STUDENT_COURSES WHERE caoNumber = ?";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next())
            {
                String caoNumber = rs.getString("caoNumber");
                String courseID = rs.getString("courseID");
                String order = rs.getString("order");
//                 Course c = new Course(caoNumber, courseID, order);
//                choices.add(c);
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
        return choices;     // may be empty
    }


    public List<String> updateStudentChoices() throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> choices = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "UPDATE STUDENT_COURSES SET courseID = ?, order = ? WHERE caoNumber = ?";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next())
            {
                String caoNumber = rs.getString("caoNumber");
                String courseID = rs.getString("courseID");
                String order = rs.getString("order");

                CourseChoices c = new CourseChoices(caoNumber, courseID, order );
            }
        } catch (SQLException e)
        {
            throw new DaoException("updateStudentChoices() " + e.getMessage());
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
                throw new DaoException("updateStudentChoices() " + e.getMessage());
            }
        }
        return choices;     // may be empty
    }

}



