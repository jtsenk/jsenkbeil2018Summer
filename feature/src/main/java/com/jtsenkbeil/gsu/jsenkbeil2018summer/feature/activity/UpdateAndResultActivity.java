package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

public class UpdateAndResultActivity extends AppCompatActivity {

    private Button btU;
    private Button btA1;
    private Button btA2;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_and_result);
        btU = findViewById(R.id.result_update);
        btA1 = findViewById(R.id.result_a1);
        btA2 = findViewById(R.id.result_a2);

        btU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update


            }
        });

        btA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to ResultActivity1
                intent = new Intent(UpdateAndResultActivity.this, ResultActivity1.class);
                startActivityForResult(intent, ResultActivity1.ID);
            }
        });

        btA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to ResultActivity2
                intent = new Intent(UpdateAndResultActivity.this, ResultActivity2.class);
                startActivityForResult(intent, ResultActivity2.ID);
            }
        });

    }
}
