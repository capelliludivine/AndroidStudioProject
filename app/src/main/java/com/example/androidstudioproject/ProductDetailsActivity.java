package com.example.androidstudioproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.example.androidstudioproject.model.Product;

public class ProductDetailsActivity extends MainActivity{

    private Product product;

    public static void display(MainActivity mainactivity, Product product){
        Intent intent = new Intent(mainactivity, ProductDetailsActivity.class);
        intent.putExtra("product",product);
        mainactivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        showBackBtn();

        product = (Product) getIntent().getExtras().get("product");

        ImageView imageViewProduct = findViewById(R.id.imageViewProduct);
        Picasso.get().load(product.getImageUrl()).into(imageViewProduct);

        TextView textViewDescription = findViewById(R.id.DescriptionProduct);
        textViewDescription.setText(product.getDescription());



    }

}
