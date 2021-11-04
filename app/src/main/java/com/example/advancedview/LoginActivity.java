package com.example.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText id;
    EditText pass;
    Button loginbtn;
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
                String ID = id.getText().toString();
                String PASS = pass.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Main_menuActivity.class);
                intent.putExtra("ID",ID);
                intent.putExtra("PASS",PASS);


            }
        });
    }
}