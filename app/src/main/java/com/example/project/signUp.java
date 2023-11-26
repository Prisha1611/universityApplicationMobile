package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {
    Button signUpButton, loginButton;
    EditText usernameEditText, passwordEditText;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        db = new DBHelper(this);
        usernameEditText = findViewById(R.id.usernameSignUpEditText);
        passwordEditText = findViewById(R.id.passwordSignUpEditText);
        signUpButton = findViewById(R.id.signUpButton);
        loginButton = findViewById(R.id.loginButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentName = ((EditText) findViewById(R.id.editTextStudentName)).getText().toString().trim();
                String major = ((EditText) findViewById(R.id.editTextMajor)).getText().toString().trim();
                String usernameStr = usernameEditText.getText().toString();
                int studentId; // Assuming username is the student ID

                try {
                    studentId = Integer.parseInt(usernameStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(signUp.this, "Invalid student ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                String password = passwordEditText.getText().toString().trim();

                if (studentName.isEmpty() || major.isEmpty() || password.isEmpty()) {
                    Toast.makeText(signUp.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isInserted = db.insertUserData(studentId, studentName, major, password);
                if (isInserted) {
                    Toast.makeText(signUp.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    // Optionally, navigate to login screen
                } else {
                    Toast.makeText(signUp.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


//        signUpButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String usernameStr = usernameEditText.getText().toString();
//                int username = Integer.parseInt(usernameStr);
//                String password = passwordEditText.getText().toString().trim();
//
//                boolean isInserted = db.insertUserData(username, password);
//                if (isInserted) {
//                    Toast.makeText(signUp.this, "User registered successfully", Toast.LENGTH_SHORT).show();
//                    // Optionally, navigate to login screen
//                } else {
//                    Toast.makeText(signUp.this, "Registration failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}