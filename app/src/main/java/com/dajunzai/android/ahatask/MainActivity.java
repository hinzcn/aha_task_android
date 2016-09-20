package com.dajunzai.android.ahatask;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.dajunzai.android.ahatask.fragment.BaseFragment;
import com.dajunzai.android.ahatask.fragment.CoinFragment;
import com.dajunzai.android.ahatask.fragment.HomeFragment;
import com.dajunzai.android.ahatask.fragment.MineFragment;
import com.dajunzai.android.ahatask.fragment.TaskFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hinzcn on 2016/9/19.
 * auther:caoyue
 * mail:hinzcn@gmail.com
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    //view
    private RadioGroup rg_main_controll;
    //recode
    private int position ;
    //data
    private List<BaseFragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initfragment();
        initview();
        init();
    }
    private void init() {
        rg_main_controll.check(R.id.rb_rg_home);
    }
    private void initfragment() {
        list=new ArrayList<BaseFragment>();
        list.add(new HomeFragment());
        list.add(new TaskFragment());
        list.add(new CoinFragment());
        list.add(new MineFragment());
    }

    private void initview() {
        rg_main_controll = (RadioGroup) findViewById(R.id.rg_main_controll);
        rg_main_controll.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_rg_home:
                position =0;
                break;
            case R.id.rb_rg_task:
                position =1;
                break;
            case R.id.rb_rg_coin:
                position =2;
                break;
            case R.id.rb_rg_mine:
                position =3;
                break;
        }
        changeFragment();
    }

    private void changeFragment() {
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_main_content,list.get(position),position+"mark");
        transaction.commit();
    }
}
