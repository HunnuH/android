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
import android.widget.TextView;
import android.widget.Toast;

import com.example.advancedview.R;

public class HandelerExamActivity01 extends AppCompatActivity {
TextView han_txt;
Button han_btn;
Handler handler;
Handler msghandler;
int i;
int k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_exam);
        han_txt = findViewById(R.id.numView);
        han_btn = findViewById(R.id.msgbtn);
        handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                han_txt.setText(i+"");
                if(i==50) {
                    Toast.makeText(HandelerExamActivity01.this,"작업이완료되었습니다.",Toast.LENGTH_LONG).show();
                }
            }
        };
        msghandler = new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what==1) {
                    han_txt.setText(msg.arg1+"");
                    if(k==50) {
                        Toast.makeText(HandelerExamActivity01.this,"작업이완료되었습니다.",Toast.LENGTH_LONG).show();
                    }
                }

            }
        };

        han_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for( k=1; k<=50; k++) {
                            //변경할 뷰의 정보나 핸들러에게 전달할 데이터를 직접 메세지객체로 전달
                            Message msg = new Message();
                            msg.what = 1;//메세지 객체의 what은 핸들러에게 작업을 의뢰한 쓰레드를 구분하기 위한 값을 전달
                            msg.arg1 = k;//전달할 데이터
                            msghandler.sendMessage(msg);//메세지 객체를 전달하며 핸들러에게 작업을 의뢰
                            SystemClock.sleep(500);
                        }
                    }
                }).start();
            }
        });
    }

    public void btn_click(View v) {
        new hThread().start();
    }
       class hThread extends Thread {
            @Override
            public void run() {
                for( i=0; i<=50; i++) {
                    handler.sendMessage(handler.obtainMessage());
                    SystemClock.sleep(500);
                }
            }
        }


}