package com.inerdstack.mzcj.utils;

import android.util.Log;

import com.inerdstack.mzcj.AppConfig;

/**
 * Created by wangjie on 2016/10/31.
 */
public class AppLog {

    public static void i(String tag, String message) {
        if (AppConfig.isDebug) {
            Log.i(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (AppConfig.isDebug) {
            Log.d(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (AppConfig.isDebug) {
            Log.v(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (AppConfig.isDebug) {
            Log.e(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (AppConfig.isDebug) {
            Log.w(tag, message);
        }
    }
}
