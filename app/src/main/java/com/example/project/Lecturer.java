package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Lecturer extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    private DBHelper dbHelper; // Assuming DBHelper is your custom class for database handling

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);
//        TextView studentIdTextView = findViewById(R.id.studentIdTextView);
//        studentIdTextView.setText(studentId);

        dbHelper = new DBHelper(this);
        List<StudentCourse> studentCourses = dbHelper.getStudentCourses(); // Use the new method

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter = new CourseAdapter(studentCourses);
        recyclerView.setAdapter(courseAdapter);
    }
}
