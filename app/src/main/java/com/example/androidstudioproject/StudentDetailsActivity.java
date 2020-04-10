package com.example.androidstudioproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;



import com.example.androidstudioproject.model.Student;

public class StudentDetailsActivity extends MainActivity {
    private Student student;

    public static void display(MainActivity activity, Student student){
        Intent intent=new Intent(activity,StudentDetailsActivity.class);
        intent.putExtra("student",student);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        showBackBtn();
        student = (Student) getIntent().getExtras().get("student");
        TextView textName = findViewById(R.id.textViewNameDetails);
        TextView textEmail = findViewById(R.id.textViewEmailDetails);
        ImageView imageViewDetails= findViewById(R.id.imageViewStudentDetails);

        textName.setText(student.getName());
        textEmail.setText(student.getEmail());
        int identifier = getResources().getIdentifier(student.getPicture(), "drawable", getPackageName());
        imageViewDetails.setImageResource(identifier);
        setTitle(student.getName());

    }
}
