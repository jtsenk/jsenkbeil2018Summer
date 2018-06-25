package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.BaseActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.audio.BaseBean;

public class ActivityA extends BaseActivity {

    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity);
        test = findViewById(R.id.a_test_view);
        //Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Click!",Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        String s = bundle.getString("StringBundle");
        int i = bundle.getInt("IntegerBundle");
        BaseBean bean = (BaseBean)bundle.getSerializable("Object");
        test.append("\n" + bean.getName());
        shortToast(bean.getName());
        //Toast.makeText(this, s + "\nInteger is: " + i, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

}
