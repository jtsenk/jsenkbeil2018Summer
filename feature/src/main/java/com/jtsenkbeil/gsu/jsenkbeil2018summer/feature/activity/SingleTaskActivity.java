package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

public class SingleTaskActivity extends AppCompatActivity {

    private View standard;
    private View singleTop;
    private View singleTask;
    private View singleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
        standard = findViewById(R.id.singleTask_standard_bt);
        singleTop = findViewById(R.id.singleTask_singletop_bt);
        singleTask = findViewById(R.id.singleTask_singletask_bt);
        singleInstance = findViewById(R.id.singleTask_singleinstance_bt);

        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SingleTaskActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });

        singleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SingleTaskActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });

        singleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SingleTaskActivity.this, SingleTaskActivity.class);
                startActivity(intent);
            }
        });

        singleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SingleTaskActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
            }
        });

    }
}
