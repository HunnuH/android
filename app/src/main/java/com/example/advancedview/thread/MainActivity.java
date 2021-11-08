package com.example.advancedview.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.advancedview.R;


public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    int progressVal;//프로그래스바의 값을 저장하는 변수
    Handler handler1;
    Handler handler2;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.threadmain);
        progressBar =  findViewById(R.id.progressBar);
        textView =   findViewById(R.id.textView);
        //Looper는 쓰레드의 메시지를 관리하는 안드로이드 객체
        //Looper는 쓰레드로부터 메시지가 도착하면 해당 메시지를 핸들러한테 전달하는 역활을 한다.
        //Looper가 작업 요청을 기다리고 있다가  작업에 대한 요처이 들어오면 작업을 처리하는 일을 담당
        handler1 = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                //Log.d("yyy","handleMessage()");
                progressBar.incrementProgressBy(1);
                textView.setText("progressbar진행률 : "+progressBar+"%");
            }
        };
    }
  /*화면을 변경하는 작업을 다른 메소드에서 처리
  * 긴 시간동안 실행하면서 view를 변경하려고 하는경우 실행되는 동안 다른 작업을 할수없다
  * 실행되는 동안 안드로이드 내부에서 이벤트가 발생하고 발생한 이벤트에 대하여 5초동안 반응하지 않으면 안드로이드os는 어플을 강제종료한다
  * ANR(Application Not Responding
  * 시간이 오래걸리는 작업은 UI쓰레드에서 처리하면 안된다.*/
    public void btnNoThread(View view){
       for(progressVal=1; progressVal<100; progressVal++) {
           progressBar.setProgress(progressVal);
           SystemClock.sleep(1000);//1초동안 쉬게
       }
    }
   //개발자가 만든 쓰레드 내부에서  UI를 변경
    //잠정적인 문제점을 갖고 있는 방법
    //UI변경은 UI쓰레드에서만 작업
    public void useThread(View view){
        //사용자가 만드는 작업 쓰레드 -worker쓰레드
        //프로그래스바에서 진행상태가 출력
     Thread t1 =  new Thread(new Runnable() {
           @Override
           public void run() {
               for(progressVal=1; progressVal<100; progressVal++) {
                   progressBar.setProgress(progressVal);
                   textView.setText("progressbar진행률 : "+ progressVal+"%");
                   SystemClock.sleep(1000);//1초동안 쉬게
               }
           }
       });
             t1.start();
    }
    //핸들러객체를 통해 view에 대한 변경을 요청하기
    //핸들러 객체는  작업 쓰레드로 부터 받은 요청을 꺼내서 뷰를 변경하는 작업을 진행
    public void useHandler(View view){
        //작업시간이 긴 경우 쓰레드로 구현
        //핸들러에게 의뢰
        new Thread(new MyThread()).start();
    }

    public void useMessageHandler(View view){
        
    }
    class MyThread implements  Runnable{
        @Override
        public void run() {
            for(progressVal=1; progressVal<100; progressVal++) {
              //handler가 갖고있는 Message객체를 매개변수로 전달하면서 작업을 의뢰
                //핸들러가 갖고있는 기본 메시지객체를 접근할수 있다.
                //핸들러 객체의 sendmessage를 호출하면 핸들러에게 메시지를 전송
                //메시지가 전송되면 핸들러 객체의 handlemassage가 호출
                handler1.sendMessage(handler1.obtainMessage());
                SystemClock.sleep(1000);//1초동안 쉬게
            }
        }
    }
}







