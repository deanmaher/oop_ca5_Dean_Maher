//SD2A
//Dean Maher
//D00230655
package com.dkit.oopca5.server.DTOs;

import com.dkit.oopca5.client.CourseManager;
import com.dkit.oopca5.client.StudentManager;

import java.util.HashMap;
import java.util.List;

public class CourseChoices {
    // reference to constructor injected studentManager
    private StudentManager studentManager;

    // reference to constructor injected courseManager
    private CourseManager courseManager;

    // Store all the Course details -  fast access
    private HashMap<String,Course> courseMap;

    // caoNumber, course selection list - for fast access
    //HashMap with key:CAO Number value:choices ArrayList
    HashMap<String, List<String>> selectedChoices = new HashMap<String, List<String>>();

    private String caoNumber;
    private String courseID;
    private String order;

    public CourseChoices(String caoNumber, String courseID, String order) {
        this.caoNumber = caoNumber;
        this.courseID = courseID;
        this.order = order;
    }

    public void CourseChoicesManager( String caoNumber, String courseID, String order
//    StudentManager studentManager, CourseManager courseManager
    ) {
//        this.studentManager = studentManager;
//        this.courseManager = courseManager;
        this.caoNumber = caoNumber;
        this.courseID = courseID;
        this.order = order;
    }

//    public void updateChoices(String caoNumber, String courseID, String order) {
//        List<String> put = selectedChoices.put(caoNumber, courseID, order);
//
//
//    }
    public List<String> getStudentChoices( int caoNumber)
    {
        List<String> choices = selectedChoices.get(caoNumber);
        return choices;
    }

    public List<String> getStudentChoicess(int caoNumber) {
        return selectedChoices.get(caoNumber);
    }

    public Student getStudentDetails(int caoNumber) {
        return studentManager.getStudent(caoNumber);
    }


    //passed a courseID, looks through course hashmap in courseManager and return a courses details
    public Course getCourseDetails(String courseID) {

        //if(courseMap.containsKey(courseID)){
        return courseManager.getCourse(courseID);
     /*   }
        else {
        return null;
        }
 Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            Course c = iterator.next();
            if (c.getCourseId().equals(courseID)) {
                return c;
            }
        }*/
    }
//

//

    //
    public List getAllCourses() {
        return courseManager.getAllCourses();
    }
    //
//    public boolean login(int caoNumber, String dateOfBirth,String password) {
//
//
//        Scanner keyboard = new Scanner(System.in);
//        //DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
//
//        //Actual expected values for login for comparison
//        Student s = Student.findStudentBy(caoNumber);
//        String d = getStudentDetails(caoNumber).getDayOfBirth();
//        String p = getStudentDetails(caoNumber).getPassword();
//
//
//        if( d == dateOfBirth && p == password){
//            return true;
//        }
//        else{
//            return false;
//        }







    }

