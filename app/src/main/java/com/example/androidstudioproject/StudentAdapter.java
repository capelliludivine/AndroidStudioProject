package com.example.androidstudioproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;

import com.example.androidstudioproject.model.Student;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.c_student, null);

        TextView textViewName=convertView.findViewById(R.id.textViewName);
        ImageView imageView=convertView.findViewById(R.id.imageViewStudent);

        Student student=getItem(position);

        textViewName.setText(student.getName());
        int identifier = getContext().getResources().getIdentifier(student.getPicture(), "drawable", getContext().getPackageName());
        imageView.setImageResource(identifier);


        return convertView;
    }

}
