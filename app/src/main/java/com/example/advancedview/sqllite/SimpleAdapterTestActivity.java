package com.example.advancedview.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.advancedview.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterTestActivity extends AppCompatActivity {
    // 두줄 텍스트로 리스트뷰를 구성
    ArrayList<HashMap<String, String>> datalist = new ArrayList<HashMap<String, String>>();
    ListView listview;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_test);
        listview = findViewById(R.id.simplelist);
        txt = findViewById(R.id.simpletxt);
        //리스트를 구성할 샘플 데이터 준비
        HashMap<String, String> item = new HashMap<String, String>();
        item.put("name", "가나다라");
        item.put("telnum", "000000000");
        datalist.add(item);

        item = new HashMap<String, String>();
        item.put("name", "아아아아아");
        item.put("telnum", "111111111");
        datalist.add(item);

        item = new HashMap<String, String>();
        item.put("name", "오오오오오오");
        item.put("telnum", "22222222");
        datalist.add(item);

        item = new HashMap<String, String>();
        item.put("name", "삼삼삼삼ㅅ");
        item.put("telnum", "3333333");
        datalist.add(item);

        SimpleAdapter adapter = new SimpleAdapter(this,datalist, android.R.layout.simple_list_item_2,new String[]{"name","telnum"}, new int[]{android.R.id.text1, android.R.id.text2});
        listview.setAdapter(adapter);

    }
}