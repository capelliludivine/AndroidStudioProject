package com.example.androidstudioproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.example.androidstudioproject.model.Category;

public class CategoryActivity extends MainActivity {

    private CategoryAdapter adapter;
    private ArrayList<Category> categories;

    public static void display(MainActivity activity){
        Intent intent=new Intent(activity, CategoryActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);
        categories=new ArrayList<>();
        showBackBtn();
        ListView listView=findViewById(R.id.listViewCategory);
        adapter = new CategoryAdapter(this, R.layout.c_category, categories);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductActivity.display(CategoryActivity.this,categories.get(position));
            }
        });

        String url="http://djemam.com/epsi/categories.json";
        new HttpAsyTask(url, new HttpAsyTask.HttpAsyTaskListener() {
            @Override
            public void webServiceDone(String result) {
                initData(result);
            }

            @Override
            public void webServiceError(Exception e) {
                displayToast(e.getMessage());
            }
        }).execute();
    }

    private void initData(String data) {
        try {
            JSONObject jsonObject;
            jsonObject=new JSONObject(data);
            JSONArray jsonArray=jsonObject.getJSONArray("items");
            for(int i=0;i<jsonArray.length();i++){
                Category category=new Category(jsonArray.getJSONObject(i));
                categories.add(category);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        displayToast(String.valueOf(categories.size()));
        adapter.notifyDataSetChanged();

    }
}
