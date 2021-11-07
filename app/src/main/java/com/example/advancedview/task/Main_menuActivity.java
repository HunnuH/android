package com.example.advancedview.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.advancedview.R;

public class Main_menuActivity extends AppCompatActivity {
    Button client;
    Button sales;
    Button product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        client = findViewById(R.id.client_btn);
        sales = findViewById(R.id.sales_btn);
        product = findViewById(R.id.product_btn);

        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_menuActivity.this, Client_page_Activity.class);
                intent.putExtra("고객관리화면", "고객관리화면");
               // String clientdata = intent.getStringExtra("고객 관리 페이지입니다.");
               // Toast.makeText(Main_menuActivity.this,clientdata, Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_menuActivity.this, Salse_page_Activity.class);
                String salesdata = intent.getStringExtra("매출 관리 페이지입니다.");
               // Toast.makeText(Main_menuActivity.this,salesdata, Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
       product.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Main_menuActivity.this, Product_page_Activity.class);
               String productdata = intent.getStringExtra("상품 관리 페이지입니다.");
               //Toast.makeText(Main_menuActivity.this,productdata, Toast.LENGTH_LONG).show();
               startActivity(intent);
           }
       });
    }
}