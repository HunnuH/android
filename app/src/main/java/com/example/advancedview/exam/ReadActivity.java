package com.example.advancedview.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.advancedview.R;

public class ReadActivity extends AppCompatActivity {
TextView read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        read = findViewById(R.id.readtxt);
        Intent intent =getIntent();
        String product = intent.getStringExtra("name");
        read.setText(product);

    }
}