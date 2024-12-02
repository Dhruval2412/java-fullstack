package net.jsp.model;

import java.time.LocalDate;

public class student {
    private String rollno;
    private String fname;
    private String lname;
    private LocalDate dob; // Changed from String to LocalDate

    // Default constructor
    public student() {
        // No initialization needed here
    }

    // Parameterized constructor
    public student(String rollno, String fname, String lname, LocalDate dob) {
        this.rollno = rollno;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    // Getter and Setter for rollno
    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    // Getter and Setter for fname
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    // Getter and Setter for lname
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    // Getter and Setter for dob
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno='" + rollno + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", dob=" + dob +
                '}';
    }
}