package com.example.advancedview.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.advancedview.R;

public class HandlerExamActivity02 extends AppCompatActivity {
    ImageView iv;
    Button btn1;
    Button btn2;
    TextView tv;
    ProgressBar pb;
    Handler handler;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_exam2);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn2.setEnabled(false);
        iv = findViewById(R.id.imageView);
        tv = findViewById(R.id.textView);
        pb = findViewById(R.id.progressBar);
        //d1.jpg를 액티비티가 실행되면 이미지뷰에 실행


        handler = new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                pb.setProgress(msg.what);
                pb.incrementProgressBy(1);
                tv.setText("진행률 : "+msg.arg1+"%");
                if(msg.what==1) {
                    if (msg.arg1 % 2 == 0) {
                        iv.setImageResource(R.drawable.d1);
                    } else {
                        iv.setImageResource(R.drawable.d2);
                    }
                }
            }
        };

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (i=1; i<=100; i++) {
                            Message msg = new Message();
                            msg.what = 1;
                            msg.arg1 = i;
                            handler.sendMessage(msg);
                            SystemClock.sleep(500);
                        }
                    }
                }).start();
            }
        });
    }

}