package com.dkit.oopca5.client;

/* The client package should contain all code and classes needed to run the Client
 */

/* The CAOClient offers students a menu and sends messages to the server using TCP Sockets
 */


import com.dkit.oopca5.server.DAOs.CourseDaoInterface;
import com.dkit.oopca5.server.DAOs.MySqlCourseDao;
import com.dkit.oopca5.server.DTOs.Course;
import com.dkit.oopca5.server.DTOs.Student;
import com.dkit.oopca5.server.Exceptions.DaoException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.dkit.oopca5.core.CAOService.*;


public class CAOClient
{
    public static void main(String[] args) throws IOException, ParseException, InputMismatchException {
        System.out.println("CAO Online - CA5 - Dean Maher SD2A");
        new CAOClient().start();
    }
    private void start() throws IOException, ParseException {
        try {
            Socket socket = new Socket(HOSTNAME, PORT_NUM);  // connect to server socket
            System.out.println("Client: Port# of this client : " + socket.getLocalPort());
            System.out.println("Client: Port# of Server :" + socket.getPort() );

            System.out.println("Client message: The Client is running and has connected to the server");


        // load students
        StudentManager studentManager = new StudentManager();

        // load courses
        CourseManager courseManager = new CourseManager();


//        CourseChoicesManager mgr = new CourseChoicesManager(studentManager, courseManager);
        boolean systemOn;

        CourseDaoInterface courseDao = new MySqlCourseDao();


        while (systemOn = true) {
            Scanner keyboard = new Scanner(System.in);
            int type = firstMenu();
            try {
                if (type == 0) {

                    System.out.println("Thank you for using this system. Goodbye!");
                    break;
                }
                if (type == 1) {
                    OutputStream os = socket.getOutputStream();
                    PrintWriter socketWriter = new PrintWriter(os, true);
//                    register?????
                    System.out.println("Enter CAO Number:");
                    int caoNumber = keyboard.nextInt();



                        System.out.println("Enter date of birth:");
                        String dateOfBirth = keyboard.next();

                        System.out.println("Enter password: (must be at least 5 characters long)");
                        String password = keyboard.next();
//                        String regex = "^[a-zA-Z]{5,}$";
//                        boolean result = password.matches(regex);
//                        if (result) {

                        String message = REGISTER_COMMAND + BREAKING_CHARACTER + caoNumber + BREAKING_CHARACTER + dateOfBirth + BREAKING_CHARACTER + password + '\n';
                        System.out.println(message);
                        socketWriter.println(message);

                        Scanner socketReader = new Scanner(socket.getInputStream()); //waiting for reply
//                    System.out.println(message);

                        if (message.startsWith(REGISTER_COMMAND)) {
                            String response = socketReader.nextLine();
                            System.out.println(response);
                            mainMenu();

                        } else {
                            String input = socketReader.nextLine();
                            System.out.println(input);
                            break;
                        }
                    }
//                    else{
//                        System.out.println("password must be at least 5 characters long");
//                    }


                if (type == 2) {
//                    normal login
//                    printMainMenu();
                    mainMenu();
                    OutputStream os = socket.getOutputStream();
                    PrintWriter socketWriter = new PrintWriter(os, true);
//
                    System.out.println("Enter CAO Number:");
                    int caoNumber = keyboard.nextInt();
                    System.out.println("Enter date of birth:");
                    String dateOfBirth = keyboard.next();

                    System.out.println("Enter password: (must be at least 5 characters long)");
                    String password = keyboard.next();
//                        String regex = "^[a-zA-Z]{5,}$";
//                        boolean result = password.matches(regex);
//                        if (result) {

                    String message = LOGIN_COMMAND + BREAKING_CHARACTER + caoNumber + BREAKING_CHARACTER + dateOfBirth + BREAKING_CHARACTER + password + '\n';
                    System.out.println(message);
                    socketWriter.println(message);

                    Scanner socketReader = new Scanner(socket.getInputStream()); //waiting for reply
//                    System.out.println(message);

                    if (message.startsWith(LOGIN_COMMAND)) {
                        String response = socketReader.nextLine();
                        System.out.println(response);
                        mainMenu();

                    } else {
                        String input = socketReader.nextLine();
                        System.out.println(input);
                        break;
                    }
                }

            }
            catch (InputMismatchException e) {
                System.out.println(e + " Please Enter a NUMBER [0-2]");
            }
        }


           socket.close();

        }
        catch (IOException e) {
            System.out.println("Client message: IOException: "+e);
        }
    }

    public static void printMainMenu() {
        System.out.println("\n**************************************************************");

        System.out.println("0. QUIT");
        System.out.println("1. LOGOUT");
        System.out.println("2. DISPLAY_COURSE");
        System.out.println("3. DISPLAY_ALL_COURSES");
        System.out.println("4. DISPLAY_CURRENT_CHOICES");
        System.out.println("5. UPDATE_CURRENT_CHOICES");

    }

