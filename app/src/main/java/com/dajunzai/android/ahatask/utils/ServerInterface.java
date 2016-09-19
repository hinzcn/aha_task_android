package com.dajunzai.android.ahatask.utils;

import com.dajunzai.android.ahatask.model.UserBean;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Administrator on 2016/9/19.
 */
public interface ServerInterface {
    //
    @FormUrlEncoded
    @POST("home/user/regist")
    Call<CommonBean> regist(@Field("username")String username, @Field("password")String password);
    @FormUrlEncoded
    @POST("home/user/login")
    Call<CommonBean> login(@Field("username")String username,@Field("password")String password);
}
