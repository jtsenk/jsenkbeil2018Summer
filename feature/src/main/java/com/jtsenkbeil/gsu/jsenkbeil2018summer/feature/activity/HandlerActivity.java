package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.BaseActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.util.UtilLog;

public class HandlerActivity extends BaseActivity {

    private Button bt;
    private EditText et;
    private int time;
    private View.OnClickListener startL;
    private View.OnClickListener stopL;
    private View.OnClickListener resetL;
    private Thread thread;

    private final int TIMER = 123;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == TIMER) {
                Bundle bundler = msg.getData();
                String s = bundler.getString("msg");
                //shortToast("Message: " + s);
                time = Integer.valueOf(et.getText().toString());
                et.setText(String.valueOf(--time));
                if (time == 0) {
                    bt.setText("reset");
                    bt.setOnClickListener(resetL);
                } else {
                    thread.run();
                }
            }//end if msg.what is TIMER
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        et = findViewById(R.id.activity_handler_et);
        bt = findViewById(R.id.activity_handler_bt);

        startL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setEnabled(false);
                bt.setText("stop");
                bt.setOnClickListener(stopL);
                startThread();
            }
        };

        stopL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread.interrupt();
                bt.setText("reset");
                bt.setOnClickListener(resetL);
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

    private void startThread() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putString("msg","TimerMessage");
                    msg.setData(bundle);
                    msg.what = TIMER;
                    handler.handleMessage(msg);
                } catch (Exception e) {
                    UtilLog.d("startThread","Thread Error");
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

}//end HandlerActivity class