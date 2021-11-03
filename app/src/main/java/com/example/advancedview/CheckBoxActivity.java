package com.example.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity
                            implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    TextView text1;
    CheckBox[] checkArr = new CheckBox[3];
    Button setcheck;
    Button showstatus;
    Button clearcheckbtn;
    Button reversecheckstatus;
    Switch myswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
        text1 = findViewById(R.id.checktext);
        checkArr[0] = findViewById(R.id.checkBox);
        checkArr[1] = findViewById(R.id.checkBox2);
        checkArr[2] = findViewById(R.id.checkBox3);
        setcheck = findViewById(R.id.button);
        showstatus = findViewById(R.id.button2);
        clearcheckbtn = findViewById(R.id.button3);
        reversecheckstatus = findViewById(R.id.button4);
        myswitch = findViewById(R.id.switch1);

        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i].setOnCheckedChangeListener(this);
        }
        setcheck.setOnClickListener(this);
        showstatus.setOnClickListener(this);
        clearcheckbtn.setOnClickListener(this);
        reversecheckstatus.setOnClickListener(this);
        myswitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                setChekVal(true);
                break;
            case R.id.button2:
                getcheckstatus();
                break;

            case R.id.button3:
                setChekVal(false);
                break;

            case R.id.button4:
                break;
        }
    }

    public void getcheckstatus() {
        text1.setText("");
        for (int i = 0; i < checkArr.length; i++) {
            if (checkArr[i].isChecked()) {
                String tag = (String) checkArr[i].getTag();
                text1.append(tag + "번 체크박스의 체크가 설정\n");
            } else {
                String tag = (String) checkArr[i].getTag();
                text1.append(tag + "번 체크박스의 체크가 해제\n");
            }
        }
    }

    public void reversStatus() {
        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i].toggle();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.d("y.test", buttonView.toString() + ":::::::::::::::::::" + isChecked + ":::::::::" + buttonView.getTag());
        if (buttonView instanceof CheckBox) {
            display(Integer.parseInt(buttonView.getTag()+""),isChecked);
        } else {
            if(buttonView.getId()==R.id.switch1) {
               String msg = " ";
                if (buttonView.isChecked()) {
                    msg = "활성상태";
                } else {
                    msg = "비활성화";
                }
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void display(int index, boolean checkStatus) {//체크박의 상태가 변경될때 호출되는 메소드, 체크박스와 스위치 선택시 Toast로 "xxxx체크 박스 선택 / 해제"
        if (checkStatus) {
            text1.setText(index + "체크박스 선택");
        } else {
            text1.setText(index + "체크박스 해제");
        }
    }

    public void setChekVal(boolean chekVal) {
        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i].setChecked(chekVal);
        }
    }
}