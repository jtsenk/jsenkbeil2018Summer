package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import android.content.Context;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter.ScalePagerAdapter;
import android.content.Context;
import java.security.AccessController;
import java.util.ArrayList;

public class ScaleTypeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ScalePagerAdapter adapter;
    private ArrayList<View> list;
    private View view1;
    private View view2;
    private View view3;
    private View view4;
    private View view5;
    private View view6;
    private View view7;
    private View view8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_type);
        Toast.makeText(this,"Scale Type Pager", Toast.LENGTH_SHORT).show();
        viewPager = (ViewPager)findViewById(R.id.activity_scale_view_pager);
        LayoutInflater lf = getLayoutInflater().from(this);
        view1 = lf.inflate(R.layout.view_scale_centerinside, null);
        view2 = lf.inflate(R.layout.view_scale_center, null);
        view3 = lf.inflate(R.layout.view_scale_matrix, null);
        view4 = lf.inflate(R.layout.view_scale_center_crop, null);
        view5 = lf.inflate(R.layout.view_scale_fit_center, null);
        view6 = lf.inflate(R.layout.view_scale_fit_end, null);
        view7 = lf.inflate(R.layout.view_scale_fit_start, null);
        view8 = lf.inflate(R.layout.view_scale_fit_xy, null);

        list = new ArrayList<View>();
        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);
        list.add(view5);
        list.add(view6);
        list.add(view7);
        list.add(view8);
        adapter = new ScalePagerAdapter(list);
        viewPager.setAdapter(adapter);
    }
}
