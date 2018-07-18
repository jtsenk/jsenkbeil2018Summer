package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.BaseActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.util.UtilLog;

public class Quiz5Activity extends BaseActivity implements View.OnTouchListener {

    private GestureDetector gestureDetector;
    private int sumX = 0;
    private int sumY = 0;
    private ValueAnimator anima;
    private ObjectAnimator animator;
    private boolean hide;
    private TextView s1;
    private TextView s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        s1 = findViewById(R.id.q5_s1);
        s2 = findViewById(R.id.q5_s2);
        s2.setVisibility(View.INVISIBLE);
        gestureDetector = new GestureDetector(this,new Quiz5Activity.simpleGestureListener());
        s1.setOnTouchListener(this);
        s1.setFocusable(true);
        s1.setClickable(true);
        s1.setLongClickable(true);
        hide = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends
            GestureDetector.SimpleOnGestureListener {
        /***** onDown->onShowPress->onLongPress*****/
        boolean isToast = false;
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.d("Gesture", "onScroll");
//            UtilLog.d("Gesture","distanceX:"+distanceX);
//            UtilLog.d("Gesture","distanceY:"+distanceY);
            sumX += distanceX;
            sumY += distanceY;
            if (sumX < 0) {
                if (Math.abs(sumX) > 1000) {
                    //hide = false;
                    isToast = true;
                    shortToast("You scroll from left to right");
                    animator = ObjectAnimator.ofFloat(s2, "translationX", -250, 0);
                    animator.setDuration(2000);
                    s2.setVisibility(View.VISIBLE);
                    animator.start();
                }
            }
            if (sumX > 0) {
                if (Math.abs(sumX) > 1000) {
                    isToast = true;
                    //hide = true;
                    shortToast("You scroll from right to left");
                    animator = ObjectAnimator.ofFloat(s2, "translationX", 0, -250);
                    animator.setDuration(2000);
                    animator.start();
                }
            }

            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        @Override
        public boolean onDown(MotionEvent e) {
            UtilLog.d("Gesture","onDown");
            //isToast=false;
            sumX=0;
            sumY=0;
            return super.onDown(e);
        }


    } //end simpleGestureListener

    private ValueAnimator doAnimatorListener() {
        anima = ValueAnimator.ofInt(0,400);

        anima.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                s1.layout(s1.getLeft(),curValue,s1.getRight(),curValue+s1.getHeight());
                //s2.layout(s2.getLeft(),curValue,s2.getRight(),curValue+s2.getHeight());
                UtilLog.d("AnimUpdate","It Happened");
            }
        });
        anima.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //shortToast("Started");
                s2.setVisibility(View.VISIBLE);
                UtilLog.d("Yan","animation start");
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                //shortToast("Ended");
                //if (hide == true) {
                  //  s2.setVisibility(View.INVISIBLE);
                //}
                UtilLog.d("Yan","animation end");
            }
            @Override
            public void onAnimationCancel(Animator animation) {
                //shortToast("Canceled");
                UtilLog.d("Yan","animation cancel");
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
                //shortToast("Repeated");
                UtilLog.d("Yan","animation repeat");
            }
        });
        //anima.setRepeatMode(ValueAnimator.REVERSE);
        //anima.setRepeatCount(0);
        //anima.setInterpolator(new CycleInterpolator(10));
        //anima.setDuration(2000);
        return anima;
    }



} //end class
