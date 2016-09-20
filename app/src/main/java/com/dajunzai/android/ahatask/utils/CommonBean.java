package com.dajunzai.android.ahatask.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hinzcn on 2016/9/19.
 * auther:caoyue
 * mail:hinzcn@gmail.com
 */
public class CommonBean {
    @Expose
    @SerializedName("return")
    private boolean re;
    private String message;

    public boolean isRe() {
        return re;
    }

    public void setRe(boolean re) {
        this.re = re;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
