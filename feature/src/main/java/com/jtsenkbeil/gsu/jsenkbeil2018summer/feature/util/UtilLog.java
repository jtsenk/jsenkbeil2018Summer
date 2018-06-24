package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.util;

import android.util.Log;

public class UtilLog {

    private static boolean isLog = false;

    public static void setIsLog(boolean b) {
        isLog = b;
    }

    public static void d(String tag, String msg) {
        if (isLog) {
            Log.d(tag,msg);
        }
    }

}
