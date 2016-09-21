package com.dajunzai.android.ahatask.fragment;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.dajunzai.android.ahatask.R;
import com.dajunzai.android.ahatask.constant.CommonConstant;
import com.dajunzai.android.ahatask.model.CacheMapManager;
import com.dajunzai.android.ahatask.model.CommonHttpClient;
import com.dajunzai.android.ahatask.model.messagebean.AnyEventType;
import com.dajunzai.android.ahatask.persenter.TaskPersenter;
import com.dajunzai.android.ahatask.utils.CommonBean;
import com.dajunzai.android.ahatask.utils.Config;
import com.dajunzai.android.ahatask.view.AddTaskActivity;
import com.joanzapata.android.QuickAdapter;
import com.melnykov.fab.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hinzcn on 2016/9/20.
 * auther:caoyue
 * mail:hinzcn@gmail.com
 */
public class TaskFragment extends BaseFragment implements View.OnClickListener {

    private TaskPersenter taskPersenter;
    private ListViewCompat lv_fragment_home_tasklist;
    @Override
    public void initData() {
        taskPersenter.getTask();
    }

    public TaskFragment() {
        taskPersenter=new TaskPersenter(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =View.inflate(getActivity(), R.layout.task_fragment,null);
        Toolbar toolbar= (Toolbar) view.findViewById(R.id.toolbar);
        lv_fragment_home_tasklist = (ListViewCompat) view.findViewById(R.id.lv_fragment_home_tasklist);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToListView(lv_fragment_home_tasklist);
        fab.setOnClickListener(this);
        fab.show();
        return view;
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
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(AnyEventType event) {
        lv_fragment_home_tasklist.setAdapter(event.getQuickAdapter());
    };
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        Map map=new HashMap<String,String>();
        Intent intent = new Intent(getActivity(), AddTaskActivity.class);
        startActivity(intent);
      /*  $add["username"]=$_POST["username"];
        $add["content"]=$_POST["content"];
        $add["startdate"]=$_POST["startdate"];
        $add["deadline"]=$_POST["deadline"];
        $add["requiretime"]=$_POST["requiretime"];
        $add["level"]=$_POST["level"];*/
        /*taskPersenter.addTask(map);*/
    }
}
