package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity4 extends AppCompatActivity {
    Button buttonSave, buttonHome;
    private DBHelper dbHelper;
    private EditText editTextName, editTextId, editTextMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        buttonSave = findViewById(R.id.buttonSave);
        buttonHome = findViewById(R.id.buttonHome);
        dbHelper = new DBHelper(this);
        editTextName = findViewById(R.id.editTextText);
        editTextId = findViewById(R.id.editTextText2);
        editTextMajor = findViewById(R.id.editTextText3);

        int currentStudentId = getCurrentStudentId(); // Assuming this method is correctly implemented
        StudentDetails studentDetails = dbHelper.getStudentDetails(currentStudentId);

        if (studentDetails != null) {
            editTextName.setText(studentDetails.getStudentName());
            editTextId.setText(String.valueOf(studentDetails.getStudentId()));
            editTextMajor.setText(studentDetails.getMajor());
        }

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the home page (assuming MainActivity2 is the home page)
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
                finish(); // Prevent going back to this activity when pressing back button
            }
        });

        // Uncomment and properly integrate the spinner if needed
        /*
        Spinner semesterSpinner = findViewById(R.id.semesterSpinner);
        String[] semesterOptions = {"Spring", "Summer"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, semesterOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSpinner.setAdapter(adapter);
        */
    }

    private int getCurrentStudentId() {
        // Implement logic to retrieve the current student's ID
        // Placeholder value
        return 662733;
    }
}
