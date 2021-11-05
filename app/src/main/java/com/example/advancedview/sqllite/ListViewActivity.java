package com.example.advancedview.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.advancedview.R;

public class ListViewActivity extends AppCompatActivity {
    //1.ListView에 출력할 데이터
    String[] datalist = {"oracle","java","jdbc", "html", "css", "javascript", "jquery", "servlet", "jsp", "spring", "hadoop", "flumr", "sqoop", "android"};
    ListView listview;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        listview = findViewById(R.id.listview1);
        txt = findViewById(R.id.listTxt);
        //2.Adapter 객체를 생성 = Listview에 데이터를 어떤 디자인으로 출력 할지 설정
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,datalist);
        //3.Listview에서 어댐터가 뷰를 만들수있도록 Listview에 연결
        listview.setAdapter(adapter);

        //이벤트 연결
        MyListener listener = new MyListener();
        listview.setOnItemClickListener(listener);
    }

    class  MyListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("yyy",view.toString()+",poisiton : "+position+", id : "+id);
            txt.setText(datalist[position]);
        }
    }

}