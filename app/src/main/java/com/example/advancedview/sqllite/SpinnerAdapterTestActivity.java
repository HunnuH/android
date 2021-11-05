package com.example.advancedview.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.advancedview.R;

public class SpinnerAdapterTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_adaper_test);
        Spinner spinner = findViewById(R.id.spinner01);
        TextView txtResult = findViewById(R.id.spinner_result);
        AutoCompleteTextView auto = findViewById(R.id.autoview);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.mylist_data, android.R.layout.simple_spinner_item);
        ArrayAdapter autoadapter = ArrayAdapter.createFromResource(this, R.array.mylist_data, android.R.layout.simple_dropdown_item_1line);
        //spinner를 선택했을때 보여지는 목록에 적용할 디자인
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);//spinner와 어탭터 연결
        auto.setAdapter(autoadapter);//AutoCompleteTextView와 어댑터연결

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView myrow = view.findViewById(android.R.id.text1);
                txtResult.setText(myrow.getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}