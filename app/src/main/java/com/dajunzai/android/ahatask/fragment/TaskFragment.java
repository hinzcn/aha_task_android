package com.dajunzai.android.ahatask.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dajunzai.android.ahatask.constant.CommonConstant;
import com.dajunzai.android.ahatask.model.CacheMapManager;
import com.dajunzai.android.ahatask.model.CommonHttpClient;
import com.dajunzai.android.ahatask.utils.Config;

/**
 * Created by Hinzcn on 2016/9/20.
 * auther:caoyue
 * mail:hinzcn@gmail.com
 */
public class TaskFragment extends BaseFragment {
    @Override
    public void initData() {
        String username = (String) CacheMapManager.getCache(CommonConstant.CacheConstant.USERINFO);
            CommonHttpClient.toGetTaskList(Config.testUserName);

    }

    public TaskFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initData();
    }
}
