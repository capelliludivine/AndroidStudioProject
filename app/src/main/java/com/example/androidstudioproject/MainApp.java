package com.example.androidstudioproject;

import android.app.Application;

public class MainApp extends Application {

    private String title="";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

