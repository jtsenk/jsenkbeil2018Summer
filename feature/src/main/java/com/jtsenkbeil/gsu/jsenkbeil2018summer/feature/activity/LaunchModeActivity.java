package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

import static java.security.AccessController.getContext;

public class LaunchModeActivity extends AppCompatActivity {

    private View standard;
    private View singleTop;
    private View singleTask;
    private View singleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
        standard = findViewById(R.id.launch_standard_bt);
        singleTop = findViewById(R.id.launch_singletop_bt);
        singleTask = findViewById(R.id.launch_singletask_bt);
        singleInstance = findViewById(R.id.launch_singleinstance_bt);

        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LaunchModeActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });

        singleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LaunchModeActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });

        singleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LaunchModeActivity.this, SingleTaskActivity.class);
                startActivity(intent);
            }
        });

        singleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LaunchModeActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
            }
        });

    }

}
