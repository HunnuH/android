package com.example.advancedview.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.advancedview.R;

public class Client_page_Activity extends AppCompatActivity {
    Button cli_menu;
    Button cli_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_page);
        cli_menu = findViewById(R.id.client_menu_btn);
        cli_login = findViewById(R.id.client_login_btn);

        cli_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Client_page_Activity.this, Main_menuActivity.class);
                intent.putExtra("고객관리-메뉴화면","고객관리-메뉴화면");
                startActivity(intent);
            }
        });
        cli_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Client_page_Activity.this, LoginActivity.class);
                intent.putExtra("고객관리-로그인화면","고객관리-로그인화면");
                startActivity(intent);
            }
        });

    }
}