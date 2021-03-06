package com.example.advancedview;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

public class BasicAppRun extends AppCompatActivity {
    //승인을 받을 권한의 목록
    String[] permission_list = {Manifest.permission.CALL_PHONE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_app_run);
        runPermission();

    }
    //권한을 체크하는 메소드 - 승인처리
    public void runPermission(){
        //하위버전이면 실행되지 않도록 설정 -M(23번버전)보다 낮으면 종료
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M) {
            return;
        }
        //모든 권한을 셀프로 체크
        for(String permission:permission_list) {
            int chk = checkCallingOrSelfPermission(permission);
            if(chk==PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list,0);
                break;
            }
        }
    }
    //안드로이드에 등록되어 있는 액션으로 암시적 인텐트 호출 -  데이터(셋팅은 URI객체로 만들기)
    //구글맵실행
    public void runGoogleMap(View v){
        Uri uri = Uri.parse("geo:35.63408893148424, 129.43500053014046");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    //웹브라우저실행
    public void runWeb(View v){
        Uri uri = Uri.parse("http://naver.com");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    //전화걸기화면만 실행
    public void runDial(View v){
        //사용할 데이터를 Uri.parse("")에 등록 (접두사를 이용)
        Uri uri = Uri.parse("tel:0000000");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
    //실제 전화 걸기 위한 메소드
    public void runCallPhone(View v){
        int chk = PermissionChecker.checkCallingOrSelfPermission(this,Manifest.permission.CALL_PHONE);
        if(chk==PackageManager.PERMISSION_GRANTED) {
            Log.d("yyy","성공");
        Uri uri = Uri.parse("tel:00000");
        Intent intent = new Intent(Intent.ACTION_CALL,uri);
        startActivity(intent);
        }else {
            Log.d("yyy","실패");
            return;
        }
    }
}
