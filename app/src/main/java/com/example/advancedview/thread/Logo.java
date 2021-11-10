package com.example.advancedview.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.advancedview.R;

public class Logo extends AppCompatActivity {
    Handler handler;
    //2초후에 처리해야할 작업 쓰레드로 작업
    Runnable delayThread = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(Logo.this, HandlerPostActivity.class);
            startActivity(intent);
            finish();

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        handler = new Handler(Looper.myLooper());
        handler.postDelayed(delayThread,2000);
    }
}