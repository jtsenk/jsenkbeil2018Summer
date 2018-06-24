package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature;

import android.app.Application;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.util.UtilLog;

public class JSenkbeilApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setIsLog(true);
    }

}
