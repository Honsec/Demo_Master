package com.sera.hongsec.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tencent.mid.api.MidCallback;
import com.tencent.mid.api.MidService;

public class MainActivity extends AppCompatActivity {

    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test =(TextView) findViewById(R.id.test);
        MidService.requestMid(this, new MidCallback() {
            @Override
            public void onSuccess(Object o) {
                test.setText(test.getText()+"\n"+"calback :"+ o );
            }

            @Override
            public void onFail(int i, String s) {
                test.setText(test.getText()+"\n"+"calback  errod:"+ i+":"+s );
            }
        });
        test.setText(test.getText()+"\n"+"Mid:"+MidService.getMid(this)+"\n"+"LocalMid:"+MidService.getLocalMidOnly(this));
    }
}
