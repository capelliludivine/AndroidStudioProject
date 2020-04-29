package com.example.androidstudioproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidstudioproject.model.Category;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(@NonNull Context context, int ressource, @NonNull List<Category> objects){
        super(context,ressource,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =  layoutInflater.inflate(R.layout.c_category, null);

        TextView textViewName=convertView.findViewById(R.id.textViewCategoryName);

        Category category = getItem(position);

        textViewName.setText(category.getTitle());

        return convertView;
    }
}
