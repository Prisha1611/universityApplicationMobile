package com.example.project;

import java.util.List;

public class StudentReport {
    private int studentId;
    private String studentName;
    private String major;
    private List<CourseGrade> courseGrades;

    // Constructor
    public StudentReport(int studentId, String studentName, String major, List<CourseGrade> courseGrades) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.major = major;
        this.courseGrades = courseGrades;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getMajor() {
        return major;
    }

    public List<CourseGrade> getCourseGrades() {
        return courseGrades;
    }

    // Setters (if needed)
    // ...
}
