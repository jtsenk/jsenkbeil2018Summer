package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter.AdvanceListViewAdapter;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter.ViewFragmentStateAdapter;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter.ViewPagerAdapter;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.BlueFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.GreenFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.RedFragment;

import java.util.ArrayList;

public class Quiz2Activity extends AppCompatActivity {

    private ListView lv;
    private ArrayList<Fragment> vList = new ArrayList<Fragment>();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        lv = findViewById(R.id.activity_quiz2_list_view);
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
        int width = lv.getWidth();

        ViewPager vp = new ViewPager(this);
        vp.setId(100);
        //vp.setMinimumHeight(500);
        //vp.setVisibility(1);
        //ViewPager vp = findViewById(R.id.quiz2_vp);
        vList.add(new RedFragment() );
        vList.add(new BlueFragment() );
        vList.add(new GreenFragment() );

        ViewPagerAdapter adapter2 = new ViewPagerAdapter(this.getSupportFragmentManager(), vList);
        //AbsListView.LayoutParams headerViewParams = new AbsListView.LayoutParams(width, 500);
        //vp.setLayoutParams(headerViewParams);
        vp.setAdapter(adapter2);

        float tSize = 50;
        TextView tv1 = new TextView(this);
        tv1.setText("HeaderView");
        tv1.setTextSize(tSize);

        adapter2.updateList(vList);
        AbsListView.LayoutParams headerViewParams = new AbsListView.LayoutParams(1080, 500);
        vp.setLayoutParams(headerViewParams);
        lv.addHeaderView(vp);
        //lv.addHeaderView(tv1);

    }
}