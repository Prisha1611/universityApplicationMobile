package com.example.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button studentloginButton, lecturerloginButton, adminloginButton, signupbutton;
    private EditText usernameEditText, passwordEditText;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the database helper
        dbHelper = new DBHelper(this);

        // Initialize views
        studentloginButton = findViewById(R.id.studentloginButton);
        lecturerloginButton = findViewById(R.id.lecturerloginButton);
        signupbutton = findViewById(R.id.signupButton);
//        adminloginButton = findViewById(R.id.adminloginButton);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        // Set onClick listener for student login
//        studentloginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String usernameStr = usernameEditText.getText().toString();
//                int username = Integer.parseInt(usernameStr);
//                String password = passwordEditText.getText().toString().trim();
//
//                boolean isValidUser = dbHelper.checkUserCredentials(username, password);
//                if (isValidUser) {
//                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
//                    startActivity(intent);
//
//                    // Optionally, navigate to main app screen
//                } else {
//                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        studentloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String usernameStr = usernameEditText.getText().toString().trim();
                    int studentId = Integer.parseInt(usernameStr); // Assuming the username is the student ID
                    String password = passwordEditText.getText().toString().trim();

                    boolean isValidUser = dbHelper.checkUserCredentials(studentId, password);
                    if (isValidUser) {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid student ID format", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lecturerloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LecturerDashboard.class);
                startActivity(intent);
            }
        });
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signUp.class);
                startActivity(intent);
            }
        });

        // Other button click listeners...
        // Add similar functionality for lecturerloginButton and adminloginButton if needed
    }

    private boolean authenticateStudent(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = { "username" }; // Adjust column names based on your database schema
        String selection = "username =? AND password =?"; // Adjust column names based on your database schema
        String[] selectionArgs = { username, password };

        Cursor cursor = db.query("students", columns, selection, selectionArgs, null, null, null); // Replace "students" with your actual table name
        boolean isAuthenticated = cursor.getCount() > 0;
        cursor.close();
        return isAuthenticated;
    }



}
