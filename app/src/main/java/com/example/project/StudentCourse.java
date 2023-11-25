package com.example.project;

public class StudentCourse {
        private int studentId;
        private String courseName;

        public StudentCourse(int studentId, String courseName) {
            this.studentId = studentId;
            this.courseName = courseName;
        }

        public int getStudentId() {
            return studentId;
        }

        public String getCourseName() {
            return courseName;
        }

}
