package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Lecturer extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;

    Button addGradeButton,deleteButton,updateButton;
    private DBHelper dbHelper; // Assuming DBHelper is your custom class for database handling

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);
        addGradeButton = findViewById(R.id.addGradeButton);
        deleteButton = findViewById(R.id.deleteButton);
        updateButton = findViewById(R.id.updateButton);
//        TextView studentIdTextView = findViewById(R.id.studentIdTextView);
//        studentIdTextView.setText(studentId);

        dbHelper = new DBHelper(this);
//        List<StudentCourse> studentCourses = dbHelper.getStudentCourses(662733);
        List<StudentCourse> studentCourses = dbHelper.getStudentCourses(662255);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter = new CourseAdapter(studentCourses);
        recyclerView.setAdapter(courseAdapter);

        addGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGradesToDatabase();
            }
        });
//        updateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
////            public void onClick(View v) {
////                updateGradesInDatabase();
////            }
//        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteGradesFromDatabase();
            }
        });
    }
    private void addGradesToDatabase() {
        for (int i = 0; i < courseAdapter.getItemCount(); i++) {
            CourseAdapter.CourseViewHolder holder = (CourseAdapter.CourseViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
            if (holder != null) {
                int studentId = holder.getStudentId();
                if (studentId == -1) {
                    Log.e("Lecturer", "Invalid student ID for position: " + i);
                    continue; // Skip if student ID is invalid
                }
                String courseName = holder.getCourseName();
                String grade = holder.getGrade();

                boolean insertedOrUpdated = dbHelper.insertOrUpdateGrade(studentId, courseName, grade);
                if (insertedOrUpdated) {
                    Toast.makeText(Lecturer.this, "Grade updated successfully for student ID: " + studentId, Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("Lecturer", "Failed to insert or update grade for student ID: " + studentId);
                }
            } else {
                Log.e("Lecturer", "ViewHolder for position " + i + " is null");
            }
        }
    }



//    private void updateGradesInDatabase() {
//        for (int i = 0; i < courseAdapter.getItemCount(); i++) {
//            CourseAdapter.CourseViewHolder holder = (CourseAdapter.CourseViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
//            if (holder != null) {
//                int studentId = holder.getStudentId();
//                if (studentId == -1) {
//                    Log.e("Lecturer", "Invalid student ID for position: " + i);
//                    continue; // Skip if student ID is invalid
//                }
//                String courseName = holder.getCourseName();
//                String grade = holder.getGrade();
//
//                boolean updated = dbHelper.updateGrade(studentId, courseName, grade);
//                if (updated) {
//                    Toast.makeText(Lecturer.this, "Grade updated successfully for student ID: " + studentId, Toast.LENGTH_SHORT).show();
//                } else {
//                    Log.e("Lecturer", "Failed to update grade for student ID: " + studentId);
//                }
//            } else {
//                Log.e("Lecturer", "ViewHolder for position " + i + " is null");
//            }
//        }
//    }

//    private void updateGradesInDatabase() {
//        for (int i = 0; i < courseAdapter.getItemCount(); i++) {
//            CourseAdapter.CourseViewHolder holder = (CourseAdapter.CourseViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
//            if (holder != null) {
//                int studentId = holder.getStudentId();
//                if (studentId == -1) {
//                    Log.e("Lecturer", "Invalid student ID for position: " + i);
//                    continue; // Skip if student ID is invalid
//                }
//                String courseName = holder.getCourseName();
//                String grade = holder.getGrade();
//
//                boolean updated = dbHelper.updateGrade(studentId, courseName, grade);
//                if (updated) {
//                    Toast.makeText(Lecturer.this, "Grade updated successfully for student ID: " + studentId, Toast.LENGTH_SHORT).show();
//                } else {
//                    Log.e("Lecturer", "Failed to update grade for student ID: " + studentId);
//                }
//            } else {
//                Log.e("Lecturer", "ViewHolder for position " + i + " is null");
//            }
//        }
//    }

    private void deleteGradesFromDatabase() {
        for (int i = 0; i < courseAdapter.getItemCount(); i++) {
            CourseAdapter.CourseViewHolder holder = (CourseAdapter.CourseViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
            if (holder != null) {
                int studentId = holder.getStudentId();
                if (studentId == -1) {
                    Log.e("Lecturer", "Invalid student ID for position: " + i);
                    continue; // Skip if student ID is invalid
                }
                String courseName = holder.getCourseName();

                boolean deleted = dbHelper.deleteGrade(studentId, courseName);
                if (deleted) {
                    Toast.makeText(Lecturer.this, "Grade deleted successfully for student ID: " + studentId, Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("Lecturer", "Failed to delete grade for student ID: " + studentId);
                }
            } else {
                Log.e("Lecturer", "ViewHolder for position " + i + " is null");
            }
        }
    }








//    private void addGradesToDatabase() {
//        for (int i = 0; i < courseAdapter.getItemCount(); i++) {
//            CourseAdapter.CourseViewHolder holder = (CourseAdapter.CourseViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
//            if (holder != null) {
//                int studentId = holder.getStudentId();
//                if (studentId == -1) {
//                    Log.e("Lecturer", "Invalid student ID for position: " + i);
//                    continue; // Skip if student ID is invalid
//                }
//                String courseName = holder.getCourseName();
//                String grade = holder.getGrade();
//
//                boolean insertedOrUpdated = dbHelper.insertOrUpdateGrade(studentId, courseName, grade);
//                if (!insertedOrUpdated) {
//                    Log.e("Lecturer", "Failed to insert or update grade for student ID: " + studentId);
//                }
//            } else {
//                Log.e("Lecturer", "ViewHolder for position " + i + " is null");
//            }
//        }
//    }

//    private void addGradesToDatabase() {
//        for (int i = 0; i < courseAdapter.getItemCount(); i++) {
//            CourseAdapter.CourseViewHolder holder = (CourseAdapter.CourseViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
//            if (holder != null) {
//                int studentId = holder.getStudentId();
//                if (studentId == -1) {
//                    continue; // Skip if student ID is invalid
//                }
//                String courseName = holder.getCourseName();
//                String grade = holder.getGrade();
//                boolean inserted = dbHelper.insertGrade(studentId, courseName, grade);
//                if (!inserted) {
//                    Log.e("Lecturer", "Failed to insert grade for student ID: " + studentId);
//                }
//            } else {
//                Log.e("Lecturer", "ViewHolder for position " + i + " is null");
//            }
//        }
//    }
//

}