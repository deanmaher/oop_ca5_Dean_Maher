package com.dkit.oopca5.server.DTOs;


import java.util.Objects;

public class Student {
    private String caoNumber;  // In the CAA system, cao number is unique identifier for student
    private String dateOfBirth; // yyyy-mm-dd
    private String password;    // min 8 characters


    // Copy Constructor
    // Copies the contents of a Student object argument into
    // a new Student object, and returns that new object (a clone)
    //
    public Student(Student student) {
        this.caoNumber = student.caoNumber;
        this.dateOfBirth = student.dateOfBirth;
        this.password = student.password;

    }

    public Student(String caoNumber, String dateOfBirth, String password) {
        this.caoNumber = caoNumber;
        this.dateOfBirth = dateOfBirth;
        this.password = password;

    }

    //public boolean verifyLoginCredentials( yyy-mm-dd, password);

    public String getCaoNumber() {
        return caoNumber;
    }

    public void setCaoNumber(String caoNumber) {
        this.caoNumber = caoNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dayOfBirth) {
        this.dateOfBirth = dayOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return caoNumber == student.caoNumber && Objects.equals(dateOfBirth, student.dateOfBirth) && Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caoNumber, dateOfBirth, password);
    }

    @Override
    public String toString() {
        return "Student{" +
                "caoNumber=" + caoNumber +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", password='" + password + '\'' +

                '}';
    }
}

