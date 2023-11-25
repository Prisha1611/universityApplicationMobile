package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Lecturer extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;

    Button addGradeButton;
    private DBHelper dbHelper; // Assuming DBHelper is your custom class for database handling

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);
        addGradeButton = findViewById(R.id.addGradeButton);
//        TextView studentIdTextView = findViewById(R.id.studentIdTextView);
//        studentIdTextView.setText(studentId);

        dbHelper = new DBHelper(this);
//        List<StudentCourse> studentCourses = dbHelper.getStudentCourses(662733);
        List<StudentCourse> studentCourses = dbHelper.getStudentCourses(662733);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter = new CourseAdapter(studentCourses);
        recyclerView.setAdapter(courseAdapter);

        addGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}