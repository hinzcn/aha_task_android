package com.dajunzai.android.ahatask;

import android.app.Application;

import com.dajunzai.android.ahatask.utils.URLUtil;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2016/9/19.
 */
public class MyApplication extends Application {

    public Retrofit retrofit;
    @Override
    public void onCreate() {
        super.onCreate();
    }
    public Retrofit getRetrofit(){
        if(retrofit==null){
             retrofit = new Retrofit.Builder()
                     .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(URLUtil.baseUrl)
                    .build();
        }
        return retrofit;
    }
}
