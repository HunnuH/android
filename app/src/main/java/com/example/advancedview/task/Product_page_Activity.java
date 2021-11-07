package com.example.advancedview.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.advancedview.R;

public class Product_page_Activity extends AppCompatActivity {
    Button pro_menu;
    Button pro_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_page);
        pro_menu = findViewById(R.id.product_menu_btn);
        pro_login = findViewById(R.id.product_login_btn);

        pro_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Product_page_Activity.this, Main_menuActivity.class);
                intent.putExtra("상품관리-메뉴화면","상품관리-메뉴화면");
                startActivity(intent);
            }
        });
        pro_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Product_page_Activity.this, LoginActivity.class);
                intent.putExtra("상품관리-로그인화면", "상품관리-메뉴화면");
                startActivity(intent);
            }
        });
    }
}