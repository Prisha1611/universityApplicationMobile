package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity6 extends AppCompatActivity {
    Button button11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        button11 = findViewById(R.id.button11);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
                // Finish the current activity to prevent going back to MainActivity2 when pressing the back button
                finish();
            }
        });
        // Assuming you have a reference to the Spinner in your activity
        Spinner semesterSpinner = findViewById(R.id.semesterSpinner);

        // Define an array of semester options
        String[] semesterOptions = {"Spring", "Summer"};

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, semesterOptions);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        semesterSpinner.setAdapter(adapter);
    }
}