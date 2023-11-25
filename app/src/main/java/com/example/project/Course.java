package com.example.project;

public class Course {
    private int studentId;
    private String courseName;

    // Constructor
    public Course(int studentId, String courseName) {
        this.studentId = studentId;
        this.courseName = courseName;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    // Setters (if needed)
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
