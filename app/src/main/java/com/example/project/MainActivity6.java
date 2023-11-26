package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {
    Button button11;
    private Spinner semesterSpinner;
    private DBHelper dbHelper;
    private int currentStudentId = 662733;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        button11 = findViewById(R.id.button11);
        dbHelper = new DBHelper(this);
        TextView textViewStudentId = findViewById(R.id.textViewStudentId);
        textViewStudentId.setText(String.valueOf(currentStudentId));
        List<StudentCourse> studentCourses = dbHelper.getStudentCourses(currentStudentId);
        List<String> courseNames = extractCourseNames(studentCourses);
        populateCourseEditTexts(courseNames);
//        List<String> courses = dbHelper.getAllCourseNames();
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        semesterSpinner.setAdapter(adapter);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
                // Finish the current activity to prevent going back to MainActivity2 when pressing the back button
                finish();
            }
        });
//        // Assuming you have a reference to the Spinner in your activity
//        Spinner semesterSpinner = findViewById(R.id.semesterSpinner);
//
//        // Define an array of semester options
//        String[] semesterOptions = {"Spring", "Summer"};
//
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, semesterOptions);
//
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // Apply the adapter to the spinner
//        semesterSpinner.setAdapter(adapter);
    }
    private void populateCourseEditTexts(List<String> courses) {
        EditText[] editTexts = {
                findViewById(R.id.editTextText4),
                findViewById(R.id.editTextText5),
                findViewById(R.id.editTextText6),
                findViewById(R.id.editTextText7),
                findViewById(R.id.editTextText8)
        };

        for (int i = 0; i < editTexts.length; i++) {
            if (i < courses.size()) {
                editTexts[i].setText(courses.get(i));
            } else {
                editTexts[i].setVisibility(View.GONE); // Hide unused EditTexts
            }
        }
    }
    private List<String> extractCourseNames(List<StudentCourse> studentCourses) {
        List<String> courseNames = new ArrayList<>();
        for (StudentCourse sc : studentCourses) {
            courseNames.add(sc.getCourseName()); // Assuming StudentCourse has a getCourseName method
        }
        return courseNames;
    }
}