package com.example.advancedview.sqllite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 3;
    public  DBHelper(Context context) {
        super(context, "test.db", null,DB_VERSION);
    }
    //앱이 설치되고 SQLiteOpenHelper가 최초로 호출될때 한 번만 실행
    //테이블이 생성되고 필요하면 초기화 작업 처리
    //앱을 최초로 다운로드 받는 사람들을 위해서 만들어 놓은 메소드 - 최신 유지
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("yyy", "데이터 베이스 생성 완료");
        //테이블 생성
        String sql = "create table if not exists member(" 
                +    "idx integer primary key autoincrement,"
                +    "id text,"
                +    "name text,"
                +   "age integer)";
        db.execSQL(sql);
    }
            /*데이터베이스의 버전이 변경될때 마다 호출
            * 스키마가 변경되면 호출되어 업데이트에 관련된 여러가지 처리를 구현
            * 기존 사용자들이 변경된 내용을 반영하려 할때 호출 되는 메소드*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("yyy", "데이터베이스의 스키마 변경  oldver : "+oldVersion+", newver : "+newVersion );
        switch (oldVersion) {
            case 1:
                //1버전 >> 2버전
            case 2:
                //2 >> 3
                Log.d("yyy", "version3");
            case 3:
        }

    }
}