package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    DBHelper db;
    EditText studentIdEditText, course1EditText, course2EditText, course3EditText, course4EditText, course5EditText;
    Button registerButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        db = new DBHelper(this);
        studentIdEditText = findViewById(R.id.studentIdEditText);
        course1EditText = findViewById(R.id.course1EditText);
        course2EditText = findViewById(R.id.course2EditText);
        course3EditText = findViewById(R.id.course3EditText);
        course4EditText = findViewById(R.id.course4EditText);
        course5EditText = findViewById(R.id.course5EditText);
        registerButton = findViewById(R.id.registerButton);
        logoutButton = findViewById(R.id.logoutButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerCourses();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Logout successful", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void registerCourses() {
        int studentId;
        try {
            studentId = Integer.parseInt(studentIdEditText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid Student ID", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] courses = new String[]{
                course1EditText.getText().toString(),
                course2EditText.getText().toString(),
                course3EditText.getText().toString(),
                course4EditText.getText().toString(),
                course5EditText.getText().toString()
        };

        for (String course : courses) {
            if (!course.isEmpty()) {
                boolean isRegistered = db.insertCourse(studentId, course);
                if (isRegistered) {
                    Toast.makeText(this, "Registered for course: " + course, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Failed to register for course: " + course, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
