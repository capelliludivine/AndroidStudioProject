package com.example.androidstudioproject.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Student implements Serializable {

    private String name="";
    private String email="";
    private String groupe="";
    private String picture="";
    private String URL="";

    public Student(JSONObject jsonObject){
        name=jsonObject.optString("name","");
        email=jsonObject.optString("email","");
        groupe=jsonObject.optString("groupe","");
        picture=jsonObject.optString("picture","");
        URL=jsonObject.optString("URL","");
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

    public String getGroupe() {
        return groupe;
    }

    public String getPicture() {
        return picture;
    }

    public String getURL() {
        return URL;
    }

}