    public int firstMenu() throws IOException, ParseException {
            int option1 = 0;
            Scanner keyboard = new Scanner(System.in);
         System.out.println("\n**************************************************************");
            System.out.println("0. QUIT_APPLICATION");
            System.out.println("1. REGISTER");
            System.out.println("2. LOGIN");
            return option1 = keyboard.nextInt();
    }

    public void mainMenu() throws IOException {
        StudentManager studentManager = new StudentManager();
        CourseManager courseManager = new CourseManager();
        CourseChoicesManager mgr = new CourseChoicesManager(studentManager, courseManager);
        Scanner keyboard = new Scanner(System.in);

        //For student menu login


        printMainMenu();

        System.out.print("Please enter option:");
        int option = keyboard.nextInt();
        while (option <= 5)
        {
            try
            {

                if (option == 0)
                {
//                    quit
                    break;

                }
                else if (option == 1)
                {
//                 logout
                }
                else if (option == 2)
                {
//                    display course
//                    System.out.println("Displaying all courses: ");
//                    System.out.println(mgr.getAllCourses());

                    pressAnyKeyToContinue();

                }
                else if (option == 3)
                {
//                 DISPLAY ALL COURSES

                    CourseDaoInterface courseDao = new MySqlCourseDao();
                    try
                    {
                        List<Course> courseList = courseDao.findAllCourses();
                        System.out.println(courseList);
                    }
                    catch (DaoException e)
                    {
                        e.printStackTrace();
                    }

                }


                else if (option == 4)
                {
                    //                 DISPLAY COURSE

//                    CourseDaoInterface courseDao = new MySqlCourseDao();
//                    try
//                    {
//                        List<Course> courseList = courseDao.findCourseByID();
//                        System.out.println(courseList);
//                    }
//                    catch (DaoException e)
//                    {
//                        e.printStackTrace();
//                    }

                }

            }
            catch(InputMismatchException e)
            {
                System.out.println("Please Enter a number [0-5]");
            }


//    public static void main(String[] args) {
//
//        // load students
//        StudentManager studentManager = new StudentManager();
////
////        Student s = studentManager.getStudent(12345678);
//
//        int caoNumber = 11111111;
//        String dob = "1999-09=09";
//        String password = "password";
//        studentManager.addStudent(new Student (caoNumber, dob, password));
//
//        Student s = studentManager.getStudent(11111111);
//        System.out.println("Getting student with this caoNumber: "+s);
//    }
        }
    }
    public void pressAnyKeyToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}














//        StudentDaoInterface studentDao = new MySqlStudentDAO();
//
//        try {
//            List<Student> studentList = studentDao.findAllStudents();
//            System.out.println(studentList);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//    }
//}


//        UserDaoInterface IUserDao = new MySqlUserDao();  //"IUse..." -> "I" for Interface
//        // Notice that the userDao reference is an Interface type.
//        // This allows for the use of different concrete implementations.
//        // e.g. we could replace the MySqlUserDao with an OracleUserDao
//        // (accessing an Oracle Database)
//        // without changing anything in the Interface.
//        // If the Interface doesn't change, then none of the
//        // code below that uses the interface needs to change.
//        // The 'contract' defined by the interface will not be broken.
//        // This means that this code is independent of the code
//        // used to access the database. (Reduced coupling).
//
//        // The Business Objects require that all User DAOs implement
//        // the interface called "UserDaoInterface", as the code uses
//        // only references of the interface type to access the DAO methods.
//        try
//        {
//            System.out.println("\nCall findAllUsers()");
//            List<User> users = IUserDao.findAllUsers();
//
//            if( users.isEmpty() )
//                System.out.println("There are no Users");
//
//            for( User user : users )
//                System.out.println("User: " + user.toString());
//
//            // test dao - with good username and password
//            System.out.println("\nCall: findUserByUsernamePassword()");
//            User user = IUserDao.findUserByUsernamePassword("smithj", "password");
//            if(user != null)
//                System.out.println("User found: " + user);
//            else
//                System.out.println("Username with that password not found");

// test dao - with bad username
//            user = IUserDao.findUserByUsernamePassword("madmax", "thunderdome");
//            if(user != null)
//                System.out.println("User found: " + user);
//            else
//                System.out.println("Username with that password not found");

//            List<User> list = new ArrayList<>();
//            list =  IUserDao.findAllUsersLastNameContains("Byrne");
//
//            System.out.println("Select user by last name: " + list );
//        }
//        catch( DaoException e )
//        {
//            e.printStackTrace();
//        }

//
//
//    }
//}



