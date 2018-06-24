package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter.ViewPagerAdapter;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.BlueFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.DemoFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.GreenFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.RedFragment;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment.WorkFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> frangmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.viewpager_vp);
        frangmentList.add(new DemoFragment());
        frangmentList.add(new WorkFragment());
        frangmentList.add(new RedFragment());
        frangmentList.add(new BlueFragment());
        frangmentList.add(new GreenFragment());
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), frangmentList);
        viewPager.setAdapter(adapter);
        adapter.updateList(frangmentList);
    }

}
