package com.dajunzai.android.ahatask.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.dajunzai.android.ahatask.MainActivity;
import com.dajunzai.android.ahatask.utils.CommonBean;
import com.dajunzai.android.ahatask.utils.CommonRequestFactory;
import com.dajunzai.android.ahatask.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by li_zh on 2016/9/18.
 * 作者:李杰
 * 邮箱:577124196@qq.com
 */
public class CommonHttpClient {
    private  Context mContext;
    public CommonHttpClient(Context mContext) {
        this.mContext =mContext;
    }

    public void userRegister(String userName,String userPwd){
        ServerInterface serverInterface = CommonRequestFactory.buildRetrofit().createServerInterface();
        Call<CommonBean> regist = serverInterface.regist(userName, userPwd);
        regist.enqueue(new Callback<CommonBean>() {
            @Override
            public void onResponse(Call<CommonBean> call, Response<CommonBean> response) {
                Log.e("TAG", response.code() + "");
                CommonBean cb = response.body();
                if (cb != null) {
                    if (cb.isRe()) {
                      Utils.showToast(mContext,cb.getMessage());
                    } else {
                        Utils.showToast(mContext,cb.getMessage());
                    }
                } else {
                    Utils.showToast(mContext,"连接失败");
                }
            }

            @Override
            public void onFailure(Call<CommonBean> call, Throwable t) {
                Utils.showToast(mContext,"出错了请稍候重试");
            }
        });

    }

    public void userLogin(String username, String userpwd) {
        ServerInterface serverInterface = CommonRequestFactory.buildRetrofit().createServerInterface();
        Call<CommonBean> login = serverInterface.login(username, userpwd);

        login.enqueue(new Callback<CommonBean>() {
            @Override
            public void onResponse(Call<CommonBean> call, Response<CommonBean> response) {
                CommonBean cb = response.body();
                if (cb != null) {
                    if (cb.isRe()) {
                        Utils.showToast(mContext,cb.getMessage());
                        Intent intent = new Intent(mContext, MainActivity.class);
                        mContext.startActivity(intent);
                        ((Activity)mContext).finish();
                    } else {
                       Utils.showToast(mContext,cb.getMessage());
                    }
                } else {
                   Utils.showToast(mContext,cb.getMessage());
                }
            }
            @Override
            public void onFailure(Call<CommonBean> call, Throwable t) {
               Utils.showToast(mContext,"出错了请稍候重试");
            }
        });
    }
}
