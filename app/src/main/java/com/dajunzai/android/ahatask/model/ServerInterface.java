package com.dajunzai.android.ahatask.model;

import com.dajunzai.android.ahatask.constant.CommonConstant;
import com.dajunzai.android.ahatask.utils.CommonBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Hinzcn on 2016/9/20.
 * auther:caoyue
 * mail:hinzcn@gmail.com
 */
public interface ServerInterface {
    //
    @FormUrlEncoded
    @POST(CommonConstant.REGISTER)
    Call<CommonBean> regist(@Field("username")String username, @Field("password")String password);
    @FormUrlEncoded
    @POST(CommonConstant.LOGIN)
    Call<CommonBean> login(@Field("username")String username,@Field("password")String password);

}
