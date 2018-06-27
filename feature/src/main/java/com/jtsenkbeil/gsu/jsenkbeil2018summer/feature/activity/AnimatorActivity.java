package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.BaseActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.util.UtilLog;

public class AnimatorActivity extends BaseActivity {

    private ValueAnimator repeatAnimator;
    private ValueAnimator anima;
    private ObjectAnimator animator;

    private Button startB;
    private Button stopB;
    private Button alphaB;
    private Button scaleB;
    private Button rotateB;
    private Button charfB;
    private Button transB;
    private Button colorB;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        startB = findViewById(R.id.activity_animator_start);
        stopB = findViewById(R.id.activity_animator_stop);
        alphaB = findViewById(R.id.animator_alpha);
        scaleB = findViewById(R.id.animator_scale);
        rotateB = findViewById(R.id.animator_rotate);
        charfB = findViewById(R.id.animator_charf);
        transB = findViewById(R.id.animator_trans);
        colorB = findViewById(R.id.animator_color);

        tv = findViewById(R.id.activity_animator_tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortToast("Click");
            }
        });

        transB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator = ObjectAnimator.ofFloat(tv, "translationY", 100, -120);
                animator.start();
            }
        });
        scaleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator = ObjectAnimator.ofFloat(tv, "scaleX", 0,3,1,2,5,1); //scaleY
                animator.setDuration(5000);
                animator.start();
            }
        });
        colorB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator = ObjectAnimator.ofInt(tv, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
                animator.setDuration(8000);
                animator.setEvaluator(new ArgbEvaluator() );
                animator.start();
            }
        });
        alphaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator = ObjectAnimator.ofFloat(tv,"alpha",1,0,1);
                animator.setDuration(2000);
                animator.start();
            }
        });
        rotateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator = ObjectAnimator.ofFloat(tv,"rotationY",0,360,0);//rotationX   rotationY
                animator.setDuration(4000);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.setRepeatMode(ValueAnimator.REVERSE);
                animator.setRepeatCount(2);
                animator.start();
            }
        });
        charfB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anima = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
                anima.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        char text = (char)animation.getAnimatedValue();
                        tv.setText(String.valueOf(text));
                    }
                });
                anima.setDuration(10000);
                anima.setInterpolator(new AccelerateInterpolator());
                anima.start();
            }
        });

        startB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatAnimator = doAnimatorListener();
                //repeatAnimator.setStartDelay(3000);
                repeatAnimator.start();
            }
        });

        stopB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatAnimator.cancel();
                repeatAnimator.removeAllListeners();
                repeatAnimator.removeAllUpdateListeners();
            }
        });

    }

    private ValueAnimator doAnimatorListener() {
        anima = ValueAnimator.ofInt(0,400);

        anima.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
            }
        });
        anima.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                shortToast("Started");
                UtilLog.d("Yan","animation start");
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                shortToast("Ended");
                UtilLog.d("Yan","animation end");
            }
            @Override
            public void onAnimationCancel(Animator animation) {
                shortToast("Canceled");
                UtilLog.d("Yan","animation cancel");
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
                shortToast("Repeated");
                UtilLog.d("Yan","animation repeat");
            }
        });
        anima.setRepeatMode(ValueAnimator.REVERSE);
        anima.setRepeatCount(2);
//        anima.setInterpolator(new CycleInterpolator(10));
        anima.setDuration(2000);
        return anima;
    }

    private class CharEvaluator implements TypeEvaluator<Character> {
        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int startInt  = (int)startValue;
            int endInt = (int)endValue;
            int curInt = (int)(startInt + fraction *(endInt - startInt));
            char result = (char)curInt;
            return result;
        }
    }

    public class ArgbEvaluator implements TypeEvaluator {
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            int startInt = (Integer) startValue;
            int startA = (startInt >> 24);//0x(A)ff(R)ff(G)ff(B)
            int startR = (startInt >> 16) & 0xff;
            int startG = (startInt >> 8) & 0xff;
            int startB = startInt & 0xff;
            int endInt = (Integer) endValue;
            int endA = (endInt >> 24);
            int endR = (endInt >> 16) & 0xff;
            int endG = (endInt >> 8) & 0xff;
            int endB = endInt & 0xff;
            return (int)((startA + (int)(fraction * (endA - startA))) << 24) |
                    (int)((startR + (int)(fraction * (endR - startR))) << 16) |
                    (int)((startG + (int)(fraction * (endG - startG))) << 8) |
                    (int)((startB + (int)(fraction * (endB - startB))));
        }
    }

}
