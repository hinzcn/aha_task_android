package com.dajunzai.android.ahatask;

import android.app.Application;

import com.dajunzai.android.ahatask.constant.CommonConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                    .baseUrl(CommonConstant.BASEURL)
                    .build();
        }
        return retrofit;
    }
}
