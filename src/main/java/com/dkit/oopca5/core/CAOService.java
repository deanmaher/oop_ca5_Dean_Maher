package com.dkit.oopca5.core;

/* The CAOService class has constants to define all of the messages that are sent between the Client and Server
 */

public class CAOService
{
    public static final int PORT_NUM = 8080;
    public static final String HOSTNAME = "localhost";

    public static final String BREAKING_CHARACTER = "%%";

    public static final String REGISTER_COMMAND = "REGISTER";
    public static final String SUCCESSFUL_REGISTER = "REGISTERED";
    public static final String FAILED_REGISTER = "REG FAILED";

    public static final String LOGIN_COMMAND = "LOGIN";
    public static final String SUCCESSFUL_LOGIN = "LOGGED IN";
    public static final String FAILED_LOGIN = "LOGIN FAILED";

    public static final String DISPLAY_COURSE_COMMAND = "DISPLAY COURSE";
    public static final String SUCCESSFUL_DISPLAY_COURSE = "SUCCESSFUL DISPLAY COURSE";
    public static final String FAILED_DISPLAY_COURSE = "DISPLAY COURSE FAILED";

    public static final String DISPLAY_ALL_COMMAND = "DISPLAY ALL";
    public static final String SUCCESSFUL_DISPLAY_ALL = "SUCCESSFUL DISPLAY ALL";
    public static final String FAILED_DISPLAY_ALL = "DISPLAY ALL FAILED";

    public static final String DISPLAY_CURRENT_COMMAND = "DISPLAY CURRENT";
    public static final String SUCCESSFUL_DISPLAY_CURRENT = "SUCCESSFUL DISPLAY CURRENT";
    public static final String FAILED_DISPLAY_CURRENT= "DISPLAY CURRENT FAILED";

    public static final String UPDATE_CURRENT_COMMAND = "UPDATE CURRENT";
    public static final String SUCCESSFUL_UPDATE_CURRENT = "SUCCESSFUL UPDATE CURRENT";
    public static final String FAILED_UPDATE_CURRENT= "UPDATE CURRENT FAILED";
}
