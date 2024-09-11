package com.example.androidjava.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidjava.Adapter.PopularListAdapter;
import com.example.androidjava.DBContext.connectionDB;
import com.example.androidjava.Domain.PopularDomain;
import com.example.androidjava.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recyclerViewPupolar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottom_navigation();
    }

    private void bottom_navigation() {

        LinearLayout homeBtn = findViewById(R.id.homebtn);
        LinearLayout cartBtn = findViewById(R.id.cartbtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Apple MacBook Air M2 2022", "Macbook Air M3 13 inch 2024 16GB 256GB được trang bị con chip Apple M3 bao gồm 4 lõi hiệu suất cao, 4 lõi tiết kiệm điện cùng GPU 10 nhân", "pic1", 15, 20, 500 ));
        items.add(new PopularDomain("Bàn phím cơ không dây AULA F75", "Bàn phím cơ không dây AULA F75 Reaper Switch là một sản phẩm với độ bền lên đến 60 triệu lần bấm và kết nối qua dây Type-C, không dây 2.4G hoặc Bluetooth.", "pic2", 16, 17, 450));
        items.add(new PopularDomain("iPhone 14 128GB", "iPhone 14 128GB sở hữu màn hình Retina XDR OLED kích thước 6.1 inch cùng độ sáng vượt trội lên đến 1200 nits. ","pic3", 13, 30, 800));

        recyclerViewPupolar= findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPupolar= new PopularListAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }
}

