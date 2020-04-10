package com.example.androidstudioproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.example.androidstudioproject.model.Student;

public class StudentsActivity extends MainActivity {

    private String data=" {\"items\": [{\"picture\": \"@drawable/ludi\",\"name\": \"CAPELLI Ludivine\",\"email\": \"ludivine.capelli@g-mail.fr\"},{\"picture\": \"@drawable/ame\",\"name\": \"CAPELLI Amélie\",\"email\": \"amelie.capelli@g-mail.fr\"},{\"picture\": \"@drawable/ludo\",\"name\": \"GENDRE Ludovic\",\"email\": \"ludovic.gendre@g-mail.fr\"},{\"picture\": \"@drawable/lilian\",\"name\": \"GENDRE Lilian\",\"email\": \"lilian.gendre@g-mail.fr\"},{\"picture\": \"@drawable/al\",\"name\": \"DOMPEYRE Anne-Laure\",\"email\": \"annelaure.dompeyre@g-mail.fr\"},{\"picture\": \"@drawable/ju\",\"name\": \"BOCAGE Julien\",\"email\": \"julien.bocage@g-mail.fr\"}]}]}";
    private ArrayList<Student> students;

    public static void display( MainActivity activity){
        Intent intent=new Intent(activity, StudentsActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_name);
        showBackBtn();
        initData();
        ListView listView=findViewById(R.id.listViewStudents);
        StudentAdapter adapter=new StudentAdapter(this,R.layout.c_student,students);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentDetailsActivity.display(StudentsActivity.this,students.get(position));
            }
        });
    }


    private void initData() {
        students=new ArrayList<>();
        try {
            JSONObject jsonObject;
            jsonObject=new JSONObject(data);
            JSONArray jsonArray=jsonObject.getJSONArray("items");
            for(int i=0;i<jsonArray.length();i++){
                Student student=new Student(jsonArray.getJSONObject(i));
                students.add(student);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        displayToast(String.valueOf(students.size()));
    }
}
