package com.example.sangho.exam_1222;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    final static int BTN_NUM_LEN = 12;          // 숫자 버튼 개수
    final static int BTN_OP_LEN = 7;            // 연산자 버튼 개수
    private TextView plainText;
    private inputAll inAll;
    private Button btnNum[] = new Button[BTN_NUM_LEN];
    private Button btnOp[] = new Button[BTN_OP_LEN];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        for(int i = 0 ; i < BTN_NUM_LEN; i++)      // 숫자 입력 버튼 리스너 생성
        {
            btnNum[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    plainText.setText(inAll.inputNum(v.getTag().toString()));
                }
            });
        }
        for (int i = 0; i < BTN_OP_LEN; i++) {
            btnOp[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    plainText.setText(inAll.inputOp(v.getTag().toString()));

                }
            });
        }
    }

    private void init()     // 각종 인스턴스 초기화
    {
        plainText = (TextView) findViewById(R.id.textView);     //텍스트 뷰
        inAll = new inputAll(getApplicationContext());          // 입력 클래스
        for(int i = 0; i < BTN_NUM_LEN; i++){             // 숫자 입력 버튼 초기화
            int id = getResources().getIdentifier("btnNum0"+i,"id",getPackageName());
            btnNum[i] = (Button) findViewById(id);
            System.out.println(id);
        }
        for (int i = 0; i < BTN_OP_LEN; i++) {
            int id = getResources().getIdentifier("btnOp" + i, "id", getPackageName());
            btnOp[i] = (Button) findViewById(id);
        }
    }

}

