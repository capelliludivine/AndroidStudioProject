package com.example.androidstudioproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.example.androidstudioproject.model.Category;
import com.example.androidstudioproject.model.Product;

public class ProductActivity extends MainActivity{

    private ArrayList<Product> product;
    private ProductAdapter adapter;

    public static void display(MainActivity mainactivity, Category category){
        Intent intent = new Intent(mainactivity, ProductActivity.class);
        intent.putExtra("categorie",category);
        mainactivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        Category category = (Category) getIntent().getExtras().get("categorie");
        product = new ArrayList<>();
        showBackBtn();

        setTitle(category.getTitle());
        ListView listView = findViewById(R.id.listViewProduct);
        adapter = new ProductAdapter(this,R.layout.c_list_product, product);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductDetailsActivity.display(ProductActivity.this,product.get(position));
            }
        });

        String url = category.getUrl();


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
                Product produit =new Product(jsonArray.getJSONObject(i));
                product.add(produit);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        displayToast(String.valueOf(product.size()));
        adapter.notifyDataSetChanged();
    }
}