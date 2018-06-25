package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.BaseActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

public class ResultActivity extends BaseActivity {

    private Button bt1;
    private Button bt2;
    private Intent intent;

    private final int ACTIVITY1 = 123;
    private final int ACTIVITY2 = 321;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        bt1 = findViewById(R.id.activity_result_bt1);
        bt2 = findViewById(R.id.activity_result_bt2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getBaseContext(), ResultActivity1.class);
                startActivityForResult(intent,ACTIVITY1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getBaseContext(), ResultActivity2.class);
                startActivityForResult(intent,ACTIVITY2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String s = data.getStringExtra("Data");
        switch(requestCode){
            case ACTIVITY1:
                shortToast(s+"FromResultActivity1");
                break;
            case ACTIVITY2:
                shortToast(s+"FromResultActivity2");
                break;
            default:
        }
    }
}
