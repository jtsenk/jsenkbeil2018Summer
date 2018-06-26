package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

public class RunnableHandlerActivity extends AppCompatActivity {

    private EditText et;
    private Button bt;
    private View.OnClickListener startL;
    private View.OnClickListener stopL;
    private View.OnClickListener resetL;
    private int time;

    Handler mHandler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if (time >= 0) {
                et.setText(String.valueOf(time));
                mHandler.postDelayed(runnable, 1000);
            } else {
                bt.setText("reset");
                bt.setOnClickListener(resetL);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runnable_handler);
        et = findViewById(R.id.activity_runnable_handler_et);
        bt = findViewById(R.id.activity_runnale_handler_bt);

        startL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setEnabled(false);
                time = Integer.valueOf(et.getText().toString());
                bt.setText("stop");
                bt.setOnClickListener(stopL);
                mHandler.postDelayed(runnable, 1000);
            }
        };

        stopL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt.setText("reset");
                bt.setOnClickListener(resetL);
                mHandler.removeCallbacks(runnable);
            }
        };

        resetL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("20");
                et.setEnabled(true);
                bt.setText("start");
                bt.setOnClickListener(startL);
            }
        };

        bt.setOnClickListener(startL);
    }

}
