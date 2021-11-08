package com.example.advancedview.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.advancedview.R;
/*핸들러객체를 재 정의하면서 핸들러메세지를 오버라이딩해서 처리하하지 않고 핸들러 객체의
* 포스트메소드를  호출하며 UI를 변경하는 쓰레드를 직접만들어서 넘겨주는 방법*/
public class HandlerPostActivity extends AppCompatActivity {
    ImageView iv;
    Button btn1;
    Button btn2;
    TextView tv;
    Handler handler;
    Handler handler2;
    int num;
    int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_exam_post);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        iv = findViewById(R.id.imageView);
        tv = findViewById(R.id.numView);
        handler = new Handler(Looper.myLooper());
        handler2 = new Handler(Looper.myLooper());


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new numThread().start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new imgThread().start();
            }
        });
    }
    class  imgThread extends  Thread {
        @Override
        public void run() {
            for (int k=1; k<=10; k++) {
                img = k;

                handler2.post(new Runnable() {
                    @Override
                    public void run() {
                        if(img % 2 ==0) {
                           iv.setImageResource(R.drawable.leemin);
                        }else {
                            iv.setImageResource(R.drawable.yeona);
                        }
                    }
                });
                SystemClock.sleep(500);
            }
        }
    }

    //숫자를 만드는 쓰레드
    class  numThread extends Thread {
        @Override
        public void run() {
            for(int i=1; i<=10; i++) {
                num = i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(num+"");
                    }
                });
                SystemClock.sleep(500);
            }
        }
    }
}