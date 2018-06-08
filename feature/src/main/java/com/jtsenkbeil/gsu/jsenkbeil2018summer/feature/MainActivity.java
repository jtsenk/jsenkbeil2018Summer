package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.DemoFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.WorkFragment;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView tv_demo;
    private TextView tv_work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        setListener();
    }

    private void initialView() {
        tv_demo = (TextView)findViewById(R.id.activity_tool_demo);
        tv_work = (TextView)findViewById(R.id.activity_tool_work);
    }

    private void setListener() {
        final WorkFragment workFragment = new WorkFragment();
        final DemoFragment demoFragment = new DemoFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment, demoFragment).commit();

        tv_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_demo.setTextColor(Color.RED);
                tv_work.setTextColor(Color.BLACK);
                Toast.makeText(MainActivity.this, "You clicked Demo",Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment, demoFragment).commit();
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_demo.setTextColor(Color.BLACK);
                tv_work.setTextColor(Color.RED);
                Toast.makeText(MainActivity.this, "You clicked Work",Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment, workFragment).commit();
            }
        };
        tv_work.setOnClickListener(listener);

    }

    public void login(View v) {
        Toast.makeText(MainActivity.this, "You clicked login", Toast.LENGTH_SHORT).show();
    }

    public void tClick(View v) {
        Toast.makeText(MainActivity.this, "You clicked T", Toast.LENGTH_SHORT).show();
    }
}
