package com.dajunzai.android.ahatask.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Adapter;

import com.dajunzai.android.ahatask.MainActivity;
import com.dajunzai.android.ahatask.MyApplication;
import com.dajunzai.android.ahatask.constant.CommonConstant;
import com.dajunzai.android.ahatask.model.domain.TaskListBean;
import com.dajunzai.android.ahatask.model.messagebean.AnyEventType;
import com.dajunzai.android.ahatask.utils.CommonBean;
import com.dajunzai.android.ahatask.utils.CommonRequestFactory;
import com.dajunzai.android.ahatask.utils.Utils;
import com.joanzapata.android.QuickAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Map;

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

    /**
     * 用户注册
     * @param userName
     * @param userPwd
     */
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

    /**
     * 用户登录
     * @param username
     * @param userpwd
     */
    public void userLogin(final String username, String userpwd) {
        ServerInterface serverInterface = CommonRequestFactory.buildRetrofit().createServerInterface();
        Call<CommonBean> login = serverInterface.login(username, userpwd);

        login.enqueue(new Callback<CommonBean>() {
            @Override
            public void onResponse(Call<CommonBean> call, Response<CommonBean> response) {
                CommonBean cb = response.body();
                if (cb != null) {
                    if (cb.isRe()) {
                        Utils.showToast(mContext,cb.getMessage());
                        CacheMapManager.putCache(CommonConstant.CacheConstant.USERINFO,username);
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

    /**
     * 获取用户的任务列表
     * @param username
     */
    public static void toGetTaskList(String username, final QuickAdapter adapter){
        ServerInterface serverInterface = CommonRequestFactory.buildRetrofit().createServerInterface();
        Call<TaskListBean> taskList = serverInterface.getTaskList(username);
        taskList.enqueue(new Callback<TaskListBean>() {
            @Override
            public void onResponse(Call<TaskListBean> call, Response<TaskListBean> response) {
                TaskListBean body = response.body();
                if(body!=null) {
                    if(body.isReturnX()) {
                        Log.e("TAG","message----"+body.toString());
                        List<TaskListBean.DatalistBean> datalist = body.getDatalist();
                            adapter.addAll(datalist);
                            EventBus.getDefault().post(new AnyEventType(adapter));

                    }else{

                    }
                }
            }

            @Override
            public void onFailure(Call<TaskListBean> call, Throwable t) {
                Utils.showToast(MyApplication.getmContext(),"出错了，请稍候重试！");
            }
        });
    }

    /**
     * 创建任务
     * @param requestMap
     */
    public static void addTask(Map<String, String> requestMap) {
        Call<String> stringCall = CommonRequestFactory.buildRetrofit().createServerInterface().addTask(requestMap);
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
