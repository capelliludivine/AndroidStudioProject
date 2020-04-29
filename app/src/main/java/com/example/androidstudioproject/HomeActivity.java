package com.example.androidstudioproject;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class HomeActivity extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);
        findViewById(R.id.ListeDEtudiant).setOnClickListener(this);
        findViewById(R.id.ListeDeRayon).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ListeDEtudiant:
                StudentsActivity.display(HomeActivity.this);
                break;
            case R.id.ListeDeRayon:
                CategoryActivity.display(HomeActivity.this);
                break;
        }
    }
}