package com.example.advancedview.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.advancedview.R;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    EditText product;
    EditText price;
    EditText EA;
    Button insert;
    Button result1;
    Button result2;
    Button search;
    ListView list;
    ExamDBHelper examDBHelper;
    SQLiteDatabase examdb;
    ArrayList<HashMap<String, String>> ArrayList = new ArrayList<HashMap<String, String>>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        product = findViewById(R.id.edtName);
        price = findViewById(R.id.edtPrice);
        EA = findViewById(R.id.edtSu);
        insert = findViewById(R.id.btnIns);
        result1 = findViewById(R.id.btnResult);
        result2 = findViewById(R.id.btnResult2);
        search = findViewById(R.id.btnSearch);
        list = findViewById(R.id.list);
        examDBHelper = new ExamDBHelper(this);
        examdb = examDBHelper.getWritableDatabase();


    }

    public void insert(View v) {
        String sql = "insert into product(name,price,su,totPrice) values(?,?,?,?)";
        examdb.execSQL(sql, new Object[]{
                product.getText().toString(),
                Integer.parseInt(price.getText().toString()),
                Integer.parseInt(EA.getText().toString()),
                Integer.parseInt(EA.getText().toString()) * Integer.parseInt(price.getText().toString())});
        product.setText(" ");
        price.setText(" ");
        EA.setText(" ");
        showToast("추가 완료");
    }

    public void selectAll(View v) {
        list.setAdapter(list.getAdapter());
        String sql = "select * from product";
        Cursor cursor = examdb.rawQuery(sql, null);
        int count = cursor.getCount();
        String[] datalist = new String[count];
        int i =0;
        showToast("조회된 row : " + count);
        while (cursor.moveToNext()) {
            int _id = cursor.getInt(0);
            String name = cursor.getString(1);
            int price = cursor.getInt(2);
            datalist[i] = _id + name + price;
            i++;
            }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datalist);
        list.setAdapter(adapter);
        }

    public void simpleselect(View v) {
        list.setAdapter(list.getAdapter());
        String sql = "select * from product";
        Cursor cursor = examdb.rawQuery(sql, null);
        int count = cursor.getCount();
        String[] datalist = new String[count];
        int i =0;
        showToast("조회된 row : " + count);
        while (cursor.moveToNext()) {
           HashMap<String,String> item = new HashMap<>();
           String name = cursor.getString(1);
           item.put("product",name);
           int price = cursor.getInt(2);
           item.put("price", price+"");
           ArrayList.add(item);
           datalist[i] = name + price;
           i++;
        }
        SimpleAdapter adapter = new SimpleAdapter(this, ArrayList, android.R.layout.simple_list_item_2, new String[]{"product","price"}, new int[]{android.R.id.text1, android.R.id.text2});
        list.setAdapter(adapter);
    }

        public void search (View v){
            String sql = "select * from product where name = ?";
            Cursor cursor = examdb.rawQuery(sql, new String[]{product.getText().toString()});
            while (cursor.moveToNext()) {
                int idx = cursor.getInt(0);
                String product = cursor.getString(1);
                int price = cursor.getInt(1);
                int EA = cursor.getInt(3);
                result1.append(idx + product + price);

            }

        }
        public void showToast (String msg){
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }

}