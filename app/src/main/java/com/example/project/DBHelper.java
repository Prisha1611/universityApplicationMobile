package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TABLE_USERDETAILS = "Userdetails";
    private static final String TABLE_COURSES = "Courses";
    private static final String TABLE_GRADES = "Grades"; // New table for grades

    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE " + TABLE_USERDETAILS + "(username INTEGER PRIMARY KEY, password TEXT)");
        DB.execSQL("CREATE TABLE " + TABLE_COURSES + "(courseId INTEGER PRIMARY KEY AUTOINCREMENT, studentId INTEGER, courseName VARCHAR(255), UNIQUE(studentId, courseName))");
        // Create the Grades table
        DB.execSQL("CREATE TABLE " + TABLE_GRADES + "(gradeId INTEGER PRIMARY KEY AUTOINCREMENT, studentId INTEGER, courseName VARCHAR(255), grade VARCHAR(10), UNIQUE(studentId, courseName))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_USERDETAILS);
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSES);
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_GRADES); // Drop the Grades table
        onCreate(DB);
    }

    public boolean insertUserData(int username, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = DB.insert("Userdetails", null, contentValues);
        DB.close();
        return result != -1;
    }

    public boolean insertCourse(int studentId, String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            Log.e("DBHelper", "Course name is invalid");
            return false;
        }

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("studentId", studentId);
        contentValues.put("courseName", courseName);

        try {
            long result = DB.insertOrThrow(TABLE_COURSES, null, contentValues);
            return result != -1;
        } catch (Exception e) {
            Log.e("DBHelper", "Error inserting course: " + e.getMessage(), e);
            return false;
        } finally {
            DB.close();
        }
    }

    public Cursor getAllCourses() {
        SQLiteDatabase DB = this.getReadableDatabase();
        return DB.rawQuery("SELECT * FROM " + TABLE_COURSES, null);
    }

    public boolean checkUserCredentials(int username, String password) {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM Userdetails WHERE username = ? AND password = ?", new String[]{String.valueOf(username), password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        DB.close();
        return exists;
    }

    public int getStudentIdByUsername(int username) {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT studentId FROM " + TABLE_USERDETAILS + " WHERE username = ?", new String[]{String.valueOf(username)});
        int studentId = -1; // Default value if the username is not found

        if (cursor.moveToFirst()) {
            studentId = cursor.getInt(0); // Get the integer value directly
        }

        cursor.close();
        DB.close();

        return studentId;
    }


    public List<StudentCourse> getStudentCourses(int studentUsername) {
        List<StudentCourse> studentCourses = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to retrieve student ID and course names
        Cursor cursor = db.rawQuery("SELECT studentId, courseName FROM " + TABLE_COURSES + " WHERE studentId = ?", new String[]{String.valueOf(studentUsername)});

        while (cursor.moveToNext()) {
            int studentId = cursor.getInt(cursor.getColumnIndexOrThrow("studentId"));
            String courseName = cursor.getString(cursor.getColumnIndexOrThrow("courseName"));
            studentCourses.add(new StudentCourse(studentId, courseName));
        }

        cursor.close();
        db.close();

        return studentCourses;
    }




    public void insertGrade(int studentId, String courseName, String grade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("studentId", studentId);
        contentValues.put("courseName", courseName);
        contentValues.put("grade", grade);
        db.insertOrThrow(TABLE_GRADES, null, contentValues); // Insert into the Grades table
        db.close();
    }
}