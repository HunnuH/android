package com.example.advancedview.exam;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ExamDBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public ExamDBHelper(Context context) {
        super(context, "product.db", null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("yyy", "데이터 베이스 생성 완료");
        //테이블 생성
        String sql = "create table product("

                + "_id integer primary key autoincrement,"

                + "name text not null, "

                + "price integer not null, "

                + "su integer not null, "

                + "totPrice integer not null)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}