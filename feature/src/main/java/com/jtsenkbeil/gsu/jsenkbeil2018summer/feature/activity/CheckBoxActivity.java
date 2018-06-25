package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

import java.util.HashMap;
import java.util.Map;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private Button submitBtn;
    private HashMap<String, Boolean> list = new HashMap<String, Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        check1 = findViewById(R.id.activity_check_box_1);
        check2 = findViewById(R.id.activity_check_box_2);
        check3 = findViewById(R.id.activity_check_box_3);
        submitBtn = findViewById(R.id.activity_check_box_submit);

        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "You Checked: ";
                for (Map.Entry<String,Boolean> entry : list.entrySet()) {
                    if (entry.getValue()) {
                        s += (entry.getKey() + " ");
                    }
                }
                Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
