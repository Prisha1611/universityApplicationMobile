package com.example.project;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Report extends AppCompatActivity {

    private ListView listView;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report); // Replace with your layout file

        listView = findViewById(R.id.listView); // Replace with your ListView ID
        dbHelper = new DBHelper(this);

        List<StudentCourseGrade> data = dbHelper.getStudentCourseGrades();
        List<String> displayList = new ArrayList<>();
        for (StudentCourseGrade scg : data) {
            displayList.add("ID: " + scg.studentId + ", Name: " + scg.studentName + ", Course: " + scg.courseName + ", Grade: " + scg.grade);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter);
    }
}
