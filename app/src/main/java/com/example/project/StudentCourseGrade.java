
package com.example.project; // Adjust the package name as per your project's structure
public class StudentCourseGrade {
    public int studentId;
    public String studentName;
    public String courseName;
    public String grade;

    public StudentCourseGrade(int studentId, String studentName, String courseName, String grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.grade = grade;
    }

    // Optionally, you can add getter and setter methods for each field
    // e.g., public int getStudentId() { return studentId; }

    // And other utility methods as needed
}

