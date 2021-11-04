package com.example.advancedview;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
// intent를 이용하는 작업 중 결과를 가지고 처음 호출해준 액티비티로 가지고 돌아오는 작업은 startActivityForResult를 사용
// 2020년 5월 기준으로 변경
// registerForActivityResult메소드를 이용해서 콜백을 등룍해서 작업하는 방식으로 변경
// 액티비티가 많아지면서 onActivityResult의 코드가 길어지고 분기가 많아지면서 유지보수가 힘들어짐
// onActivityResult안에서 작업을 처리하지 않고 분리하여 각각  독립적 코드로 작성
public class ReturnDataFirstActivity_Callback extends AppCompatActivity
			implements OnClickListener{
    public static final  int SECOND_BUTTON = 10;
    public static final  int THIRD_BUTTON = 20;
	Button bt1;
	Button bt2;
    Button bt3;
    Button bt4;

    //1. ActivityResultLauncher정의 >> 여러개 생성 가능
    ActivityResultLauncher<Intent> secondbtnLauncher;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first2);
        bt1 = (Button)findViewById(R.id.call1);
        bt2 = (Button)findViewById(R.id.call2);
        bt4 = (Button)findViewById(R.id.call3);
        bt3 = (Button)findViewById(R.id.btnExit);
        
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

        //2. registerForActivityResult메소드를 이용해서 콜백을 등룍
            // >>리턴값이 오는 경우 어떻게 처리할 것인지 등록
            // >> 매개변수1 : 어떤작업을 처리할 것인지 명시
            // >> 매개변수2 : 결과값에 대한 처리를 담당 할 콜백 메소드를 구현
                    // >> Requestcode 를 정의하지 않는디
                    // >> Activity객채가 인텐드, resultcode정보를 갖고 있다.
        secondbtnLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Intent intent = result.getData();
                            String returndata = intent.getStringExtra("second");
                            Toast.makeText(ReturnDataFirstActivity_Callback.this, returndata, Toast.LENGTH_LONG).show();
                        }
                    }
                }
            );
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.btnExit){
		    finish();

        }else if(v.getId()==R.id.call1){
		    Intent intent = new Intent();
		    intent.putExtra("info","첫 번째 액티비티가 넘기는 메시지");
		    startActivity(intent);// 에러발생!!!!!!!

        }else if(v.getId()==R.id.call2){
		    //새로운 액티비티를 실행해서 작업을 완료하고 되돌아오는 작업을 처리
            Intent intent = new Intent(this,ReturnDataSecondActivity.class);
            intent.putExtra("code","call2");
            intent.putExtra("data","첫 번째 액티비티가 넘기는 메시지");
            secondbtnLauncher.launch(intent);

        }else if(v.getId()==R.id.call3){
            Intent intent = new Intent(this,ReturnDataSecondActivity.class);
            intent.putExtra("code","call3");
            intent.putExtra("data","첫 번째 액티비티가 넘기는 메시지2");

            startActivityForResult(intent,THIRD_BUTTON);
		}
	}

/*
*  인텐트를 통해서 액티비티를 호출하고 되돌아는 경우 자동으로 onActivityResult를 호출한다.
*  onActivityResult를 오버라이딩해서 작업을 구현
*       requestCode => 요청했던 뷰를 구분하기 위한 코드
*       resultCode => 결과코드
*       data => Intent객체
*
* */

    //이해안감
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent returnintent) {
        super.onActivityResult(requestCode, resultCode, returnintent);
        Log.d("park",requestCode+"");
        switch (requestCode){
            case SECOND_BUTTON:
                if(resultCode==RESULT_OK){
                    String returndata = returnintent.getStringExtra("second");
                    Toast.makeText(this,"1번버튼"+returndata, Toast.LENGTH_LONG).show();
                }
                break;
            case THIRD_BUTTON:
                if(resultCode==RESULT_OK){
                    String returndata = returnintent.getStringExtra("second");
                    Toast.makeText(this,"2번버튼"+returndata, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}









































