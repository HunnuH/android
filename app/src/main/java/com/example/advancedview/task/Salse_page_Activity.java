package com.example.advancedview.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.advancedview.R;

public class Salse_page_Activity extends AppCompatActivity {
    Button sal_menu;
    Button sal_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sales_page);
        sal_menu = findViewById(R.id.sales_menu_btn);
        sal_login = findViewById(R.id.sales_login_btn);

        sal_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Salse_page_Activity.this, Main_menuActivity.class);
                intent.putExtra("매출관리-메뉴화면", "매출관리-메뉴화면");
                startActivity(intent);
            }
        });
        sal_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Salse_page_Activity.this, LoginActivity.class);
                intent.putExtra("매출관리-로그인화면", "매출관리-로그인화면");
                startActivity(intent);
            }
        });

    }
}