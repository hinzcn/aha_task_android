package com.dajunzai.android.ahatask;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hinzcn on 2016/9/19.
 * auther:caoyue
 * mail:hinzcn@gmail.com
 */
public class MyApplication extends Application {
    public static Map<String,Object> cacheMap;
    public static Context mContext;

    public static Context getmContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        cacheMap = new HashMap<>();
        mContext = this;
    }

    public static Map<String, Object> getCacheMap() {
        return cacheMap;
    }
}
