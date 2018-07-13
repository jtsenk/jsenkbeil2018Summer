package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter.ViewFragmentStateAdapter;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter.ViewPagerAdapter;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.BlueFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.DemoFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.GreenFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.RedFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.WorkFragment;

import java.util.ArrayList;

public class AdvanceViewPagerActivity extends AppCompatActivity {

    private TabLayout tl;
    private ViewPager vp;
    private ArrayList<Pair<String,Fragment>> list = new ArrayList<Pair<String,Fragment>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_view_pager);
        tl = findViewById(R.id.activity_advance_view_pager_tl);
        vp = findViewById(R.id.activity_advance_view_pager);

        list.add(new Pair<String, Fragment>("Red", new RedFragment() ) );
        list.add(new Pair<String, Fragment>("Blue", new BlueFragment() ) );
        list.add(new Pair<String, Fragment>("Green", new GreenFragment() ) );

        ViewFragmentStateAdapter adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);

    }

}
