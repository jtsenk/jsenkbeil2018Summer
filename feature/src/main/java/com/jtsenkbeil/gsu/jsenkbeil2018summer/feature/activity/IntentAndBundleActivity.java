package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

public class IntentAndBundleActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_and_bundle);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("B_Msg");
        String b_msg = bundle.getString("B_Msg");
        String msg = intent.getStringExtra("Msg");
        int number = intent.getIntExtra("number",0);
        Toast.makeText(this, "number= " + number + "\nmsg= " + msg, Toast.LENGTH_SHORT).show();
        tv = findViewById(R.id.intent_tv);
        tv.setText("B_Msg= " + b_msg);
    }
}
