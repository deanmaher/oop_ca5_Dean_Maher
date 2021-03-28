package com.dkit.oopca5.client;

import com.dkit.oopca5.server.DAOs.MySqlCourseDao;
import com.dkit.oopca5.server.DAOs.CourseDaoInterface;
import com.dkit.oopca5.server.DTOs.Course;
import com.dkit.oopca5.server.Exceptions.DaoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.stream.Collectors;

/**
 * CoursesManager
 * This software component Encapsulates the storage and management of
 * all courses available through the CAO system.
 * Only administrators would typically be allowed to update this data,
 * but other users can get a COPY of all the courses by calling getAllCourses().
 * The Web Client would need this data to display the course codes,
 * course titles and institutions to the student.
 */

public class CourseManager {

    // Store all the Course details.
    // Requires fast access given courseId, so we use a HashMap.
    // Load from file, permit updates, and write to file.

    // courseId => course
    private Map<String, Course> coursesMap = new HashMap<>();

    public CourseManager() {

        CourseDaoInterface courseDao = new MySqlCourseDao();

        try {
            List<Course> courseList = courseDao.findAllCourses();
            //add all students from List to Map
            for(Course course  : courseList) {
                coursesMap.put(course.getCourseId(), course);
            }


            System.out.println(coursesMap);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }



        // load from text file "courses.dat" and populate coursesMap

        // Hardcode some values to get started
//        coursesMap.put("DK820", new Course("DK820", "8","BSc in Software Developmnet", "Dundalk IT"));
//        coursesMap.put("DK722", new Course("DK722", "7","BSc in Dev Ops", "Dundalk IT"));
//        coursesMap.put("DN150", new Course("DN150", "8","BA Engineering", "University College Dublin"));
//        coursesMap.put("TU602", new Course("TU602", "8","BSc Computer Science","TU Dublin"));


    public Course getCourse( String courseId ) {
        Course course = coursesMap.get(courseId);  // get course using id and then
        return new Course( course ); //  return a clone (make a copy) of the course.
    }

    // Returns a *List* of Courses.
    // Courses are not in any particular order.
    //
    public List<Course> getAllCourses() {

        ArrayList<Course> list = new ArrayList<>(); // new ArrayList to store copy of Map data

        // Iterate through all values in the courseMap and add
        // a copy (a clone) of each course to the new List
        for (Map.Entry<String, Course> entry : coursesMap.entrySet()) {
            Course course = entry.getValue();   // get course from map entry
            list.add(new Course(course));       // add course clone to the List
        }
        return list;    // return the List
    }

    // add a Course object to the courses store
    //
    public void addCourse(Course course) {
        // clone the course object to prevent external access
        String courseId = course.getCourseId();     // get the course id from the object
        coursesMap.put( courseId, new Course(course));    // create and store a clone of the course object
    }

    // remove a course, given a courseId
    //
    public void removeCourse(String courseId) {
        coursesMap.remove(courseId);
    }

    // editCourse(courseId);       // not required for this iteration

}
