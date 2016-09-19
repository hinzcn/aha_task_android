package com.dajunzai.android.ahatask.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by li_zh on 2016/9/18.
 * 作者:李杰
 * 邮箱:577124196@qq.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    protected void init() {
        findViews();
        initData();
        getData();
    }

    protected abstract void initData();

    protected abstract void getData();
    protected abstract void findViews();

}
