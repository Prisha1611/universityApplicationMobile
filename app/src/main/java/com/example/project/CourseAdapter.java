////package com.example.project;
////import android.view.LayoutInflater;
////import android.view.View;
////import android.view.ViewGroup;
////import android.widget.TextView;
////import androidx.annotation.NonNull;
////import androidx.recyclerview.widget.RecyclerView;
////import java.util.List;
////
////public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
////    private List<StudentCourse> courseList;
////
////    public CourseAdapter(List<StudentCourse> courseList) {
////        this.courseList = courseList;
////    }
////
////    @NonNull
////    @Override
////    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
////        return new CourseViewHolder(view);
////    }
////
////    @Override
////    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
////        StudentCourse course = courseList.get(position);
////        holder.bind(course);
////    }
////
////    @Override
////    public int getItemCount() {
////        return courseList.size();
////    }
////
////    public class CourseViewHolder extends RecyclerView.ViewHolder {
////        private TextView courseNameTextView;
////        private TextView studentIdTextView;
////
////        public CourseViewHolder(@NonNull View itemView) {
////            super(itemView);
////            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
//////            studentIdTextView = itemView.findViewById(R.id.studentIdTextView);
////        }
////
////        public void bind(StudentCourse course) {
////            courseNameTextView.setText(course.getCourseName());
//////            studentIdTextView.setText(course.getStudentId());
////
////        }
////    }
////}
//
package com.example.project;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private List<StudentCourse> courseList;

    public CourseAdapter(List<StudentCourse> courseList) {
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        StudentCourse course = courseList.get(position);
        holder.bind(course);
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        private TextView courseNameTextView;
        private TextView studentIdTextView;

        private EditText gradeEditText;


        public int getStudentId() {
            try {
                return Integer.parseInt(studentIdTextView.getText().toString());
            } catch (NumberFormatException e) {
                Log.e("CourseAdapter", "Invalid student ID format", e);
                return -1;
            }
        }

        public String getCourseName() {
            return courseNameTextView.getText().toString();
        }

        public String getGrade() {
            return gradeEditText.getText().toString();
        }
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
            studentIdTextView = itemView.findViewById(R.id.studentIdTextView);
            gradeEditText = itemView.findViewById(R.id.courseGradeEditText);
        }

        public void bind(StudentCourse course) {
            courseNameTextView.setText(course.getCourseName());
            studentIdTextView.setText(String.valueOf(course.getStudentId()));
            // Ensure getStudentId() returns an int or convert it to String
        }
    }
}

//package com.example.project;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
//    private List<StudentCourse> courseList;
//
//    public CourseAdapter(List<StudentCourse> courseList) {
//        this.courseList = courseList;
//    }
//
//    @NonNull
//    @Override
//    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
//        return new CourseViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
//        StudentCourse course = courseList.get(position);
//        holder.bind(course);
//    }
//
//    @Override
//    public int getItemCount() {
//        return courseList.size();
//    }
//
//    public class CourseViewHolder extends RecyclerView.ViewHolder {
//        private TextView courseNameTextView;
//        private TextView studentIdTextView;
//
//        public CourseViewHolder(@NonNull View itemView) {
//            super(itemView);
//            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
////            studentIdTextView = itemView.findViewById(R.id.studentIdTextView);
//        }
//
//        public void bind(StudentCourse course) {
//            courseNameTextView.setText(course.getCourseName());
////            studentIdTextView.setText(course.getStudentId());
//
//        }
//    }
//}

//        package com.example.project;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
//    private List<StudentCourse> courseList;
//
//    public CourseAdapter(List<StudentCourse> courseList) {
//        this.courseList = courseList;
//    }
//
//    @NonNull
//    @Override
//    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
//        return new CourseViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
//        StudentCourse course = courseList.get(position);
//        holder.bind(course);
//    }
//
//    @Override
//    public int getItemCount() {
//        return courseList.size();
//    }
//
//    public class CourseViewHolder extends RecyclerView.ViewHolder {
//        private TextView courseNameTextView;
//        private TextView studentIdTextView;
//
////        private TextView gradeEditText;
//        // gradeEditText = itemView.findViewById(R.id.gradeEditText);
//
//        public CourseViewHolder(@NonNull View itemView) {
//            super(itemView);
//            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
//            studentIdTextView = itemView.findViewById(R.id.studentIdTextView);
//
//        }
//
//        public void bind(StudentCourse course) {
//            courseNameTextView.setText(course.getCourseName());
//            studentIdTextView.setText(String.valueOf(course.getStudentId()));
//            // Ensure getStudentId() returns an int or convert it to String
//        }
//    }
//}
