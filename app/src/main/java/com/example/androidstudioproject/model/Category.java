package com.example.androidstudioproject.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Category implements Serializable {

    private String title="";
    private String url="";

    public Category(JSONObject jsonObject){
        title=jsonObject.optString("title","");
        url=jsonObject.optString("products_url","");

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



}