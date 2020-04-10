package com.example.androidstudioproject.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Student implements Serializable {

    private String name="";
    private String email="";
    private String picture="";

    public Student(JSONObject jsonObject){
        name=jsonObject.optString("name","");
        email=jsonObject.optString("email","");
        picture=jsonObject.optString("picture","");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
