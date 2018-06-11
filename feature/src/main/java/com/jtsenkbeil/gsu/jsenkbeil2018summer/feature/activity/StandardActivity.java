package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

public class StandardActivity extends AppCompatActivity {

    private View standard;
    private View singleTop;
    private View singleTask;
    private View singleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        standard = findViewById(R.id.standard_standard_bt);
        singleTop = findViewById(R.id.standard_singletop_bt);
        singleTask = findViewById(R.id.standard_singletask_bt);
        singleInstance = findViewById(R.id.standard_singleinstance_bt);

        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(StandardActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });

        singleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(StandardActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });

        singleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(StandardActivity.this, SingleTaskActivity.class);
                startActivity(intent);
            }
        });

        singleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(StandardActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
            }
        });

    }
}
