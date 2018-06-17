package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter.AdvanceListViewAdapter;

import java.util.ArrayList;

public class AdvanceListViewActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance);
        lv = findViewById(R.id.activity_advance_list_view);
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello!");
        list.add("Hi, how are you?");
        list.add("I am fine, thanks!  How you doin'?");
        list.add("I'm doing well!  The weather is awesome.");
        for(int i=0; i<10; i++) {
            list.add("That's so great!");
        }
        AdvanceListViewAdapter adapter = new AdvanceListViewAdapter(this, list);
        lv.setAdapter(adapter);

        //header and footer text size
        float tSize = 50;
        TextView tv1 = new TextView(this);
        tv1.setText("HeaderView");
        tv1.setTextSize(tSize);
        lv.addHeaderView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText("FooterView");
        tv2.setTextSize(tSize);
        lv.addFooterView(tv2);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), String.valueOf(position-1), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
