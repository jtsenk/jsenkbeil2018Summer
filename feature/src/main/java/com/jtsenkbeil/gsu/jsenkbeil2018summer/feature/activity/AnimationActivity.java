package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

public class AnimationActivity extends AppCompatActivity {


    private Button alphaB;
    private Button setB;
    private Button scaleB;
    private Button transB;
    private Button rotateB;
    private TextView tv;
    private Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        alphaB = findViewById(R.id.activity_animation_alpha);
        scaleB = findViewById(R.id.activity_animation_scale);
        rotateB = findViewById(R.id.activity_animation_rotate);
        transB = findViewById(R.id.activity_animation_trans);
        setB = findViewById(R.id.activity_animation_set);
        tv = findViewById(R.id.activity_animation_tv);

        alphaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.anim_alpha);
                tv.startAnimation(anim);
            }
        });

        scaleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.anim_scale);
                tv.startAnimation(anim);
            }
        });

        rotateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.anim_rotate);
                tv.startAnimation(anim);
            }
        });

        transB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.anim_trans);
                tv.startAnimation(anim);
            }
        });

        setB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.anim_set);
                tv.startAnimation(anim);
            }
        });



    }
}
