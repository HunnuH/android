package com.example.advancedview.sqllite;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.advancedview.R;
//리소스에 자장되어 있는 데잍터를 Listview에 출력
public class ResourceDataListActivity extends AppCompatActivity {
    //1.ListView에 출력할 데이터
    ListView listview;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        listview = findViewById(R.id.listview1);
        txt = findViewById(R.id.listTxt);
        //2.Adapter 객체를 생성 = Listview에 데이터를 어떤 디자인으로 출력 할지 설정
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.mylist_data, android.R.layout.simple_list_item_1);
        //3.Listview에서 어댐터가 뷰를 만들수있도록 Listview에 연결
        listview.setAdapter(adapter);

        //이벤트 연결
        MyListener listener = new MyListener();
        listview.setOnItemClickListener(listener);
    }

    class  MyListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          //view view매개변수가 목록을 구성하는 하나의 데이터가 출력되는 row
            TextView listrow_view = (TextView)view;
            txt.setText(listrow_view.getText());
        }
    }
}