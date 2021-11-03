package com.example.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LifrCycleActivity extends AppCompatActivity {
    public  LifrCycleActivity() {
        Log.d("life", "생성자");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifr_cycle);
    }
    // 앱 실행시 - 생성자 - create - start - resume
    // 일시정지 - pause - stop
    // 일시 정지에서 빠져 나올때  -restart - start - resume
    // 앱 정지시 - pause - stop - destroy
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life", "onStart호출");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("life", "onResume호출");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("life", "onPause호출");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life", "onStop호출");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life", " onRestart호출");
    }
    @Override
    protected void onDestroy() {//앱이 종료될때 호출
        super.onDestroy();
        Log.d("life", "onDestroy호출");
    }
}