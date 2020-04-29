package com.example.androidstudioproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import com.example.androidstudioproject.model.Product;

public class ProductAdapter extends ArrayAdapter<Product> {


    public ProductAdapter(@NonNull Context context, int ressource, @NonNull List<Product> objects){
        super(context,ressource,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =  layoutInflater.inflate(R.layout.c_list_product, null);

        TextView textViewNomProduit = convertView.findViewById(R.id.textViewNomProduit);
        TextView textViewDescription = convertView.findViewById(R.id.textViewDescription);
        ImageView imageViewProduct = convertView.findViewById(R.id.imageViewProduct);

        Product Product = getItem(position);

        textViewNomProduit.setText(Product.getName());
        textViewDescription.setText(Product.getDescription());
        Picasso.get().load(Product.getImageUrl()).into(imageViewProduct);


        return convertView;
    }
}
