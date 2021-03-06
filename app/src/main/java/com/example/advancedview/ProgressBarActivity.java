package com.example.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        progressBar = findViewById(R.id.progress3);
        btn1 = findViewById(R.id.progressBtn1);
        btn2 = findViewById(R.id.progressBtn2);
        btn3 = findViewById(R.id.progressBtn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.incrementProgressBy(5);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.incrementProgressBy(-5);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // progressBar.setProgress(80);
                for(int i=1; i<=100; i++) {
                    progressBar.setProgress(i);
                    SystemClock.sleep(10);
                }
            }
        });
    }
  
}
