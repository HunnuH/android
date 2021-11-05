package com.example.advancedview.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.advancedview.R;

public class LoginActivity extends AppCompatActivity {
    EditText id;
    EditText pass;
    Button loginbtn;
    public static final int INPUT_DATA_RESULT_TEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        id = findViewById(R.id.id);
        pass = findViewById(R.id.pass);
        loginbtn = findViewById(R.id.login_btn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Main_menuActivity.class);
                intent.putExtra("ID",id.getText().toString());
                intent.putExtra("PASS",pass.getText().toString());
                startActivityForResult(intent, INPUT_DATA_RESULT_TEST);
                //String returndata = intent.getStringExtra("입력해주세요");
                //Toast.makeText(LoginActivity.this,returndata, Toast.LENGTH_LONG ).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INPUT_DATA_RESULT_TEST) {
            if (resultCode==RESULT_OK) {
                String menu = data.getStringExtra("menu");
                String message = data.getStringExtra("message");

                Toast.makeText(getBaseContext(), "result code : " + resultCode + ", menu : " + menu + ", message : " + message, Toast.LENGTH_LONG).show();
            }
        }
    }
}