package com.example.servicedemo;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Intent samIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialComponent();

        samIntent = new Intent (MainActivity.this, samService.class); //使用Intent，從MainActivity對SamService>
    }

    private void InitialComponent() {
        btnStart =  (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        //實作clickListener這個類別
        btnStart.setOnClickListener(new btnClicklistener());
        btnStop.setOnClickListener(new btnClicklistener());

    }

    Button btnStart, btnStop;

    private class btnClicklistener implements View.OnClickListener {

        //實作Click Listener ，必須實作onClick方法
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnStart:

                    startService(samIntent);
                     break;

                case R.id.btnStop:
                    stopService(samIntent);
                    break;
            }
        }
    }
}