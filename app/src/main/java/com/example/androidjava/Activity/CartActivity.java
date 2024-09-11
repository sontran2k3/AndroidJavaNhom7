package com.example.androidjava.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidjava.Adapter.CartListAdapter;
import com.example.androidjava.Helper.ChangeNumberItemsListener;
import com.example.androidjava.Helper.ManagmentCart;
import com.example.androidjava.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ManagmentCart managmentCart;
    private TextView totaFeetxt, taxtxt, deliverytxt, totatxt, emtytxt;
    private double tax;
    private ScrollView scrollView;
    private ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managmentCart = new ManagmentCart(this);
        initView();
        setVariavle();
        initList();
        calcualteCart();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter =  new CartListAdapter(managmentCart.getListCart(), this, new ChangeNumberItemsListener(){
            @Override
            public void change(){
                calcualteCart();
            }
        });



        recyclerView.setAdapter(adapter);
        if(managmentCart.getListCart().isEmpty()){
            emtytxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.VISIBLE);
        }else{
            emtytxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calcualteCart() {
        double percentTax = 0.02;
        double delivery = 10;
        tax = Math.round((managmentCart.getTotalFee() * percentTax * 100.0)) / 100.0;

        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;

        totaFeetxt.setText("$" + itemTotal);
        taxtxt.setText("$" + tax);
        deliverytxt.setText("$" + delivery);
        totatxt.setText("$"+ total);
    }

    private void setVariavle() {
        btnBack.setOnClickListener(view -> finish());
    }

    private void initView() {
        totaFeetxt = findViewById(R.id.txtTotaiFee);
        taxtxt = findViewById(R.id.txtTax);
        deliverytxt = findViewById(R.id.txtDelivery);
        totatxt =  findViewById(R.id.txtTotal);
        recyclerView = findViewById(R.id.view3);
        scrollView= findViewById(R.id.scrollView2);
        btnBack = findViewById(R.id.btnBack);
        emtytxt = findViewById(R.id.txtEmpty);
    }
}