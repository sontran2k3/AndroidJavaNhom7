package com.example.androidjava.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.androidjava.Domain.PopularDomain;
import com.example.androidjava.Helper.ManagmentCart;
import com.example.androidjava.R;

public class DetailActivity extends AppCompatActivity {
    private Button btnAddToCart;
    private TextView txtTitle, txtFee, txtDescription, txtReview, txtScore;
    private ImageView picItem, btnBack;
    private PopularDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmenttCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managmenttCart = new ManagmentCart(this);

        initView();
        getBundle();
    }

    private void getBundle() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());

        Glide.with(this).load(drawableResourceId).into(picItem);

        txtTitle.setText(object.getTitle());
        txtFee.setText("$"+object.getPrice());
        txtDescription.setText(object.getDescription());
        txtReview.setText(object.getVeview()+ "");
        txtScore.setText(object.getScore()+"");


        btnAddToCart.setOnClickListener(view -> {
            object.setNumberrinCart(numberOrder);
            managmenttCart.insertFood(object);
        });
        btnBack.setOnClickListener(view -> finish());
    }

    private void initView() {
        btnAddToCart = findViewById(R.id.btnAddToCart);
        txtFee = findViewById(R.id.txtPrice);
        txtTitle = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.txtDescription);
        picItem = findViewById(R.id.itemPic);
        txtReview = findViewById(R.id.txtreview);
        txtScore = findViewById(R.id.txtScore);
        btnBack = findViewById(R.id.btnBack);
    }


}