package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

public class ResultActivity1 extends AppCompatActivity {

    final static int ID = 7777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("Data","Data");
        setResult(200, intent);
        super.onBackPressed();
    }

}
