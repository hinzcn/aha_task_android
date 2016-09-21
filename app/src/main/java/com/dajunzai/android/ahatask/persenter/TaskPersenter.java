package com.dajunzai.android.ahatask.persenter;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.dajunzai.android.ahatask.R;
import com.dajunzai.android.ahatask.constant.CommonConstant;
import com.dajunzai.android.ahatask.model.CacheMapManager;
import com.dajunzai.android.ahatask.model.CommonHttpClient;
import com.dajunzai.android.ahatask.model.domain.TaskListBean;
import com.dajunzai.android.ahatask.utils.Config;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hinzcn on 2016/9/21.
 * auther:caoyue
 * mail:hinzcn@gmail.com
 */
public class TaskPersenter  {
    private QuickAdapter adapter;
    private Fragment fragment;
    public TaskPersenter(Fragment fragment) {
        this.fragment=fragment;
    }
    public void getTask(){
      ;
        String username = (String) CacheMapManager.getCache(CommonConstant.CacheConstant.USERINFO);
        adapter= new QuickAdapter<TaskListBean.DatalistBean>(fragment.getActivity(),R.layout.list_layout, new ArrayList<TaskListBean.DatalistBean>()){
            @Override
            protected void convert(BaseAdapterHelper helper, TaskListBean.DatalistBean item) {
                helper.setText(R.id.tv_content,item.getContent()+"");
                helper.setText(R.id.tv_level,item.getLevel()+"");
                helper.setText(R.id.tv_deadline,item.getDeadline()+"");
                Log.e("TAG", ""+item);
            }
        };
        CommonHttpClient.toGetTaskList(Config.testUserName,adapter);

    }
    public void addTask(Map<String,String> map){

    };
}
