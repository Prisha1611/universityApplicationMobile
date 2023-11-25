package com.example.project;

public class CourseInfo {
    private int studentId;
    private String courseName;

    public CourseInfo(int studentId, String courseName) {
        this.studentId = studentId;
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getStudentId() {
        return studentId;
    }
}
