package com.dajunzai.android.ahatask.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by li_zh on 2016/9/18.
 */
public class Utils {
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
